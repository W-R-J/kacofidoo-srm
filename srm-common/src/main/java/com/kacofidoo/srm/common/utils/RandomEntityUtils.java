/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

/**
 * @author Jeff.Tsai
 * 
 */
public class RandomEntityUtils {

	public static <T> T next(Class<T> clazz, String... ignores) {
		T obj = null;
		try {
			obj = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for (Method foo : methods) {
				String fieldName = foo.getName().substring(3);
				if (ArrayUtils.contains(ignores, StringUtils.uncapitalize(fieldName))) {
					continue;
				}
				int mod = foo.getModifiers();
				if (Modifier.isPublic(mod) && !Modifier.isStatic(mod) && foo.getName().startsWith("set")) {
					Class<?>[] types = foo.getParameterTypes();
					if (types.length == 1) {
						Class<?> type = types[0];
						if (type == String.class) {
							foo.invoke(obj, RandomStringUtils.randomAlphanumeric(8));
						} else if (type == Integer.class || type == int.class) {
							foo.invoke(obj, RandomUtils.nextInt(10000));
						} else if (type == Long.class || type == long.class) {
							foo.invoke(obj, (long) RandomUtils.nextInt(10000));
						} else if (type == Short.class || type == short.class) {
							foo.invoke(obj, (short) RandomUtils.nextInt(10000));
						} else if (type == Date.class) {
							foo.invoke(obj, new Date());
						} else if (type == Float.class || type == float.class) {
							foo.invoke(obj, RandomUtils.nextFloat());
						} else if (type == Double.class || type == double.class) {
							foo.invoke(obj, RandomUtils.nextDouble());
						} else if (type == Boolean.class || type == boolean.class) {
							foo.invoke(obj, RandomUtils.nextBoolean());
						} else if (type == Timestamp.class) {
							foo.invoke(obj, new Timestamp(System.currentTimeMillis()));
						} else if (type == java.sql.Date.class) {
							foo.invoke(obj, new java.sql.Date(System.currentTimeMillis()));
						} else {
							// TODO add other cases
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
