/**
 *
 */
package com.prettyviewproj.tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/*
 * author:huangyulun
 * date:2018/12/21
 * */
public class TimeTool {
	public static Timestamp getDate() {
		
    	Date date = new Date();
    	String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    	Timestamp applicationTime = Timestamp.valueOf(time);
		
		return applicationTime;
	}
	
	public static String getTimeToString(Timestamp timestamp) {
		
		String str = timestamp.toString().substring(0, timestamp.toString().indexOf("."));
		
		return str;
	}
	
	public static String getTime() {
		
    	Date date = new Date();
    	String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    	Timestamp applicationTime = Timestamp.valueOf(time);
    	String str = applicationTime.toString().substring(0, applicationTime.toString().indexOf("."));
		return str;
	}
	
	/*
	 * 获取上个月的第一天和最后一天
	 * author:huangyulun
	 * date:2019/04/21
	 * */
	public static HashMap<String,String> getLastMonthBeginAndEnd(){
		Calendar c = Calendar.getInstance();
		//获取当前日期至上月同日
		c.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String gtimelast = sdf.format(c.getTime());
		System.out.println("前一个月日期："+gtimelast);
		
		int lastMonthMaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);//上月天数
		System.out.println("上月天数："+lastMonthMaxDay);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay, 23, 59, 59);
		
		String timeEnd = sdf.format(c.getTime());
		System.out.println("上月结束最后一天："+timeEnd);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		String timeBegin = sdf2.format(c.getTime());
		System.out.println("上月开始第一天："+timeBegin);
		
//		ArrayList<String> arrayTime = new ArrayList<String>();
//		arrayTime.add(timeBegin);
//		arrayTime.add(timeEnd);
		HashMap<String,String> timeMap = new HashMap<String,String>();
		timeMap.put("timeBegin",timeBegin);
		timeMap.put("timeEnd",timeEnd);
		timeMap.put("maxDay",lastMonthMaxDay+"");
		return timeMap;
	}
	
	/*
	 * 上传作品取名时间格式
	 * author:huangyulun
	 * date:2019/05/02
	 * 
	 * */
	public static String getUploadTimeFormat() {
		
		Date date = new Date();
		String strTime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		/*
		 * String timetemp = strTime.replace(":",""); String timetemp2 =
		 * timetemp.replace(".",""); String timeFormat = timetemp2.replace(" ","_");
		 */
		
		return strTime;
	}
	
	public static void main(String[] args) {
		String s = getUploadTimeFormat();
	}
}
