package com.yy.mapper;

import com.yy.bean.Operator;

public interface LoginMapper {
	
	//��ѯ�û���Ϣ
	Operator getOrperator(int wk_no);
	
	//�����û�״̬��isLock
	int updateIsLock(int wk_no, int is_Lock);
	
	//�����û���¼ʧ�ܴ�����tryTimes
	int updateTryTimes(int wk_no, int tryTimes);

}
