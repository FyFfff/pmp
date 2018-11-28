package com.yy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.bean.Role;
import com.yy.mapper.RoleMapper;

@Service("RoleService")
@Transactional
public class RoleService {

	@Resource
	private RoleMapper rolemapper;
	
	/**
	 * 查所有角色列表
	 * @return
	 */
	public List<Role> roleInfo(){
		return rolemapper.roleInfo();
	}
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int addRole(Role role){
		return rolemapper.addRole(role);
	}
	
	/**
	 * 删除角色
	 * @param role_id 角色id
	 * @return
	 */
	public int delRole(int role_id){
		return rolemapper.delRole(role_id);
	}
	
	/**
	 * 跟新角色内容
	 * @param role
	 * @return
	 */
	public int updateRole(Role role){
		return rolemapper.updateRole(role);
	}
	
	/**
	 * 获得某个角色
	 * @param roleid 角色id
	 * @return
	 */
	public Role getRoleOne(int roleid){
		return rolemapper.getRoleOne(roleid);
	}
	
	
}
