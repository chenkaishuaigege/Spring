package com.rrtx.util;

import com.alibaba.fastjson.JSON;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;

public class SerializeUtil {

    /**
     * 将Java对象序列化成为JSON格式
     * @param msgInfo
     * @return
     */
    public static String serialize(Object msgInfo){

        String employeeJson = JSON.toJSONString(msgInfo);
        return employeeJson;
    }

    /**
     * 将JSON格式反序列化为对象
     * @param classType
     * @param employeeJson
     * @return
     */
    public static Object deserialize(Class<?> classType, String employeeJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(employeeJson, classType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


