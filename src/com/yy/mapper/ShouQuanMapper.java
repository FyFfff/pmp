package com.yy.mapper;

import java.util.List;

import com.yy.bean.OperatorRole;
import com.yy.bean.RoleFunction;

public interface ShouQuanMapper {
	
	OperatorRole getRoleByWkno(int wkno);
	int addRoleByWkno(OperatorRole operatorRole);
	int delRoleByWkno(int wkno);
	
	List<RoleFunction> getIdByRoleid(int roleid);
	int addRoleFunction(RoleFunction roleFunction);
	int delIdByRoleid(int roleid);
	
}
