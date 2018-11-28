package com.yy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	
	public static Date getString2Date(String date)
	{
		try
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(date);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public static String getStringDate(Date date){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

}
