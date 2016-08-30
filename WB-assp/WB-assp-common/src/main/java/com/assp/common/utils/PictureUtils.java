package com.assp.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 
 * 
 * 类简述
 * <p>
 * 图片工具类
 * </p>
 * 
 * @Company 动力威视
 * @Copyright
 * @author (panlinlin@sxw100.com)
 * @version 1.0
 * @CreateDate 2016年5月30日 上午11:26:56
 */
public class PictureUtils {

	private static final String[] imgType = {".jpg",".jpeg",".gif",".png"};
	
	/*public static String getExtensiona(File f) {
		return (f != null) ? getExtension(f.getName()) : "";
	}*/
	
	/**
	 * 
	* @Title: getExtension 
	* @Description: 获取不带“.”的文件扩展名
	* @author (panlinlin@sxw100.com)
	* @param @param filename
	* @param @param defExt
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}
	/**
	 * 获取当前文件扩展名(带.)
	 * @Title: getExtension 
	 * @Description: TODO
	 * @param filename文件名
	 * @return
	 * @return: String
	 */
	public static String getExtension(String filename) {
		String ext = getExtension(filename, "");
		if (ext.length() > 0) {
			ext = "." + ext;
		}
		return ext;
	}
	
	
	public static String getfirstName(String fileName) {
		if ((fileName != null) && (fileName.length() > 0)) {
			int i = fileName.lastIndexOf('.');

			if ((i > -1) && (i < (fileName.length() - 1))) {
				return fileName.substring(0,i);
			}
		}
		return "";
	}
	
	/**
	 * 是否为图片类型
	 * @param fileType（文件扩展名）
	 * @return
	 */
	public static boolean isImg(String fileType){
		boolean boo = false;
		
		for(int i=0;i<imgType.length;i++)
		{
			if(fileType.equals(imgType[i]))
			{
				boo = true;
				break;
			}
		}
		return boo;
	}
	
	/**
	 * 
	* @Title: getImageWidth 
	* @Description: 获取图片宽度
	* @author (panlinlin@sxw100.com)
	* @param @param sourceImg
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public static String getImageWidth(BufferedImage sourceImg){
		return sourceImg.getWidth()+"";
		
	}
	
	/**
	 * 
	* @Title: getImageHeight 
	* @Description: 获取图片高度 
	* @author (panlinlin@sxw100.com)
	* @param @param sourceImg
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public static String getImageHeight(BufferedImage sourceImg){
		return sourceImg.getHeight()+"";
	}
	
	/**
	 * 
	* @Title: getImageSize 
	* @Description: 获取图片大小 
	* @author (panlinlin@sxw100.com)
	* @param @param outFile
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static Integer getImageSize(File outFile){
		return Integer.valueOf(String.format("%.0f",outFile.length()/1024.0));
	}
}
