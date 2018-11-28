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
		
		//��ȡ�ַ���
		encoding=filterConfig.getInitParameter("encoding");
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		    //����������Ӧ����ת������httpЭ�����������Ӧ����
		    HttpServletRequest request=(HttpServletRequest) req;
		    HttpServletResponse response=(HttpServletResponse) resp;
		    
		    //���POST�ύ��ʽ��������������
		    request.setCharacterEncoding(encoding);
		    
		    //���respones�������������������
		    response.setContentType("text/html;charset="+encoding);
		    
		    //���GET�ύ��ʽ��������������
		    request=new EncodingRequest(request);
		    
		    //����
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
			// ͨ��getParameterMap�������
			String[] values = getParameterValues(name);
			if (values == null) {
				return null;
			}
			return values[0];
		}

		
		public String[] getParameterValues(String name) {
			// ͨ��getParameterMap�������
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

			// get�ύ��ʽ �ֶ�ת�� , �����ת��ֻ����һ�� ����ͨ�� hasEncode �������ͱ�������
			if (!hasEncode) { 
				Set<String> keys = parameterMap.keySet();
				for (String key : keys) {
					String[] values = parameterMap.get(key);
					if (values == null) {
						continue;
					}
					for (int i = 0; i < values.length; i++) {
						String value = values[i];
						// ���get
						try {
							value = new String(value.getBytes("ISO-8859-1"),
									encoding);
							
							// values��һ����ַ
							values[i] = value;
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					// һ��ת����ɺ�����ת��״̬Ϊtrue
					hasEncode = true;
				}
			}
			return parameterMap;
		}
		
	
		
	}
	public void destroy() {
		
		
	}

}
