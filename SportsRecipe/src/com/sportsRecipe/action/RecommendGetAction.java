package com.sportsRecipe.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.sportsRecipe.util.ResultUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RecommendGetAction {

	private String vegetable;
	private static String zhPattern = "[\\u4e00-\\u9fa5]";

	public void recommend_get() throws MalformedURLException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();

		// String key1=vegetable;
		// String vegetable=new String(key1.getBytes("ISO8859-1"), "UTF-8");
		String url = "http://apis.haoservice.com/lifeservice/cook/query?menu=" + vegetable
				+ "&pn=1&rn=1&key=7f9b2d5760f0407b9304101b913ff494";

		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(encode(url, "UTF-8"));
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		map.put("json", json.toString());
		ResultUtils.toJson(ServletActionContext.getResponse(), map);

	}

	/**
	 * 替换字符串卷
	 * 
	 * @param str
	 *            被替换的字符串
	 * @param charset
	 *            字符集
	 * @return 替换好的
	 * @throws UnsupportedEncodingException
	 *             不支持的字符集
	 */
	public static String encode(String str, String charset) throws UnsupportedEncodingException {
		Pattern p = Pattern.compile(zhPattern);
		Matcher m = p.matcher(str);
		StringBuffer b = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(b, URLEncoder.encode(m.group(0), charset));
		}
		m.appendTail(b);
		return b.toString();
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}

}
