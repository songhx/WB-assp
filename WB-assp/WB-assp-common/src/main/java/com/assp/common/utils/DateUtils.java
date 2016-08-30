/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.assp.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 获取系统的当前时间，返回格式为"yyyy-MM-dd HH:mm:ss"
	 * @return 系统当前时间字符串
	 */
	 public static String getCurrentDateStr() {  
		 Date currentTime = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 String dateString = formatter.format(currentTime);  
		 return dateString; 
	 }
	 
	 
	 	/**
		 * 获取系统的当前时间，返回格式为"yyyy-MM-dd HH:mm:ss"
		 * @return 系统当前时间字符串
		 */
		 public static String getCurrentDateStrByFormat(String format) {  
			 Date currentTime = new Date();  
			 SimpleDateFormat formatter = new SimpleDateFormat(format);  
			 String dateString = formatter.format(currentTime);  
			 return dateString; 
		 }
	
	/**
	  * 获取系统的当前时间，返回格式为"yyyy-MM-dd HH:mm:ss"
	  * @return 系统当前时间Date
	  */
	 public static Date getCurrentDate() {  
		 
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getCurrentDateStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return date;
	 }
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 根据输入字符串得到日期
	 * 
	 * @param tmpDate
	 * @return
	 */
	public static Calendar getCalendar(String tmpDate) {
		
		Date date =  parseDate(tmpDate);
		
		if(date == null){
			return null;
		}
			
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
    /**
	 * 获取两个日期之间的相差年分数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
    public static int getDistanceYearOfTwoDate(String date1,String date2,String pattern) throws ParseException{        
    	SimpleDateFormat sdf=new SimpleDateFormat(pattern);                
    	Calendar c1=Calendar.getInstance();        
    	Calendar c2=Calendar.getInstance();                
    	c1.setTime(sdf.parse(date1));        
    	c2.setTime(sdf.parse(date2));                
    	int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);                
    	//开始日期若小月结束日期       
    	if(year<0){            
    		return year;        
    	}               
    	return year;    
    }
    
    /**   
     *  得到后Num年   
     *    
     * @return   
     */    
    public static Date getAfterOneYear(Date startDate,int Num) {     
    	Calendar calendar = Calendar.getInstance();     
        calendar.setTime(startDate); 
        calendar.add(Calendar.YEAR, Num);
        return calendar.getTime();     
    }  
    
    /**
	 * 获取两个日期之间的月份
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
    public static int getDistanceMonthOfTwoDate(String date1,String date2,String pattern) throws ParseException{        
    	SimpleDateFormat sdf=new SimpleDateFormat(pattern);                
    	Calendar c1=Calendar.getInstance();        
    	Calendar c2=Calendar.getInstance();                
    	c1.setTime(sdf.parse(date1));        
    	c2.setTime(sdf.parse(date2));                
    	int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);                
    	//开始日期若小月结束日期       
    	if(year<0){            
    		year=-year;            
    		return year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);        
    	}               
    	return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);    
    }
    
    /**   
     *  得到后Num月   
     *    
     * @return   
     */    
    public static Date getAfterOneMonth(Date startDate,int Num) {     
    	Calendar calendar = Calendar.getInstance();     
        calendar.setTime(startDate); 
        calendar.add(Calendar.MONTH, Num);
        return calendar.getTime();     
    }  
    /**
     * 得到后Num分钟
     * @param startDate
     * @param Num
     * @return
     */
    @SuppressWarnings("static-access")
	public static Date getAfterOneMinute(Date startDate,int Num){
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(startDate);
    	calendar.add(calendar.MINUTE, Num);
		return calendar.getTime();  
    	
    }
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**   
     *  得到后Num天   
     *    
     * @return   
     */    
    public static Date getAfterOneDay(Date startDate,int Num) {     
    	Calendar calendar = Calendar.getInstance();     
        calendar.setTime(startDate); 
        calendar.add(Calendar.DAY_OF_MONTH, Num);
        return calendar.getTime();     
    }  
    
    
    /**
     * Get the Dates between Start Date and End Date.
     * @param p_start   Start Date
     * @param p_end     End Date
     * @return Dates List
     */
    public static List<Date> getDates(Calendar p_start, Calendar p_end) {
        List<Date> result = new ArrayList<Date>();
        Calendar temp = (Calendar) p_start.clone();
        while (temp.before(p_end)) {
            result.add(temp.getTime());
            temp.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }
    
    /**
     * 
    *  得到所有月份
    * @param p_start
    * @param p_end
    * @return
    * @deprecated Calendar对象在读取月份值的时候会造成月份自动加一,因此废弃掉,转而用getDistanceMonthOfTwoDate()
     */
    public static List<Date> getMonths(Calendar p_start, Calendar p_end) {
        List<Date> result = new ArrayList<Date>();

        int starMonth = p_start.get(Calendar.MONTH);
        int endMonth = p_end.get(Calendar.MONTH);
        
    	//开始日期若小月结束日期       
    	int distanceOfMonth = 0;
    	
    	int year =p_start.get(Calendar.YEAR)-p_end.get(Calendar.YEAR);                
    	//开始日期若小月结束日期       
    	if(year<0){            
    		year=-year;            
    		distanceOfMonth = year*12 + starMonth- endMonth;        
    	}               
    	distanceOfMonth = year*12 + endMonth - starMonth + 1; 
    	
    	Calendar temp = (Calendar) p_start.clone();
        for (int i = 0; i < distanceOfMonth; i++) {
        	result.add(temp.getTime());
            temp.add(Calendar.MONTH, 1);
		}
        return result;
    }
    
    /**
     * 得到所有年
    * 
    * @param p_start
    * @param p_end
    * @return
     */
    public static List<Date> getYears(Calendar p_start, Calendar p_end) {
        List<Date> result = new ArrayList<Date>();
        Calendar temp = (Calendar) p_start.clone();
        while (temp.get(Calendar.YEAR) <=p_end.get(Calendar.YEAR)) {
            result.add(temp.getTime());
            temp.add(Calendar.YEAR, 1);
        }
        return result;
    }
    
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
//		System.out.println(getDistanceMonthOfTwoDate("2014-07","2015-08","yyyy-MM"));
//		System.out.println(getDistanceYearOfTwoDate("2014","2015","yyyy"));
		System.out.println(getAfterOneYear(new Date(),1));
	}
}
