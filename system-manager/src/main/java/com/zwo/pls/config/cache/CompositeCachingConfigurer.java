package com.zwo.pls.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositeCachingConfigurer 
implements CachingConfigurer 
{

	@Autowired(required = false)
	private CompositeCacheManager cacheManager;

	@Override
	public CacheManager cacheManager() {
		return cacheManager;
	}

	@Bean
	@Override
	public CacheResolver cacheResolver() {
		return new SimpleCacheResolver(cacheManager);
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

	@Override
	public CacheErrorHandler errorHandler() {
		return null;
	}

}