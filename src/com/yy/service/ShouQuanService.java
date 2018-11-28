package com.yy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.bean.OperatorRole;
import com.yy.bean.RoleFunction;
import com.yy.mapper.ShouQuanMapper;

@Service("ShouQuanService")
@Transactional
public class ShouQuanService {

	@Resource
	private ShouQuanMapper shouQuanMapper;
	
	/**
	 * 根据用户ID获得对应角色ID
	 * @param wkno 用户ID
	 * @return
	 */
	public OperatorRole getRoleByWkno(int wkno){
		return shouQuanMapper.getRoleByWkno(wkno);
	}
	
	/**
	 * 绑定用户ID和角色ID
	 * @param operatorRole
	 * @return
	 */
	public int addRoleByWkno(OperatorRole operatorRole){
		return shouQuanMapper.addRoleByWkno(operatorRole);
	}
	
	/**
	 * 根据用户ID删除与角色的绑定
	 * @param wkno 用户ID
	 * @return
	 */
	public int delRoleByWkno(int wkno){
		return shouQuanMapper.delRoleByWkno(wkno);
	}
	
	/**
	 * 获得角色ID对应的功能菜单ID列表
	 * @param roleid 角色ID
	 * @return
	 */
	public List<RoleFunction>  getIdByRoleid(int roleid){
		return shouQuanMapper.getIdByRoleid(roleid);
	}
	
	/**
	 * 删除角色与功能菜单的绑定
	 * @param roleid 角色ID
	 * @return
	 */
	public int delIdByRoleid(int roleid){
		return shouQuanMapper.delIdByRoleid(roleid);
	}
	
	/**
	 * 添加角色与功能菜单的绑定
	 * @param roleFunction 
	 * @return
	 */
	public int addRoleFunction(RoleFunction roleFunction){
		return shouQuanMapper.addRoleFunction(roleFunction);
	}
	
	
}
