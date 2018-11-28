package com.yy.mapper;

import java.util.List;

import com.yy.bean.Menutree;


public interface MenuMapper {
	
	List<Menutree> getMenuByOperId(int wk_no);
	List<Menutree> getMenu();
	List<Menutree> getAllMenu();
	
	int addMenu(Menutree menutree);
	int delMenu(int id);
	int updateMenu(Menutree menutree);
	Menutree getMenuByid(int id);
}
