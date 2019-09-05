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
	public static String getValue(String key) throws IOException {
		if (pps == null) {
				pps = new Properties();

				final String PATH = ProConst.class.getResource("/").getPath() + "/configuration.properties";

				pps.load(new FileInputStream(PATH));
		}
		return pps.getProperty(key);
	}

	public static void main(String[] args) throws IOException {
		String fsadf = getValue("union_cert_publicKey");
		System.out.println(fsadf);
		String fsadf2 = getValue("union_cert_publicKey");
		System.out.println(fsadf2);
	}
}
