package com.assp.common.utils;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class RedisCacheUtil {
	private static String cacheName ;
	
	private static Boolean init = true;

	public static String getCacheName() {
		return cacheName;
	}
	public static void setCacheName(String cacheName) {
		RedisCacheUtil.cacheName = cacheName;
	}
	
	@SuppressWarnings("unused")
	private synchronized static void init() {
		if (init) {
			synchronized (init) {
				if (init) {
					init = false;
				}
			}
		}
	}
	
	
	public static Cache<String, Object> getRedisCache() {
		WebApplicationContext wc = ContextLoader.getCurrentWebApplicationContext();
		AbstractCacheManager cacheManager = wc.getBean(AbstractCacheManager.class);
		Cache<String, Object> redisCache = cacheManager.getCache(cacheName);
		return redisCache;
	}
}
