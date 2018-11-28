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
	 * 根据用户名和密码获得用户信息
	 * @param userid 用户名
	 * @param password 密码
	 * @return
	 */
	public Operator getOpreterByid(int wk_no){
		Operator optor = null;
		optor = loginmapper.getOrperator(wk_no);
		return optor;
	}
	
	/**
	 * 更新用户状态，is_lock,
	 * @param userid  用户账号
	 * @param is_Lock 状态
	 * @return
	 */
	public int updateIsLock(int wk_no,int is_Lock){
		loginmapper.updateIsLock(wk_no, is_Lock);
		return 0;
	}
	
	/**
	 * 更新用户登录失败次数，trytimes
	 * @param userid   用户账号
	 * @param tryTimes 失败次数
	 * @return
	 */
	public int updateTryTimes(int wk_no,int tryTimes){
		loginmapper.updateTryTimes(wk_no, tryTimes);
		return 0;
	}
	
	
	
}
