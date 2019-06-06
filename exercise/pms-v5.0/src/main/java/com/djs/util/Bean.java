package com.djs.util;

import java.util.HashMap;
import java.util.Map;

public class Bean {
	private static Map<Class<?>, Object> cache = new HashMap<>();
	
	public static synchronized Object getBean(Class<?> clazz) {
		if(cache.get(clazz)==null) {
			Object obj = null;
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
			
				e.printStackTrace();
			}
			cache.put(clazz, obj);
		}
		return cache.get(clazz);
	}
}
