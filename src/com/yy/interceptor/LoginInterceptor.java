package com.yy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yy.bean.Operator;

/**
 * À¹½ØÆ÷£¬ÅÐ¶ÏÓÃ»§ÊÇ·ñµÇÂ¼
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
				
		Operator optor=(Operator) request.getSession().getAttribute("currentOperator");
		
		if(optor==null){
			response.sendRedirect("/");
			System.out.println("preHandle2");
			return false;
		}
		System.out.println("preHandle1");
			return true;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, 
			Object obj, ModelAndView mav) throws Exception {	
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exc)
			throws Exception {		
	}
}
