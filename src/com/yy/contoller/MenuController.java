package com.yy.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.bean.Menutree;
import com.yy.service.MenuService;
import com.yy.util.Message;

@Controller
@RequestMapping("/menu")
public class MenuController {
	/**
	 * 菜单管理
	 */
	@Autowired
	private MenuService menuService;

	
	/**
	 * 增
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addMenu.do")
	public void addMenu(Menutree menutree,HttpServletRequest request,HttpServletResponse response) {
		if(menuService.addMenu(menutree)>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "添加失败");
		}
	}
	
	/**
	 * 删
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delMenu.do")
	public void delMenu(String id, HttpServletRequest request,HttpServletResponse response) {
		if(menuService.delMenu(Integer.valueOf(id))>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "删除失败");
		}
	}

	/**
	 * 改
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateMenu.do")
	public void updateMenu(Menutree menutree,HttpServletRequest request,HttpServletResponse response) {
		if(menuService.updateMenu(menutree)>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "修改失败");
		}
	}

	/**
	 * 查
	 * @param request
	 * @param response
	 */
	@RequestMapping("/menuInfo.do")
	public String menuInfo(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("allMenuList", menuService.getAllMenu());
		return "forward:/WEB-INF/view/menuinfo.jsp";
	}
	
	/**
	 * 查(一个)
	 * @param request
	 * @param response
	 */
	@RequestMapping("/editMenu.do")
	@ResponseBody
	public void editMenu(String id,HttpServletRequest request,HttpServletResponse response) {
		Menutree mt=menuService.getMenuByid(Integer.valueOf(id));
		JSONArray pam=JSONArray.fromObject(mt);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
