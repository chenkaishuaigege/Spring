package com.rrtx.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhangting
 */
public class JsonMapCoverUtill {

	/**
	 * 将json字符串转换成map
	 * @param object
	 * @return map
	 */
	public static Map<String, Object> coverJsonString2Map(String object) {

		try {
			JSONObject jsonObj = new JSONObject(object);
			Iterator it = jsonObj.keys();
			Map<String, Object> map = new HashMap<String, Object>();
			while(it.hasNext()){
				String key = it.next().toString();
				map.put(key, jsonObj.get(key));
			}
			return map;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将map转换成json字符串
	 * @param map
	 * @return json字符串
	 */
	public static String coverMap2JsonString(Map<String, Object> map) {
		JSONObject jsonObj = new JSONObject();
		Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			try {
				jsonObj.put(entry.getKey(), entry.getValue());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObj.toString();

	}
	/**
	 * 将String转换成Map
	 * @param string
	 * @return
	 */
	public static Map<String, Object> coverString2Map(String string) {
		Map<String, Object> map = new HashMap<String, Object>();
		string = string.replace(" ", "");
		String[] arr = string.split(",");
		for (String str : arr) {
			String[] params = str.split("=");
			if(params.length>1){
				String key = params[0];
				String value = params[1];
				map.put(key, value);
			} 
		}
		return map;
	}
}
