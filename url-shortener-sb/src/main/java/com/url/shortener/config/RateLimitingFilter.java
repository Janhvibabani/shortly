package com.url.shortener.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class RateLimitingFilter implements Filter {

    private final ConcurrentMap<String, Bucket> buckets = new ConcurrentHashMap<>();

    private Bucket resolveBucket(String clientId) {
        return buckets.computeIfAbsent(clientId, id -> {

            Bandwidth limit = Bandwidth.builder()
                    .capacity(5)                                       // bucket size = 5
                    .refillIntervally(1, Duration.ofMinutes(1))       // +1 token per minute
                    .build();

            return Bucket.builder()
                    .addLimit(limit)
                    .build();
        });
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        if ("OPTIONS".equalsIgnoreCase(httpReq.getMethod())) {
            chain.doFilter(request, response);
            return;
        }
        String clientIp = httpReq.getRemoteAddr();
        Bucket bucket = resolveBucket(clientIp);

        if (bucket.tryConsume(1)) {
            chain.doFilter(request, response);
        } else {
            httpRes.setStatus(429);
            httpRes.setHeader("Access-Control-Allow-Origin", "*");
            httpRes.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            httpRes.setHeader("Access-Control-Allow-Headers", "*");

            httpRes.getWriter().write("Too many attempts. Try again later.");
        }
    }
}
