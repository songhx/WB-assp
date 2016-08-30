package com.assp.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
	private volatile static PropertiesUtil newInstance = null;
	private static Map<String,Object> proptisMap ;
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getInstance() throws Exception{
		if(newInstance == null){
			synchronized(PropertiesUtil.class){
				if(newInstance == null){
					newInstance = new PropertiesUtil();
				}
			}
		}
		return (Map<String,String>)proptisMap.get("/dbConfig.properties");
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getInstance(String path) throws Exception{
		if(newInstance == null){
			synchronized(PropertiesUtil.class){
				if(newInstance == null){
					newInstance = new PropertiesUtil(path);
				}
			}
		} else {
			if(newInstance.getProptisMap().get(path) == null){
				synchronized(PropertiesUtil.class){
					if(newInstance.getProptisMap().get(path) == null){
						newInstance.loadProperties(path);
					}
				}
			}
		}
		
		return (Map<String,String>)proptisMap.get(path);
	}
	
	private PropertiesUtil() throws Exception{
		this.loadProperties("/dbConfig.properties");
	}
	
	private PropertiesUtil(String path) throws Exception{
		this.loadProperties(path);
	}
	
	private void loadProperties(String path) throws Exception{
		Properties prop =  new  Properties();
		InputStream in = getClass().getClassLoader().getResourceAsStream(path);
		Map<String,String> map = new HashMap<String,String>();
		try{
			prop.load(in);
			@SuppressWarnings("rawtypes")
			Enumeration en = prop.keys();
			while(en.hasMoreElements()){
				String name = en.nextElement().toString();
				String value = prop.getProperty(name).trim();
				map.put(name, value);
			}
			in.close();
			
			if(proptisMap == null || proptisMap.isEmpty()){
				proptisMap = new HashMap<String,Object>();
			}
			proptisMap.put(path, map);
		} catch(IOException e){
			throw new Exception();
		}
	}

	private Map<String, Object> getProptisMap() {
		return proptisMap;
	}

	@SuppressWarnings({ "static-access", "unused" })
	private void setProptisMap(Map<String, Object> proptisMap) {
		this.proptisMap = proptisMap;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Map<String,String> proptis = PropertiesUtil.getInstance("/redis.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
