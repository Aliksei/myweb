package com.webApp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter( urlPatterns = { "/main.jsp" },initParams = { @WebInitParam(name = "INDEX_PATH", value = "login.jsp") })
public class MainPageFilter implements Filter{

    private String indexPath;
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        indexPath = filterConfig.getInitParameter("INDEX_PATH");
        context = filterConfig.getServletContext();
        context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String user = (String) httpRequest.getSession().getAttribute("user");
        if( user == null ){

            context.log("Unauthorized access request");
            context.log("Redirecting to Login page");
            httpResponse.sendRedirect(indexPath);
        }else{
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
