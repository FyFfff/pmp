package com.yy.mapper;

import java.util.List;

import com.yy.bean.Role;


public interface RoleMapper {
	
	int addRole(Role role);
	int delRole(int role_id);
	int updateRole(Role role);
	List<Role> roleInfo();
	Role getRoleOne(int roleid);

}
