package com.assp.common.utils;   

import javax.servlet.http.HttpServletRequest;

/**
 * 类简述
 * <p>
 *       IP 处理工具类
 * </p>
 * 
 * @Company 动力威视
 * @Copyright
 * @author (shx@sxw100.com)
 * @version 1.0
 * @CreateDate 2016年4月20日 上午10:09:09 
 */
public class IPUtils {
	
    /**
	 *   获取用户请求中携带的IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {      
        String ip = request.getHeader("x-forwarded-for");      
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
            ip = request.getHeader("Proxy-Client-IP");      
        }     
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
            ip = request.getHeader("WL-Proxy-Client-IP");     
        }     
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
            ip = request.getRemoteAddr();      
        }   
       return ip;     
    }
	
	
}
  