package com.assp.common;

/**
 * 
* @Description: 错误类型
*
* @param:参数描述
* @return：返回结果描述
* @throws：异常描述
*
* @version: v1.0.0
* @author: Xuxuesen
* @date: 2013-03-04 下午12:06:02 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
*2013-03-04     Xuxuesen           v1.0.0               创建
 */

public enum ErrorType implements ErrorCode {

	PARAM_VERIFY(1000,"参数验证失败"),
	TOKEN_NEEDED(1001,"没有传递令牌"),

	OPERATE_DENIED(2000,"不允许当前操作"),
	OBJECT_EXISTS(2001,"保存的数据已经存在"),
	OBJECT_CANNOT_DELETE(2002,"该数据不允许删除"),
	
	USER_NOT_EXIST(3000, "用户不存在"),
	USER_PASSWORD_ERROR(3001, "用户密码错误"),
	USER_LOCKED(3002, "用户被锁定"),
	USER_DISABLED(3003, "用户被停用"),
	USER_NONACTIVE(3004, "用户未激活"),
	USER_DELETED(3005, "用户被逻辑删除"),
	INTERFACE_PARAMNULL(999900000, "参数为空"),
	INTERFACE_RUNTIME(999900001, "接口连接超时"),
	INTERFACE_ERRORURL(999900002, "出现了错误的 URL"),
	INTERFACE_IOEXCEPT(999900003, "IO异常"),
	INTERFACE_DOCMENTEXCEPT(999900004, "返回数据格式异常"),
	INTERFACE_NOTFINDURL(999900005, "没有查到相关的接口链接"),
	INTERFACE_SERVICESMS(999900006, "service对象创建异常"),
	INTERFACE_REMOTESMS(999900007, "远程调用异常"),
	INTERFACE_OK(00, "接口正常");
	private int value;
	private String msg;
	private ErrorType(int value,String msg){
		this.value=value;
		this.msg=msg;
	}
	public int value(){
		return this.value;
	}
	public String getMsg(){
		return this.msg;
	}
	
	
	
}
