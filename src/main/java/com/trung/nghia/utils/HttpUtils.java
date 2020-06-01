package com.trung.nghia.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	private String values;

	public HttpUtils(String values) {
		this.values = values;
	}

	public <T> T toModel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(values, tclass);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		return null;

	}

	public static HttpUtils of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return new HttpUtils(sb.toString());
	}

}
