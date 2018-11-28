package com.yy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.bean.Menutree;
import com.yy.mapper.MenuMapper;

@Service("MenuService")
@Transactional
public class MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	/**
	 * ����wkno��ѯ�˵�����
	 * @param wk_no
	 * @return
	 */
	public List<Menutree> getMenuByOperId(int wk_no){

		return menuMapper.getMenuByOperId(wk_no);
	}
	
	/**
	 * �����в˵��б�open��
	 * @return
	 */
	public List<Menutree> getMenu(){

		return menuMapper.getMenu();
	}
	
	/**
	 * �����в˵��б�open��
	 * @return
	 */
	public List<Menutree> getAllMenu(){

		return menuMapper.getAllMenu();
	}
	
	/**
	 * ��Ӳ˵�
	 * @param menutree
	 * @return
	 */
	public int addMenu(Menutree menutree){
		return menuMapper.addMenu(menutree);
	}
	
	/**
	 * ɾ���˵�
	 * @param id �˵�ID
	 * @return
	 */
	public int delMenu(int id){
		return menuMapper.delMenu(id);
	}
	
	/**
	 * ���²˵�
	 * @param menutree
	 * @return
	 */
	public int updateMenu(Menutree menutree){
		return menuMapper.updateMenu(menutree);
	}
	
	/**
	 * ����id��ò˵���Ϣ
	 * @param id �˵�id
	 * @return
	 */
	public Menutree getMenuByid(int id){
		return menuMapper.getMenuByid(id);
	}
}
