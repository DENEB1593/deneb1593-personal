package io.study.deneb.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class SampleInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SampleInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        log.info("======== interceptor start ========");


        return true;
    }
}
