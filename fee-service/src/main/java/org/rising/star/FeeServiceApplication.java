package org.rising.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
public class FeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeeServiceApplication.class, args);
	}
	
	/*
	 * @Bean public Sampler defaultSampler() { return Sampler.ALWAYS_SAMPLE; }
	 */

}
