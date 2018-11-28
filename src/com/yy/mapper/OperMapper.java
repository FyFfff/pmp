package com.yy.mapper;

import java.util.List;

import com.yy.bean.Operator;


public interface OperMapper {
	
	int addOper(Operator operator);
	int delOper(int wk_no);
	int updateOper(Operator operator);
	List<Operator> operInfo();
	
}
