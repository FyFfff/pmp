package com.yy.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.bean.Role;
import com.yy.service.RoleService;
import com.yy.util.Message;

@Controller
@RequestMapping("/role")
public class RoleController {
	/**
	 * 角色管理
	 */
	@Autowired
	private RoleService roleService;

	
	/**
	 * 增
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addRole.do")
	public void addRole(Role role,HttpServletRequest request,HttpServletResponse response) {
			if(roleService.addRole(role)==1){
				Message.returnMessage(response, "ok");
			}else{
				Message.returnMessage(response, "保存失败");
			}
	}
	
	/**
	 * 删
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delRole.do")
	public void delRole(String roleid, HttpServletRequest request,HttpServletResponse response) {
			if(roleService.delRole(Integer.valueOf(roleid))==1){
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
	@RequestMapping("/updateRole.do")
	public void updateRole(Role role,HttpServletRequest request,HttpServletResponse response) {
			if(roleService.updateRole(role)==1){				
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
	@RequestMapping("/roleInfo.do")
	public String roleInfo(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("roleList", roleService.roleInfo());
		return "forward:/WEB-INF/view/roleinfo.jsp";
	}
	
	/**
	 * 查(一个)
	 * @param request
	 * @param response
	 */
	@RequestMapping("/editRole.do")
	@ResponseBody
	public void editRole(String roleid,HttpServletRequest request,HttpServletResponse response) {
		Role role=roleService.getRoleOne(Integer.valueOf(roleid));
		JSONArray pam=JSONArray.fromObject(role);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
