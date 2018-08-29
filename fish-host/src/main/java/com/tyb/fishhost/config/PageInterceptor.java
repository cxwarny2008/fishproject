package com.tyb.fishhost.config;

import com.tyb.fish.model.QueryFilter;
import com.tyb.fish.model.PageaResult;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 签名里要拦截的类型只能是接口。
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PageInterceptor implements Interceptor {

    private ThreadLocal<QueryFilter> queryFilterThreadLocal = new ThreadLocal<QueryFilter>();

    private String paramName = "delegate.boundSql.parameterObject.filte";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            if (!metaStatementHandler.hasSetter(paramName)) {
                return invocation.proceed();
            }
            Object paramObj = metaStatementHandler.getValue(paramName);
            if (!(paramObj instanceof QueryFilter)) {
                return invocation.proceed();
            }
            queryFilterThreadLocal.set((QueryFilter) paramObj);
            // 分离代理对象链(由于目标类可能被多个插件拦截，从而形成多次代理，通过下面的两次循环
            // 可以分离出最原始的的目标类)
            while (metaStatementHandler.hasGetter("h")) {
                Object object = metaStatementHandler.getValue("h");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            // 分离最后一个代理对象的目标类
            while (metaStatementHandler.hasGetter("target")) {
                Object object = metaStatementHandler.getValue("target");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            //分页信息if (localPage.get() != null) {
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            // 分页参数作为参数对象parameterObject的一个属性
            String sql = boundSql.getSql();
            // 重写sql
            String pageSql = buildPageSql(sql, queryFilterThreadLocal.get());
            //重写分页sql
            metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
            Connection connection = (Connection) invocation.getArgs()[0];
            // 重设分页参数里的总页数等
            setPageParameter(sql, connection, mappedStatement, boundSql, queryFilterThreadLocal.get());
            // 将执行权交给下一个插件
            return invocation.proceed();
        } else if (invocation.getTarget() instanceof ResultSetHandler) {
            Object resultList = invocation.proceed();
            QueryFilter queryFilter = queryFilterThreadLocal.get();
            if (queryFilter != null) {
                PageaResult<?> pageaResult = new PageaResult(queryFilter);
                pageaResult.setResult((List) resultList);
                return pageaResult;
            }
            return resultList;
        }
        return null;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    /**
     * 修改原SQL为分页SQL
     *
     * @param sql
     * @param page
     * @return
     */
    private String buildPageSql(String sql, QueryFilter page) {
        StringBuilder pageSql = new StringBuilder(200);
        pageSql.append("select * from (");
        pageSql.append(sql);
        pageSql.append(" ) temp limit ").append(page.getBeginRow());
        pageSql.append(" , ").append(page.getEndRow());
        return pageSql.toString();
    }

    /**
     * 获取总记录数
     *
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
                                  BoundSql boundSql, QueryFilter page) throws SQLException {
        // 记录总记录数
        String countSql = "select count(0) from (" + sql + ") temp";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            page.setTotalRecord(totalCount);
        } finally {
            if (rs != null) {
                rs.close();
            }
            countStmt.close();
        }
    }

    /**
     * 代入参数值
     *
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}