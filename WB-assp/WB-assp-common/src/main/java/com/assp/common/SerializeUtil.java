package com.assp.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 
  * 类简述
  * <p>
  *    序列化工具
  * </p>
  * @Company 动力威视
  * @Copyright
  * @author (shx@sxw100.com)
  * @version 1.0
  * @CreateDate 2016年4月20日 上午10:25:55
 */
public class SerializeUtil {
	public static byte[] serialize(Object object) {
		if(object==null){
			return null;
		}
		
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}

	public static Object unserialize(byte[] bytes) {
		if(bytes==null){
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
}
