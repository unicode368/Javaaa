package com.example.faculty.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {

    public void init(FilterConfig config) {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getParameter("language") != null) {
            request.getSession().setAttribute("language",
                    request.getParameter("language"));
        } else if (request.getSession().getAttribute("language") == null) {
            request.getSession().setAttribute("language", new Locale("ua"));
        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
