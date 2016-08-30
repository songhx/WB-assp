package com.assp.common.utils;

import java.io.IOException;
import java.net.URLDecoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SendSms {

	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

	public static void main(String[] args) {
		//SendSms("15300097795","123456","http://106.ihuyi.cn/webservice/sms.php?method=Submit");
		sendSmstoReg("15300097795","123456");
	}

	/**
	 * 
	 * 描述：注册验证码
	 * 创建人： 魏泽超
	 * 创建时间: 2016-7-15 下午3:43:45
	 * @version
	 */
	public static String sendSmstoReg(String telephone, String message) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		// int mobile_code = (int)((Math.random()*9+1)*100000);
		// System.out.println(mobile);

		String content = new String("您的验证码是：" + message + "。请不要把验证码泄露给其他人。");
		String code = "";

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_wstl"), new NameValuePair("password", "7m5xV5"), // 密码可以使用明文密码或使用32位MD5加密
				// new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", telephone), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("4085".equals(code) && "0".equals(smsid)) {
				return code;
			}

			if ("2".equals(code)) {
				// System.out.println("短信提交成功");
				return code;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	
	/**
	 * 
	 * 描述：发送新密码
	 * 创建人： 魏泽超
	 * 创建时间: 2016-7-15 下午3:42:46
	 * @version
	 */
	public static String sendSmstoNewPwd(String telephone, String message) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		// int mobile_code = (int)((Math.random()*9+1)*100000);
		// System.out.println(mobile);

		String content = new String("您的新密码为："+message+"。请妥善保管，不要轻易泄露给其他人。");
		String code = "";

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_wstl"), new NameValuePair("password", "7m5xV5"), // 密码可以使用明文密码或使用32位MD5加密
				// new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", telephone), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("4085".equals(code) && "0".equals(smsid)) {
				return code;
			}

			if ("2".equals(code)) {
				// System.out.println("短信提交成功");
				return code;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	/**
	 * 
	 * 描述：发送新支付密码
	 * 创建人： 魏泽超
	 * 创建时间: 2016-7-15 下午3:42:46
	 * @version
	 */
	public static String sendSmstoNewPayPwd(String telephone, String message) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		// int mobile_code = (int)((Math.random()*9+1)*100000);
		// System.out.println(mobile);

		String content = new String("您的新支付密码为："+message+"。请妥善保管，不要轻易泄露给其他人。");
		String code = "";

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_wstl"), new NameValuePair("password", "7m5xV5"), // 密码可以使用明文密码或使用32位MD5加密
				// new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", telephone), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("4085".equals(code) && "0".equals(smsid)) {
				return code;
			}

			if ("2".equals(code)) {
				// System.out.println("短信提交成功");
				return code;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	/**
	 * 
	 * 描述：找回密码 发送校验码
	 * 创建人： 魏泽超
	 * 创建时间: 2016-7-15 下午3:42:46
	 * @version
	 */
	public static String sendSmsByBackPwd(String telephone, String message) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		// int mobile_code = (int)((Math.random()*9+1)*100000);
		// System.out.println(mobile);

		String content = new String("您找回密码的校验码为："+message+"。请妥善保管，以防泄露。 ");
		String code = "";

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_wstl"), new NameValuePair("password", "7m5xV5"), // 密码可以使用明文密码或使用32位MD5加密
				// new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", telephone), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("4085".equals(code) && "0".equals(smsid)) {
				return code;
			}

			if ("2".equals(code)) {
				// System.out.println("短信提交成功");
				return code;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	/**
	 * 
	 * 描述：找回支付密码 发送校验码
	 * 创建人： 魏泽超
	 * 创建时间: 2016-7-15 下午3:42:46
	 * @version
	 */
	public static String sendSmsByBackPayPwd(String telephone, String message) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		// int mobile_code = (int)((Math.random()*9+1)*100000);
		// System.out.println(mobile);

		String content = new String("您找回支付密码的校验码为："+message+"。请妥善保管，以防泄露。 ");
		String code = "";

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_wstl"), new NameValuePair("password", "7m5xV5"), // 密码可以使用明文密码或使用32位MD5加密
				// new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", telephone), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("4085".equals(code) && "0".equals(smsid)) {
				return code;
			}

			if ("2".equals(code)) {
				// System.out.println("短信提交成功");
				return code;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

	/*public static String SendSms(String telephone, String message, String Url) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		// int mobile_code = (int)((Math.random()*9+1)*100000);
		// System.out.println(mobile);

		String content = new String("您的验证码是：" + message + "。请不要把验证码泄露给其他人。");
		String code = "";

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_wstl"), new NameValuePair("password", "7m5xV5"), // 密码可以使用明文密码或使用32位MD5加密
				// new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", telephone), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			// System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if ("4085".equals(code) && "0".equals(smsid)) {
				return code;
			}

			if ("2".equals(code)) {
				// System.out.println("短信提交成功");
				return code;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}*/
}