/**
 * @Title: Filter0_EncodingFilter.java
 * @Package com.myblog.blog.filter
 * @Description: filter
 * @author: ZSZ
 * @date: 2019/7/27 20:05 PM
 * @version 1.0
 *
 */
package com.myblog.blog.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: Filter0_EncodingFilter
 * @description: 字符集过滤器
 * @author: ZSZ
 * @date: 2019/7/27 20:05
 */
@WebFilter(urlPatterns = "/*",filterName = "Filter0_EncodingFilter")
public class Filter0_EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
