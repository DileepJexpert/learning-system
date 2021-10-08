package org.rising.star.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ApiGatewayConfiguration {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ApiGatewayConfiguration.class);

	//@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
	//	log.info("Surcharge Caliculation begins");
	   // log.debug("Surcharge amount " + builder);
	    System.out.println("----------------------------");
		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("fee-service/api/fee/**").filters(
				f -> f.addRequestHeader("MyHeaderKey", "MyHeaderValue").addRequestParameter("MyParam", "myparamvalue"))
				.uri("lb://fee-service");
		return builder.routes().route(routeFunction).build();

	}

}
