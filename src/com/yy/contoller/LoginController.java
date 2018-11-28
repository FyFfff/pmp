package com.yy.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.bean.Menutree;
import com.yy.bean.Operator;
import com.yy.service.LoginService;
import com.yy.service.MenuService;
import com.yy.service.RoleService;
import com.yy.util.Message;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * ��¼ҳ���ύ��ַ��
	 * 
	 * @param userid
	 * @param pwd
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getuser.do")
	public void login(String wk_no, String pwd, HttpServletRequest request,
			HttpServletResponse response) {

		Operator optor = null;

			// ��֤�˺ź�����
			if (wk_no == null || wk_no == "") {
				Message.returnMessage(response, "�˺ű���");
			} else if (pwd == null || pwd == "") {
				Message.returnMessage(response, "�������");
			} else {

				/**
				 *  �˺ź�������֤ͨ������ѯ�˺���Ϣ
				 *  1.�鿴�Ƿ�����
				 *  2.δ�������鿴��¼ʧ�ܴ������Ƿ����涨����
				 *  3.δ�������ȶ������Ƿ���ȷ
				 *  4.���벻��ȷ����¼ʧ�ܴ����������涨���������˺�
				 */
				optor = loginService.getOpreterByid(Integer.valueOf(wk_no));

				// �鿴�˺��Ƿ����
				if (optor != null) {
					// �˺�״̬
					int is_lock = optor.getIs_lock();
					// ��¼ʧ�ܴ���
					int tryTimes = optor.getTrytimes();
					// �˺�����
					String oPassWord = optor.getPassword();
					// �鿴�Ƿ�����
					if (is_lock != 0) {
						Message.returnMessage(response, "���˺��ѱ�����");
					} else {
						// �鿴�Ƿ�ʧ�ܴ�������
						if (tryTimes < 5) {
							// �鿴�����Ƿ���ȷ
							if (oPassWord.equals(pwd)) {
								//������ȷ�����浱ǰ�û���Ϣ��session��
								request.getSession().setAttribute("currentOperator", optor);
								//��ѯ��ǰ�û���Ӧ�Ĳ˵��б�
								List<Menutree> menulist=menuService.getMenuByOperId(optor.getWk_no());
								request.getSession().setAttribute("menuTree", menulist);
								request.getSession().setAttribute("roleList", roleService.roleInfo());
								request.getSession().setAttribute("allMenuList", menuService.getMenu());
								Message.returnMessage(response, "ok");
							} else {
								//������󣬸���ʧ�ܴ��� tryTimes+1
								int newTimes=tryTimes+1;
								loginService.updateTryTimes(optor.getWk_no(), newTimes);
								Message.returnMessage(response, "������������ԣ�ʧ�ܴ���"+newTimes);
							}
						} else {
							//�����˺ţ�is_lock����Ϊ 1
							loginService.updateIsLock(optor.getWk_no(), 1);
							Message.returnMessage(response, "ʧ�ܴ�������5�Σ����˺��ѱ�����");

						}
					}
				} else {
					//optorΪ�գ�û�и��˺�
					Message.returnMessage(response, "���˺Ų�����");
				}
			}


	}

	/**
	 * ��¼�ɹ�����ת�¸�ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/home.do")
	public String goHome() {
		return "forward:/WEB-INF/view/home.jsp";
	}
	
	/**
	 * �˳�
	 * @param request
	 * @param response
	 */
	@RequestMapping("/logout.do")
	public void logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		try {
			response.sendRedirect("/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// ����modelandview
	// @RequestMapping("/gook.do")
	// public ModelAndView gook() {
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.setViewName("/WEB-INF/view/ok.jsp");
	// return modelAndView;
	// }

}
