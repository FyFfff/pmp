package com.yy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.bean.Operator;
import com.yy.mapper.LoginMapper;

@Service("LoginService")
@Transactional
public class LoginService {

	@Resource
	private LoginMapper loginmapper;
	
	/**
	 * �����û������������û���Ϣ
	 * @param userid �û���
	 * @param password ����
	 * @return
	 */
	public Operator getOpreterByid(int wk_no){
		Operator optor = null;
		optor = loginmapper.getOrperator(wk_no);
		return optor;
	}
	
	/**
	 * �����û�״̬��is_lock,
	 * @param userid  �û��˺�
	 * @param is_Lock ״̬
	 * @return
	 */
	public int updateIsLock(int wk_no,int is_Lock){
		loginmapper.updateIsLock(wk_no, is_Lock);
		return 0;
	}
	
	/**
	 * �����û���¼ʧ�ܴ�����trytimes
	 * @param userid   �û��˺�
	 * @param tryTimes ʧ�ܴ���
	 * @return
	 */
	public int updateTryTimes(int wk_no,int tryTimes){
		loginmapper.updateTryTimes(wk_no, tryTimes);
		return 0;
	}
	
	
	
}
