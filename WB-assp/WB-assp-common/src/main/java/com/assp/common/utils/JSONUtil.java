package com.assp.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**json对象转换
 * 
 * @author --wzp
 * 
 */
public class JSONUtil {

	/**过滤对象属性
	 * @param per 被转换对象
	 * @param need 需要转换的属性集合，null为默认没限制
	 * @param notneed 不需要转换的属性集合，null为默认没限制
	 * @return
	 */
	public static JSONObject fromObject(Object per, String[] need,
			String[] notneed) {
		JSONObject oj = (JSONObject) JSONObject.toJSON(per);
		try {
			// 当有过滤条件时则要过滤
			if (!oj.isEmpty() && (need != null || notneed != null)) {
				List<String> arr = new ArrayList<String>(oj.keySet());
				Iterator<String> it = arr.iterator();
				while (it.hasNext()) {
					String key = it.next();
					//需要和不需要都不为空时取交集，
					if (need != null && notneed != null && contains(need, key) && !contains(notneed, key)
							|| notneed == null && need != null && contains(need, key) 
							|| need == null && notneed != null && !contains(notneed, key))
						continue;
					oj.remove(key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oj;
	}
	
	/**copy对象
	 * @param per 目的
	 * @param oj  源
	 * @param need 需要转换的属性集合，null为默认没限制
	 * @param notneed 不需要转换的属性集合，null为默认没限制
	 */
	public static void copyfromJson(Object per,JSONObject oj) {
		copyfromJson(per,oj,null,null);
	}
	/**copy对象
	 * @param per 目的
	 * @param oj  源
	 * @param need 需要转换的属性集合，null为默认没限制
	 * @param notneed 不需要转换的属性集合，null为默认没限制
	 */
	public static void copyfromJson(Object per,JSONObject oj, String[] need,
			String[] notneed) {
		
		if(oj == null || oj.isEmpty())
			return;
		
		try {
			// 当有过滤条件时则要过滤
			if (!oj.isEmpty()) {
				List<String> arr = new ArrayList<String>(oj.keySet());
				Iterator<String> it = arr.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (need != null && !contains(need, key) || notneed != null
							&& contains(notneed, key))
						continue;
					ObjectManagerUtil.set(per, key, oj.get(key));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean contains(String[] st, String st_) {
		for (String s_ : st) {
			if (s_.equalsIgnoreCase(st_))
				return true;
		}
		return false;
	}
}