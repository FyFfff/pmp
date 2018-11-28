package com.yy.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.bean.Operator;
import com.yy.service.LoginService;
import com.yy.service.OperService;
import com.yy.service.RoleService;
import com.yy.util.Message;

@Controller
@RequestMapping("/oper")
public class OperatorController {
	/**
	 * 管理员管理
	 * 
	 */
	@Autowired
	private OperService operService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 增
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addOper.do")
	public void addOper(Operator oper,HttpServletRequest request,HttpServletResponse response) {
		 //添加用户
			if(operService.addOper(oper)==1){
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
	@RequestMapping("/delOper.do")
	public void delOper(String wkno, HttpServletRequest request,HttpServletResponse response) {
			if(operService.delOper(Integer.valueOf(wkno))==1){
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
	@RequestMapping("/updateOper.do")
	public void updateOper(Operator oper,HttpServletRequest request,HttpServletResponse response) {
			if(operService.updateOper(oper)==1){
				Operator co = (Operator) request.getSession().getAttribute("currentOperator");				
				if(co.getWk_no()==oper.getWk_no()){ 
					//如果修改当前用户，更新session中的值
					request.getSession().setAttribute("currentOperator", loginService.getOpreterByid(Integer.valueOf(oper.getWk_no())));
				}
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
	@RequestMapping("/operInfo.do")
	public String operInfo(HttpServletRequest request,HttpServletResponse response) {

		request.setAttribute("operList", operService.operInfo());
		return "forward:/WEB-INF/view/operinfo.jsp";
	}
	
	/**
	 * 查(一个)
	 * @param request
	 * @param response
	 */
	@RequestMapping("/editOper.do")
	@ResponseBody
	public void editOper(String wkno,HttpServletRequest request,HttpServletResponse response) {

		Operator operator=loginService.getOpreterByid(Integer.valueOf(wkno));
		JSONArray pam=JSONArray.fromObject(operator);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
