package by.epam.labproject.createmypc.controller.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class MainLogFilter implements Filter {

    private final static Logger logger = Logger.getLogger(MainLogFilter.class.getSimpleName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Main log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();

        logger.info("#INFO " + new Date() + " - ServletPath :" + servletPath //
                + ", URL =" + req.getRequestURL());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        logger.info("Main log filter destroy");
    }
}
