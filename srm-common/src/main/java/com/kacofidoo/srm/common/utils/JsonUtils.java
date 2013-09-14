package com.kacofidoo.srm.common.utils;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonUtils {

	private static Gson gson;

	private JsonUtils() {
	}

	static {
		GsonBuilder gb = new GsonBuilder();
		gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		gson = gb.create();
	}

	public static final String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static final <T> T fromJson(final String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	@SuppressWarnings("unchecked")
	public static final Map<String, Object> fromJson(final String json) {
		return fromJson(json, Map.class);
	}

}
