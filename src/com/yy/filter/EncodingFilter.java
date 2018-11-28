package com.yy.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
public class EncodingFilter implements Filter{

	String encoding;
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//获取字符集
		encoding=filterConfig.getInitParameter("encoding");
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		    //请求对象和响应对象转换带有http协义的请求与响应对象
		    HttpServletRequest request=(HttpServletRequest) req;
		    HttpServletResponse response=(HttpServletResponse) resp;
		    
		    //解决POST提交方式的中文乱码问题
		    request.setCharacterEncoding(encoding);
		    
		    //解决respones对象输出中文乱码问题
		    response.setContentType("text/html;charset="+encoding);
		    
		    //解决GET提交方式的中文乱码问题
		    request=new EncodingRequest(request);
		    
		    //放行
		    chain.doFilter(request, response);
	} 

	class EncodingRequest extends HttpServletRequestWrapper {

		private HttpServletRequest request;
		private boolean hasEncode = false;
		
		public EncodingRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		
		public String getParameter(String name) {
			// 通过getParameterMap方法完成
			String[] values = getParameterValues(name);
			if (values == null) {
				return null;
			}
			return values[0];
		}

		
		public String[] getParameterValues(String name) {
			// 通过getParameterMap方法完成
			@SuppressWarnings("unchecked")
			Map<String, String[]> parameterMap =getParameterMap();
			String[] values = parameterMap.get(name);
			return values;
		}
		
		@SuppressWarnings("rawtypes")
		public Map getParameterMap() {
			@SuppressWarnings("unchecked")
			Map<String, String[]> parameterMap = request.getParameterMap();
			String method = request.getMethod();
			if (method.equalsIgnoreCase("post")) {
				return parameterMap;
			}

			// get提交方式 手动转码 , 这里的转码只进行一次 所以通过 hasEncode 布尔类型变量控制
			if (!hasEncode) { 
				Set<String> keys = parameterMap.keySet();
				for (String key : keys) {
					String[] values = parameterMap.get(key);
					if (values == null) {
						continue;
					}
					for (int i = 0; i < values.length; i++) {
						String value = values[i];
						// 解决get
						try {
							value = new String(value.getBytes("ISO-8859-1"),
									encoding);
							
							// values是一个地址
							values[i] = value;
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					// 一次转码完成后，设置转码状态为true
					hasEncode = true;
				}
			}
			return parameterMap;
		}
		
	
		
	}
	public void destroy() {
		
		
	}

}
