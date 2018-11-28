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
	 * 根据wkno查询菜单内容
	 * @param wk_no
	 * @return
	 */
	public List<Menutree> getMenuByOperId(int wk_no){

		return menuMapper.getMenuByOperId(wk_no);
	}
	
	/**
	 * 查所有菜单列表（open）
	 * @return
	 */
	public List<Menutree> getMenu(){

		return menuMapper.getMenu();
	}
	
	/**
	 * 查所有菜单列表（open）
	 * @return
	 */
	public List<Menutree> getAllMenu(){

		return menuMapper.getAllMenu();
	}
	
	/**
	 * 添加菜单
	 * @param menutree
	 * @return
	 */
	public int addMenu(Menutree menutree){
		return menuMapper.addMenu(menutree);
	}
	
	/**
	 * 删除菜单
	 * @param id 菜单ID
	 * @return
	 */
	public int delMenu(int id){
		return menuMapper.delMenu(id);
	}
	
	/**
	 * 更新菜单
	 * @param menutree
	 * @return
	 */
	public int updateMenu(Menutree menutree){
		return menuMapper.updateMenu(menutree);
	}
	
	/**
	 * 根据id获得菜单信息
	 * @param id 菜单id
	 * @return
	 */
	public Menutree getMenuByid(int id){
		return menuMapper.getMenuByid(id);
	}
}
