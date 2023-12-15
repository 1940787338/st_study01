package com.mobin.carbon.filter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 啊彬
 */

@Component
@Order(1)
@WebFilter(filterName = "CoresFilter", urlPatterns = "/*")
public class CoresFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //表示所有的域都可以接受
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许所有的方法
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT,OPTIONS");
        //请求得到结果的有效期
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,access-control-allow-origin,version-info");
        //该值是一个boolean值,表示允许发送cookie，默认情况下cookie不包含在cores中，设置为true
        response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }


}



