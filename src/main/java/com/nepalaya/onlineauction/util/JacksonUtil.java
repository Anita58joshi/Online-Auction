package com.nepalaya.onlineauction.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
    public static <T> String toJsonObj(T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
