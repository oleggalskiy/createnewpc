package by.epam.labproject.createmypc.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class MainLogFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Main log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
                + ", URL =" + req.getRequestURL());


        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Main log filter destroy");
    }
}
