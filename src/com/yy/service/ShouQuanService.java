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
	 * �����û�ID��ö�Ӧ��ɫID
	 * @param wkno �û�ID
	 * @return
	 */
	public OperatorRole getRoleByWkno(int wkno){
		return shouQuanMapper.getRoleByWkno(wkno);
	}
	
	/**
	 * ���û�ID�ͽ�ɫID
	 * @param operatorRole
	 * @return
	 */
	public int addRoleByWkno(OperatorRole operatorRole){
		return shouQuanMapper.addRoleByWkno(operatorRole);
	}
	
	/**
	 * �����û�IDɾ�����ɫ�İ�
	 * @param wkno �û�ID
	 * @return
	 */
	public int delRoleByWkno(int wkno){
		return shouQuanMapper.delRoleByWkno(wkno);
	}
	
	/**
	 * ��ý�ɫID��Ӧ�Ĺ��ܲ˵�ID�б�
	 * @param roleid ��ɫID
	 * @return
	 */
	public List<RoleFunction>  getIdByRoleid(int roleid){
		return shouQuanMapper.getIdByRoleid(roleid);
	}
	
	/**
	 * ɾ����ɫ�빦�ܲ˵��İ�
	 * @param roleid ��ɫID
	 * @return
	 */
	public int delIdByRoleid(int roleid){
		return shouQuanMapper.delIdByRoleid(roleid);
	}
	
	/**
	 * ��ӽ�ɫ�빦�ܲ˵��İ�
	 * @param roleFunction 
	 * @return
	 */
	public int addRoleFunction(RoleFunction roleFunction){
		return shouQuanMapper.addRoleFunction(roleFunction);
	}
	
	
}
