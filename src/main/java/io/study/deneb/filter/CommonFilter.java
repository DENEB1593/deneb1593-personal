package io.study.deneb.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.deneb.controller.CommonResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class CommonFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(CommonFilter.class);
    private static ObjectMapper om = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) { }

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        try {
            log.info("===== Common Filter ====");
            chain.doFilter(request, response);
        } catch (Exception e) {
            setResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, e);
        }

    }

    private static void setResponse(ServletResponse response,
                                   HttpStatus status,
                                   Throwable e) throws IOException {
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setStatus(status.value());
        String errorBody = om.writeValueAsString(CommonResponse.error("filter Error"));
        servletResponse.getOutputStream().write(errorBody.getBytes());
    }
}
