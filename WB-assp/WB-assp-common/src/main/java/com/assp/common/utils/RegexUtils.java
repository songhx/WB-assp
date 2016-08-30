/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.assp.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	public static boolean isAlphaUnderline(String msg) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
		Matcher matcher = pattern.matcher(msg);
		return matcher.matches();
	}

	public static void main(String[] args) {
		//RegexUtils.isAlphaUnderline("ddd3_dd444美丽");
		//RegexUtils.isMobileNO("13391696254");
	}
	
	public static boolean isMobileNO(String mobiles){
		//Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");  
		Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$"); 
		Matcher m = p.matcher(mobiles);  
		  
		System.out.println(m.matches()+"---");  
		  
		return m.matches();  
	}
	
	public static boolean isEmail(String email){
		Pattern p = Pattern.compile("^([a-z0-9-_])+@([a-z0-9])+.[a-z]{2,3}$"); 
		Matcher m = p.matcher(email); 
		System.out.println(m.matches()+"---");  
		return m.matches();
	}
}
