package com.yy.mapper;

import com.yy.bean.Operator;

public interface LoginMapper {
	
	//查询用户信息
	Operator getOrperator(int wk_no);
	
	//更新用户状态，isLock
	int updateIsLock(int wk_no, int is_Lock);
	
	//更新用户登录失败次数，tryTimes
	int updateTryTimes(int wk_no, int tryTimes);

}
