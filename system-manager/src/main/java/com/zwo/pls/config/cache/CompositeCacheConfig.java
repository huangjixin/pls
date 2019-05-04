package com.zwo.pls.config.cache;

import java.net.UnknownHostException;
import java.time.Duration;
import java.util.List;

//import org.springframework.cache.CacheManager;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

@Configuration
public class CompositeCacheConfig {

//	@Bean(name = "ehcacheCacheManager")
//	public EhCacheCacheManager ehcacheCacheManager(EhCacheManagerFactoryBean bean) {
//		return new EhCacheCacheManager(bean.getObject());
//	}
//
//	@Bean
//	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//		cacheManagerFactoryBean.setShared(true);
//		return cacheManagerFactoryBean;
//	}
//
//	@Bean(name = "simpleCacheManager")
//	public ConcurrentMapCacheManager simpleCacheManager() {
//		return new ConcurrentMapCacheManager();
//	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		template.setDefaultSerializer(jackson2JsonRedisSerializer);
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		template.setKeySerializer(stringRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean(name = "redisCacheManager")
	public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
		return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
	}

	@Bean
	public CompositeCacheManager cacheManager(
//			ConcurrentMapCacheManager simpleCacheManager, EhCacheCacheManager ehcacheCacheManager,
			RedisCacheManager redisCacheManager) {
		CompositeCacheManager cacheManager = new CompositeCacheManager();
		cacheManager.setFallbackToNoOpCache(false);

		List<CacheManager> cacheManagers = Lists.newArrayList();
		cacheManagers.add(redisCacheManager);
//		cacheManagers.add(simpleCacheManager);// 顺序决定默认管理器
//		cacheManagers.add(ehcacheCacheManager);
		

		cacheManager.setCacheManagers(cacheManagers);
		return cacheManager;
	}
}