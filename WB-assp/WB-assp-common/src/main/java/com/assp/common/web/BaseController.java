package com.assp.common.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.assp.common.constant.SystemConstants;
import com.assp.modules.sys.entity.User;
import com.assp.modules.template.entity.Template;
import com.assp.modules.website.entity.Website;

/**
 * 
 * 基础控制器
 * 
 * @Company 动力威视
 * @Copyright
 * @author (shx@sxwl100.com)
 * @version 1.0
 * @CreateDate 2016年4月6日 下午1:10:14
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * 返回JSON 带时间格式处理的
	 */
	public void printJSONWithDateFormat(HttpServletResponse response, Object obj) {
		try {
			String jsonStrShow = JSONObject.toJSONStringWithDateFormat(obj,
					"yyyy-MM-dd HH:mm:ss");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsonStrShow);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: printJSON
	 * @Description: 打印josn
	 * @param @param response
	 * @param @param obj
	 * @return void
	 * @throws
	 */
	public void printJSON(HttpServletResponse response, Object obj) {
		try {
			String jsonStrShow = JSONObject.toJSONString(obj);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsonStrShow);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取session中的用户 </P> 详细描述(可选) </p>
	 * 
	 * @param request
	 * @return <p>
	 *         修改记录:(日期,修改人,描述) (可选)
	 *         </p>
	 */
	
	 public User getloginUser(HttpServletRequest request){ 
		 User user = (User)request.getSession().getAttribute("loginUser"); 
		 return user;
	 }
	 

	/**
	 * 
	 * @Title: getSiteTemplate
	 * @Description: 获取session 中的站点模板
	 * @author (shx@sxw100.com)
	 * @param @param request
	 * @param @return 设定文件
	 * @return Template 返回类型
	 * @throws
	 */
	public Template getSiteTemplate(HttpSession session) {
		return session.getAttribute("siteTempalte") == null ? null
				: (Template) session.getAttribute("siteTempalte");
	}

	/**
	 * 
	 * @Title: getWebsite
	 * @Description: 获取session 中的website
	 * @author (wangkang@sxw100.com)
	 * @param @param request
	 * @param @return 设定文件
	 * @return Template 返回类型
	 * @throws
	 */
	public Website getWebsite(HttpSession session){
		return session.getAttribute("website") == null ? null
				: (Website) session.getAttribute("website");
	}

}
