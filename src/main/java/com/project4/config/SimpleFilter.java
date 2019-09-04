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
        public void destroy() {}

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
                throws IOException, ServletException {
         /*   HttpServletRequest httpServletRequest = (HttpServletRequest)request;
           Cookie[] cookies = httpServletRequest.getCookies();
           for (int i=0 ; i<cookies.length ; i++){
              if ("21232f297a57a5a743894a0e4a801fc3".equals(cookies[i].toString()));
               filterchain.doFilter(request, response);
           }
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendError(417);*/

            filterchain.doFilter(request, response);
        }

        @Override
        public void init(FilterConfig filterconfig) throws ServletException {}
    }

