package com.nmote.oembed;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ToJsonString {

	public static String toJsonString(Object object) {
		if (object == null) {
			return "null";
		}

		synchronized (ToJsonString.class) {
			if (mapper == null) {
				mapper = new ObjectMapper();
				mapper.setSerializationInclusion(Include.NON_NULL);
			}
		}

		try {
			String json = mapper.writeValueAsString(object);
			int len = json.length();
			StringBuffer buffer = new StringBuffer(len + 40);
			buffer.append(object.getClass().getSimpleName());
			buffer.append('(');
			buffer.append(json.substring(1, len - 1));
			buffer.append(')');
			return buffer.toString();
		} catch (JsonProcessingException e) {
			System.err.println(e);
			return Objects.toString(object);
		}
	}

	private static ObjectMapper mapper;
}
