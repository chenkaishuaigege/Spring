package com.rrtx.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ProConst {

	private static Properties pps;

	private static Properties activityProfiles;

	private static String activityProfilesName = "";

	public ProConst() {
	}

	/**
	 * 获取param.properties中的值
	 *
	 * @param key
	 *            要获取的键
	 * @return
	 */
	public static String getValue(String key){
		try {
		if (pps == null) {
				pps = new Properties();
				final String PATH = "/Users/chenkai/IdeaProjects/Spring/UnionpayV_1/src/main/resources/configuration.properties";
				pps.load(new FileInputStream(PATH));
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pps.getProperty(key);
	}

}
