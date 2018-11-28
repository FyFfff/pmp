package com.yy.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件的工具类
 * 
 *
 */
public class MailUtils {
	public static void sendMail(String to,String code) throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.Session对象.连接(与邮箱服务器连接)
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com","000");
			}
			
		});
		
		// 2.构建邮件信息:
		Message message = new MimeMessage(session);
		// 发件人:
		message.setFrom(new InternetAddress("service@shop.com"));
		// 收件人:
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置标题
		message.setSubject("来SHOPSYSTEM的激活邮件");
		// 设置正文
		message.setContent("<h1>来自SHOPSYSTEM的官网激活邮件</h1><h3><a href='http://localhost:8080/shopSystem/shop/user/activate.action?code="+code+"'>http://localhost:8080/shopSystem/shop/user/activate.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
	
		// 3.发送对象
		Transport.send(message);
	}
	
	public static void reSetPassword(String to)throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.Session对象.连接(与邮箱服务器连接)
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com","000");
			}
		});
		
		// 2.构建邮件信息:
		Message message = new MimeMessage(session);
		// 发件人:
		message.setFrom(new InternetAddress("service@shop.com"));
		// 收件人:
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置标题
		message.setSubject("来SHOPSYSTEM的修改密码邮件");
		// 设置正文
		message.setContent("<h1>来SHOPSYSTEM的修改密码邮件</h1><h3><a href='http://localhost:8080/shopSystem/shop/user/resetPassword.action?email="+to+"'>点这里重置密码</a></h3>", "text/html;charset=UTF-8");
	
		// 3.发送对象
		Transport.send(message);
	}
}
