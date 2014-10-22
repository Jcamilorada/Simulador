package simulator.configuration;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class CORSFilterTest
{
    @Mock
    ServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    FilterChain chain;

    private CORSFilter testInstance = new CORSFilter();

    @Test
    public void testDoFilter() throws IOException, ServletException
    {
        MockitoAnnotations.initMocks(this);

        testInstance.doFilter(request, response, chain);
        verify(response).setHeader(CORSFilter.ALLOW_HEADER, CORSFilter.ALLOW_HEADER_VALUE);
        verify(response).setHeader(CORSFilter.ALLOW_METHODS_HEADER, CORSFilter.ALLOW_METHODS_HEADER_VALUE);
        verify(response).setHeader(CORSFilter.ALLOW_ORIGIN_HEADER, CORSFilter.ALLOW_ORIGIN_HEADER_VALUE);
        verify(response).setHeader(CORSFilter.MAX_AGE_HEADER, CORSFilter.MAX_AGE_HEADER_VALUE);
    }
}
