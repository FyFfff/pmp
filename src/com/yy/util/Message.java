package com.yy.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Message {

	public static void returnMessage(HttpServletResponse response, String str){
		try {
			response.getWriter().println("{\"message\":\""+str+"\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
