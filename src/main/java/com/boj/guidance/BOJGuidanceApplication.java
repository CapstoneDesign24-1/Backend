package com.boj.guidance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableRedisHttpSession
public class BOJGuidanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BOJGuidanceApplication.class, args);
	}

}
