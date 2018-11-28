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
	 * �����н�ɫ�б�
	 * @return
	 */
	public List<Role> roleInfo(){
		return rolemapper.roleInfo();
	}
	
	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public int addRole(Role role){
		return rolemapper.addRole(role);
	}
	
	/**
	 * ɾ����ɫ
	 * @param role_id ��ɫid
	 * @return
	 */
	public int delRole(int role_id){
		return rolemapper.delRole(role_id);
	}
	
	/**
	 * ���½�ɫ����
	 * @param role
	 * @return
	 */
	public int updateRole(Role role){
		return rolemapper.updateRole(role);
	}
	
	/**
	 * ���ĳ����ɫ
	 * @param roleid ��ɫid
	 * @return
	 */
	public Role getRoleOne(int roleid){
		return rolemapper.getRoleOne(roleid);
	}
	
	
}
