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
	 * 登录页面提交地址，
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

			// 验证账号和密码
			if (wk_no == null || wk_no == "") {
				Message.returnMessage(response, "账号必填");
			} else if (pwd == null || pwd == "") {
				Message.returnMessage(response, "密码必填");
			} else {

				/**
				 *  账号和密码验证通过，查询账号信息
				 *  1.查看是否被锁定
				 *  2.未锁定，查看登录失败次数，是否查过规定次数
				 *  3.未超过，比对密码是否正确
				 *  4.密码不正确，记录失败次数，超过规定次数锁定账号
				 */
				optor = loginService.getOpreterByid(Integer.valueOf(wk_no));

				// 查看账号是否存在
				if (optor != null) {
					// 账号状态
					int is_lock = optor.getIs_lock();
					// 登录失败次数
					int tryTimes = optor.getTrytimes();
					// 账号密码
					String oPassWord = optor.getPassword();
					// 查看是否被锁定
					if (is_lock != 0) {
						Message.returnMessage(response, "该账号已被锁定");
					} else {
						// 查看是否失败次数过多
						if (tryTimes < 5) {
							// 查看密码是否正确
							if (oPassWord.equals(pwd)) {
								//密码正确，保存当前用户信息到session中
								request.getSession().setAttribute("currentOperator", optor);
								//查询当前用户对应的菜单列表
								List<Menutree> menulist=menuService.getMenuByOperId(optor.getWk_no());
								request.getSession().setAttribute("menuTree", menulist);
								request.getSession().setAttribute("roleList", roleService.roleInfo());
								request.getSession().setAttribute("allMenuList", menuService.getMenu());
								Message.returnMessage(response, "ok");
							} else {
								//密码错误，更新失败次数 tryTimes+1
								int newTimes=tryTimes+1;
								loginService.updateTryTimes(optor.getWk_no(), newTimes);
								Message.returnMessage(response, "密码错误，请重试，失败次数"+newTimes);
							}
						} else {
							//锁定账号，is_lock设置为 1
							loginService.updateIsLock(optor.getWk_no(), 1);
							Message.returnMessage(response, "失败次数超过5次，该账号已被锁定");

						}
					}
				} else {
					//optor为空，没有该账号
					Message.returnMessage(response, "该账号不存在");
				}
			}


	}

	/**
	 * 登录成功，跳转下个页面
	 * 
	 * @return
	 */
	@RequestMapping("/home.do")
	public String goHome() {
		return "forward:/WEB-INF/view/home.jsp";
	}
	
	/**
	 * 退出
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
	// 返回modelandview
	// @RequestMapping("/gook.do")
	// public ModelAndView gook() {
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.setViewName("/WEB-INF/view/ok.jsp");
	// return modelAndView;
	// }

}
