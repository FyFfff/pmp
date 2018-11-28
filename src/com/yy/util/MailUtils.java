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
 * �����ʼ��Ĺ�����
 * 
 *
 */
public class MailUtils {
	public static void sendMail(String to,String code) throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.Session����.����(���������������)
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com","000");
			}
			
		});
		
		// 2.�����ʼ���Ϣ:
		Message message = new MimeMessage(session);
		// ������:
		message.setFrom(new InternetAddress("service@shop.com"));
		// �ռ���:
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// ���ñ���
		message.setSubject("��SHOPSYSTEM�ļ����ʼ�");
		// ��������
		message.setContent("<h1>����SHOPSYSTEM�Ĺ��������ʼ�</h1><h3><a href='http://localhost:8080/shopSystem/shop/user/activate.action?code="+code+"'>http://localhost:8080/shopSystem/shop/user/activate.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
	
		// 3.���Ͷ���
		Transport.send(message);
	}
	
	public static void reSetPassword(String to)throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.Session����.����(���������������)
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com","000");
			}
		});
		
		// 2.�����ʼ���Ϣ:
		Message message = new MimeMessage(session);
		// ������:
		message.setFrom(new InternetAddress("service@shop.com"));
		// �ռ���:
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// ���ñ���
		message.setSubject("��SHOPSYSTEM���޸������ʼ�");
		// ��������
		message.setContent("<h1>��SHOPSYSTEM���޸������ʼ�</h1><h3><a href='http://localhost:8080/shopSystem/shop/user/resetPassword.action?email="+to+"'>��������������</a></h3>", "text/html;charset=UTF-8");
	
		// 3.���Ͷ���
		Transport.send(message);
	}
}
