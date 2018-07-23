package com.uppi.poc;

import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories(basePackages="com.uppi.poc")
@ImportResource("classpath:application-redis-context.xml")
public class RedisRepoConfiguration {

}
