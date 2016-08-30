package com.assp.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;



/**
 * 对象反射工作
 * @author wangzhipeng
 *
 */
public class ObjectManagerUtil {
	
	/**
	 * 保存值到方法中
	 * 
	 * @param methodName
	 * @param value 不能为集合，对象
	 * @return
	 */
	public static boolean set(Object dest,String methodName, Object value) {
		boolean save=false;
		if(dest == null || methodName == null || methodName.trim().equals("")){
			return save;
		}
		Class<?> c = dest.getClass();
		Method[] destMethods = c.getDeclaredMethods();
		Method destSetMethod = getMethod(destMethods, "set"+methodName);
		if(destSetMethod==null){
			destSetMethod = getMethod(destMethods,methodName);
		}
		if(destSetMethod==null){
			return save;
		}
		
		
		Class<?>[] cs = destSetMethod.getParameterTypes();
		String methodType = null;
		if (cs.length == 1)
			methodType = cs[0].getSimpleName();
		if (methodType == null || methodType.trim().equals("")){
			return save;
		}
		try {
			
			return set(dest,destSetMethod,value == null ? null : 
				convertValue(methodType,value.toString()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return save;
	}
	public static boolean set(Object dest,Method theMethod,Object value) {
		try {
			if (theMethod != null) {
				Object[] argu = { value };
				theMethod.invoke(dest, argu);
				return true;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 类型转换
	 * @param type
	 * @param value
	 * @return
	 */
	public static Object convertValue(String type,String value) throws NumberFormatException,ParseException{
		
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		type = type.replaceAll("java.lang.", "").replaceAll("java.util.", "").toLowerCase();
		value = value.trim();
		switch (type){
			case "string":
				return value;
			case "boolean":
				return new Boolean(value.equalsIgnoreCase("T")||value.equalsIgnoreCase("Y")||value.equalsIgnoreCase("true")||value.equals("1")||value.equals("是")||value.equals("有"));
			case "byte":
				return new Byte(value);
			case "date":
				return DateUtils.parseDate(value);
			case "calendar":
				return DateUtils.getCalendar(value);
			case "double":
				return new Double(value);
			case "float":
				return new Double(value);
			case "integer":
			case "int":
				return new Integer(value);
			case "long":
				return new Long(value);
			default:
				return null;
		}
	}
	
	/**
	 * 得到方法中值
	 * 
	 * @param methodName
	 * @return
	 */
	public static Object get(Object dest,String methodName) {
		if(dest == null || methodName == null || methodName.trim().equals("")){
			return null;
		}
		Method[] ms = dest.getClass().getDeclaredMethods();
		Method theMethod=getMethod(ms,"get"+methodName);
		if (theMethod == null) {
			 theMethod=getMethod(ms,methodName);
		}
		return get(dest,theMethod);
	}
	
	public static Object get(Object dest,Method theMethod) {
		Object o=null;
		try {
			if(theMethod != null){
				o= theMethod.invoke(dest, new Object[0]);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * 得到方法中的值，并转换成字符串返回
	 * 
	 * @param methodName
	 * @return
	 */
	public static String getString(Object dest,String methodName) {
		Object value = get(dest,methodName);
		if (value == null) {
			return "";
		}
		if (value instanceof Date) {
			return DateUtils.formatDateTime((Date) value);
		} else if (value instanceof Boolean) {
			return (Boolean) value ? "1" : "0";
		}
		return value.toString();
	}
	
	public static String getString(Object src,Method m) {
		
		Object o = null;
		
		try {
			o = m.invoke(src, new Object[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(o == null)
			return "";
		
		return o instanceof Date ? DateUtils.formatDateTime((Date) o) : o.toString();
	}
	
	/**
	 * 得到方法中的值，并转换成字符串返回,如果对象为空则显示空字符串
	 * @param dest
	 * @param methodName
	 * @return
	 */
	public static String getStringNotNull(Object dest,String methodName){
		String value=getString(dest,methodName);
		if(value==null){
			return "";
		}else{
			return value;
		}
	}
	
	/**
	 * 按照名称查询方法（不区分大小写）
	 * @param methods
	 * @param methodName
	 * @return
	 */
	public static Method getMethod(Method methods[], String methodName) {
		/**
		 * 遍历方法数组,查询同名方法并返回.
		 */
		for (int i = 0; i < methods.length; i++)
			if (methods[i].getName().equalsIgnoreCase(methodName))
				return methods[i];
		return null;
	}

}
