package com.yy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.bean.Operator;
import com.yy.mapper.LoginMapper;
import com.yy.mapper.OperMapper;

@Service("OperService")
@Transactional
public class OperService {

	@Resource
	private OperMapper opermapper;
	@Resource
	private LoginMapper loginmapper;
	
	/**
	 * �������û��б�
	 * @return
	 */
	public List<Operator> operInfo(){
		return opermapper.operInfo();
	}
	/**
	 * ����û�
	 * @param operator
	 * @return
	 */
	public int addOper(Operator operator){
		return opermapper.addOper(operator);
	}
	/**
	 * ɾ���û�
	 * @param wk_no
	 * @return
	 */
	public int delOper(int wk_no){
		return opermapper.delOper(wk_no);
	}
	
	/**
	 * �����û���Ϣ
	 * @param operator
	 * @return
	 */
	public int updateOper(Operator operator){
		return opermapper.updateOper(operator);
	}
	
	
}
