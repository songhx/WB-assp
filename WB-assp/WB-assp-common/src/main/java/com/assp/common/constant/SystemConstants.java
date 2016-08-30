package com.assp.common.constant;


/**
 * 类简述
 * <p>
 *      系统级别常量
 * </p>
 * 
 * @Company 动力威视
 * @Copyright
 * @author (shx@sxw100.com)
 * @version 1.0
 * @CreateDate 2016年4月6日 下午3:26:16 
 */
public class SystemConstants {
    //私有构造 不能实例此类
	private SystemConstants(){}
	
	//wms 平台代码
	public static final String WMS_PLATFORM = "10001";
	
	
	public static final int USABLE_STATUS = 0;  //可用状态
	
	public static final int VIST_SOURCE_DOTNET = 0; //dotnet用户
	
	public static final int VIST_SOURCE_WMS = 1; //wmst用户
	
	public static final int VIST_SOURCE_REGISTER = 2; //新注册用户
	
	//操作类型
	public static final int OPT_INSERT = 1; //插入
	public static final int OPT_QUERY = 2; //查询
	public static final int OPT_MODIFY = 3;//修改
	public static final int OPT_DEL = 4;//删除
	
	//系统模块
	public static final String M_AUTH = "权限模块";
	public static final String M_TEMMPLATE = "模板模块";
	
	//数据资源类型
	public static final int DATA_ARTICLE_TPYE = 1; // 文章数据类型对应 Article 的操作
	public static final int  DATA_PICTURE_TPYE = 2; // 图片数据类型对应 Picture 的操作
	
	//登录用户在session中的key
	public static final String  CURRENT_LOGIN_USER = "loginUser"; 
	
	//切换数据库
	public static final String  DATA_SOURCE_TEMPLATE = "templateDataSource"; 
	public static final String  DATA_SOURCE_SITE = "siteDataSource"; 
	
	//操作提示语
	public static final String  TIP_SUCCESS = "操作成功！"; 
	public static final String  TIP_FAIL = "操作失败,请重试！"; 
	public static final String  TIP_ERROR = "未知错误！";
	
	public static final String  FRAMESREFFRAME = "关联关系重复！已存在！";
	
}
  