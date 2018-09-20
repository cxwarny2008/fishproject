package com.tyb.fishhost.expand;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器
 * 监听器是一个专门用于对其他对象身上发生的事件或状态改变进行监听和相应处理的对象，当被监视的对象发生情况时，立即采取相应的行动。通俗的讲，监听器就比如你盯着一盘好吃的，有人拿你的吃的的时候，你会立马采取相应的行动。
 *
 * @author 陈小伟
 */
@WebListener
public class RequestListenter implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求创建");
    }
}
/*
1.ServletContextListener -- 监听servletContext对象的创建以及销毁

    1.1    contextInitialized(ServletContextEvent arg0)   -- 创建时执行

    1.2    contextDestroyed(ServletContextEvent arg0)  -- 销毁时执行

2.HttpSessionListener  -- 监听session对象的创建以及销毁

    2.2   sessionCreated(HttpSessionEvent se)   -- 创建时执行

    2.2   sessionDestroyed(HttpSessionEvent se) -- 销毁时执行

3.ServletRequestListener -- 监听request对象的创建以及销毁

    3.1    requestInitialized(ServletRequestEvent sre) -- 创建时执行

    3.2    requestDestroyed(ServletRequestEvent sre) -- 销毁时执行

4.ServletContextAttributeListener  -- 监听servletContext对象中属性的改变

    4.1    attributeAdded(ServletContextAttributeEvent event) -- 添加属性时执行

    4.2    attributeReplaced(ServletContextAttributeEvent event) -- 修改属性时执行

    4.3    attributeRemoved(ServletContextAttributeEvent event) -- 删除属性时执行

5.HttpSessionAttributeListener  --监听session对象中属性的改变

    5.1    attributeAdded(HttpSessionBindingEvent event) -- 添加属性时执行

    5.2    attributeReplaced(HttpSessionBindingEvent event) -- 修改属性时执行

    5.3    attributeRemoved(HttpSessionBindingEvent event) -- 删除属性时执行

6.ServletRequestAttributeListener  --监听request对象中属性的改变

    6.1    attributeAdded(ServletRequestAttributeEvent srae) -- 添加属性时执行

    6.2    attributeReplaced(ServletRequestAttributeEvent srae) -- 修改属性时执行

    6.3    attributeRemoved(ServletRequestAttributeEvent srae) -- 删除属性时执行
 */