package simulator.configuration;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cross-site http request filter. Enable to use the get and send data to the rest service (simulator) application.
 */
@Component
public class CORSFilter implements Filter
{

    static final String ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";
    static final String ALLOW_ORIGIN_HEADER_VALUE = "*";

    static final String ALLOW_METHODS_HEADER = "Access-Control-Allow-Methods";
    static final String ALLOW_METHODS_HEADER_VALUE = "POST, GET, OPTIONS, DELETE";

    static final String MAX_AGE_HEADER = "Access-Control-Max-Age";
    static final String MAX_AGE_HEADER_VALUE = "3600";

    static final String ALLOW_HEADER = "Access-Control-Allow-Headers";
    static final String ALLOW_HEADER_VALUE = "x-requested-with";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader(ALLOW_ORIGIN_HEADER, ALLOW_ORIGIN_HEADER_VALUE);
        response.setHeader(ALLOW_METHODS_HEADER, ALLOW_METHODS_HEADER_VALUE);
        response.setHeader(MAX_AGE_HEADER, MAX_AGE_HEADER_VALUE);
        response.setHeader(ALLOW_HEADER, ALLOW_HEADER_VALUE);
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig)
    {
    }

    @Override
    public void destroy()
    {
    }
}