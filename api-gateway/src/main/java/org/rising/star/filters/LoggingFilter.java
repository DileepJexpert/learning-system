package org.rising.star.filters;

import org.rising.star.config.ApiGatewayConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter{
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		log.info("filter chaing --------"+exchange.getRequest().getPath());
		log.debug("filter chaing --------"+exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
