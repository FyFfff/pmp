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
	 * ��Ȩ����
	 */
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private ShouQuanService shouQuanService;
	
	/**
	 * ��ѯҪ��Ȩ�û��ĵ�ǰ��ɫID
	 * @param wkno  ��Ȩ�û���ID
	 * @param request
	 * @param response
	 */
	@RequestMapping("/shouquanOper.do")
	@ResponseBody
	public void shouquanOper(String wkno,HttpServletRequest request,HttpServletResponse response) {
	
		//��ȡ��ɫ�б����ݣ�����session�е���Ϣ
		request.getSession().setAttribute("roleList", roleService.roleInfo());
		
		//����ǰ̨���������û�ID����ѯ��Ӧ�Ľ�ɫID
		OperatorRole oprl=shouQuanService.getRoleByWkno(Integer.valueOf(wkno));
		int roleid=0;
		if(oprl!=null){
			roleid=oprl.getRole_id();
		}
		//���ص�ǰ��Ӧ�Ľ�ɫID�����û�з���0
		JSONArray pam=JSONArray.fromObject(roleid);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �û���Ȩ
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addOperRole.do")
	public void addOperRole(OperatorRole operatorRole,HttpServletRequest request,HttpServletResponse response){
		
		//���ǰ̨��������Ȩ�û�����Ϣ��
		int wkno=operatorRole.getWk_no();
		//��ѯҪ��Ȩ�û��Ƿ��Ѿ��н�ɫ�󶨣�����У���ɾ����
		OperatorRole oprl=shouQuanService.getRoleByWkno(wkno);
		if(oprl!=null){
			shouQuanService.delRoleByWkno(wkno);
		}
		//�û����ɫ����Ϣ���浽���ݿ⣬���ؽ��
		if(shouQuanService.addRoleByWkno(operatorRole)>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "��Ȩʧ��");
		}
	}
	
	
	/**
	 * ��ѯҪ��Ȩ�Ľ�ɫ��ǰ�Ĳ˵��б�
	 * @param roleid Ҫ��Ȩ��ɫID
	 * @param request
	 * @param response
	 */
	@RequestMapping("/shouquanRole.do")
	@ResponseBody
	public void shouquanRole(String roleid,HttpServletRequest request,HttpServletResponse response) {
	
		//�������в˵�����Ϣ
		request.getSession().setAttribute("allMenuList", menuService.getMenu());

		//��õ�ǰ��ɫ��Ӧ�Ĺ��ܲ˵�ID
		List<RoleFunction> mlist=shouQuanService.getIdByRoleid(Integer.valueOf(roleid));
		//����json����
		JSONArray pam=JSONArray.fromObject(mlist);
		try {
			response.getWriter().println(pam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��ɫ��Ȩ��
	 * @param role_id Ҫ��Ȩ�Ľ�ɫID
	 * @param id ǰ̨�����Ĳ˵�ID����
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addRoleFunction.do")
	public void addRoleFunction(String role_id, String[] id, HttpServletRequest request,HttpServletResponse response){
		
		//��ѯ��ǰ��ɫ�Ƿ��Ѿ��ж�Ӧ�˵�������У���ɾ��
		List<RoleFunction> mlist=shouQuanService.getIdByRoleid(Integer.valueOf(role_id));
		if(mlist!=null){
			//���ݽ�ɫIDɾ����Ӧ�İ󶨹��ܲ˵���Ϣ
			shouQuanService.delIdByRoleid(Integer.valueOf(role_id));
		}
		
		//�����ɫ�빦�ܲ˵��Ķ�Ӧ��ϵ�����ݿ�
		int count=0;
		//��ɫ��˵���Ӧ�Ķ���
		RoleFunction roleFunction=null;
		
		for(int m=0; m<id.length; m++){
			roleFunction=new RoleFunction();
			//����Ҫ��Ȩ�Ľ�ɫID
			roleFunction.setRole_id(Integer.valueOf(role_id));
			//�˵�ID��ֵ��
			roleFunction.setId(Integer.valueOf(id[m]));
			//���浽���ݿ�
			count+=shouQuanService.addRoleFunction(roleFunction);
		}
		if(count>0){
			Message.returnMessage(response, "ok");
		}else{
			Message.returnMessage(response, "��Ȩʧ��");
		}
		
		
	}

	
}
