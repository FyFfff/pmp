package com.yy.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.bean.OperatorRole;
import com.yy.bean.RoleFunction;
import com.yy.service.MenuService;
import com.yy.service.RoleService;
import com.yy.service.ShouQuanService;
import com.yy.util.Message;

@Controller
@RequestMapping("/sq")
public class shouquanController {
	/**
	 * 授权管理
	 */
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private ShouQuanService shouQuanService;
	
	/**
	 * 查询要授权用户的当前角色ID
	 * @param wkno  授权用户的ID
	 * @param request
	 * @param response
	 */
	@RequestMapping("/shouquanOper.do")
	@ResponseBody
	public void shouquanOper(String wkno,HttpServletRequest request,HttpServletResponse response) {
	
		//获取角色列表内容，更新session中的信息
		request.getSession().setAttribute("roleList", roleService.roleInfo());
		
		//根据前台传过来的用户ID，查询对应的角色ID
		OperatorRole oprl=shouQuanService.getRoleByWkno(Integer.valueOf(wkno));
		int roleid=0;
		if(oprl!=null){
			roleid=oprl.getRole_id();
		}
		//返回当前对应的角色ID，如果没有返回0
		JSONArray pam=JSONArray.fromObject(roleid);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户授权
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addOperRole.do")
	public void addOperRole(OperatorRole operatorRole,HttpServletRequest request,HttpServletResponse response){
		
		//获得前台传来的授权用户的信息，
		int wkno=operatorRole.getWk_no();
		//查询要授权用户是否已经有角色绑定，如果有，先删除，
		OperatorRole oprl=shouQuanService.getRoleByWkno(wkno);
		if(oprl!=null){
			shouQuanService.delRoleByWkno(wkno);
		}
		//用户与角色绑定信息保存到数据库，返回结果
		if(shouQuanService.addRoleByWkno(operatorRole)>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "授权失败");
		}
	}
	
	
	/**
	 * 查询要授权的角色当前的菜单列表，
	 * @param roleid 要授权角色ID
	 * @param request
	 * @param response
	 */
	@RequestMapping("/shouquanRole.do")
	@ResponseBody
	public void shouquanRole(String roleid,HttpServletRequest request,HttpServletResponse response) {
	
		//更新所有菜单的信息
		request.getSession().setAttribute("allMenuList", menuService.getMenu());

		//获得当前角色对应的功能菜单ID
		List<RoleFunction> mlist=shouQuanService.getIdByRoleid(Integer.valueOf(roleid));
		//返回json数据
		JSONArray pam=JSONArray.fromObject(mlist);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 角色授权，
	 * @param role_id 要授权的角色ID
	 * @param id 前台传来的菜单ID数组
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addRoleFunction.do")
	public void addRoleFunction(String role_id, String[] id, HttpServletRequest request,HttpServletResponse response){
		
		//查询当前角色是否已经有对应菜单，如果有，先删除
		List<RoleFunction> mlist=shouQuanService.getIdByRoleid(Integer.valueOf(role_id));
		if(mlist!=null){
			//根据角色ID删除对应的绑定功能菜单信息
			shouQuanService.delIdByRoleid(Integer.valueOf(role_id));
		}
		
		//保存角色与功能菜单的对应关系到数据库
		int count=0;
		//角色与菜单对应的对象
		RoleFunction roleFunction=null;
		
		for(int m=0; m<id.length; m++){
			roleFunction=new RoleFunction();
			//设置要授权的角色ID
			roleFunction.setRole_id(Integer.valueOf(role_id));
			//菜单ID赋值，
			roleFunction.setId(Integer.valueOf(id[m]));
			//保存到数据库
			count+=shouQuanService.addRoleFunction(roleFunction);
		}
		if(count>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "授权失败");
		}
		
		
	}

	
}
