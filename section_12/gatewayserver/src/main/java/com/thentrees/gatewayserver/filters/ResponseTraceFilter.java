package com.thentrees.gatewayserver.filters;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;


/*
 * @author: Thentrees
 * @since: 01/08/2024 : 23:01
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@Configuration
@RequiredArgsConstructor
public class ResponseTraceFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);
    private final FilterUtility filterUtility;

    @Bean
    public GlobalFilter postGlobalFilter(){
        return ((exchange, chain) -> {
           return chain.filter(exchange).then(Mono.fromRunnable(()->{
               HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
               String correlationId = filterUtility.getCorrelationId(requestHeaders);
               if(!(exchange.getResponse().getHeaders().containsKey(filterUtility.CORRELATION_ID))) {
                   logger.debug("Update the correlation id in to the outbound headers: {}", correlationId);
                   exchange.getResponse().getHeaders().add(filterUtility.CORRELATION_ID, correlationId);
               }
           }));
        });
    }
}
