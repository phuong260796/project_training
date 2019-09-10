package com.project4.config;

import org.springframework.stereotype.Component;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Component
public class SimpleFilter implements Filter {


    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {
        filterchain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterconfig) {

    }
}

