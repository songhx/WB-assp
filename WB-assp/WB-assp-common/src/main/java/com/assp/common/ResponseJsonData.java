package com.assp.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
 * 类简述
 * <p>
 * 返回json结果集规范
 * </p>
 * 
 * @Company 动力威视
 * @Copyright
 * @author (wangzhipeng@sxw100.com)
 * @version 1.0
 * @CreateDate 2016年7月6日 上午14:45
 */
public class ResponseJsonData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//返回code,0为不成功，1为成功（默认）
	private int code = 1;
	//返回的消息
	private String messsage;
	//需要直接返回结果码时，直接放result里
	private String result;
	//数据
	private JSONObject datas = null;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	public JSONObject getDatas() {
		return datas;
	}
	public void setDatas(JSONObject datas) {
		this.datas = datas;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	/**添加数据层数据以key-value形式
	 * @param key
	 * @param val
	 */
	public void addData(String key,Object val){
		if(datas == null){
			datas = new JSONObject();
		}
		datas.put(key, val);
	}
	
	/**返回json串
	 * @return
	 */
	public String generateResultStr(){
		return JSONObject.toJSONString(this);
	}
	
}