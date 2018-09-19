package com.tyb.fishhost.expand;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 自定义Filter
 */
@Component
@WebFilter(urlPatterns = {"/*"},filterName = "authorFilter")
public class AuthorFilter implements Filter {

    /**
     * web容器启动时init，只调用一次
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤器实际处理类
     * @param servletRequest
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        String token=req.getHeader("token");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        BaseResponse res = new BaseResponse();
        boolean isTokenValid=false;
        if(null==token || token.isEmpty())
        {
            res.setSuccess(false);
            res.setCode("403");
            res.setMessage("token没有认证通过!原因为：客户端请求参数中无token信息");
        }
        else
        {
            res.setSuccess(true);
            //验证有效性逻辑
            isTokenValid=true;
        }

        if(!res.isSuccess()){
            PrintWriter writer = null;
            OutputStreamWriter osw = null;
            try {
                osw = new OutputStreamWriter(response.getOutputStream() , "UTF-8");
                writer = new PrintWriter(osw, true);
                String jsonStr = JSON.toJSONString(res);
                writer.write(jsonStr);
                writer.flush();
                writer.close();
                osw.close();
            } catch (UnsupportedEncodingException e) {

            } catch (IOException e) {

            } finally {
                if (null != writer) {
                    writer.close();
                }
                if(null != osw){
                    osw.close();
                }
            }
            return;
        }
        if(isTokenValid)
        {
            filterChain.doFilter(servletRequest, response);
        }
    }

    /**
     *卸载filter的时候执行一次
     */
    @Override
    public void destroy() {

    }
}
