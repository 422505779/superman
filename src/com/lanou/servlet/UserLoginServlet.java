package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Admin;
import com.lanou.bean.User;
import com.lanou.service.IUserService;
import com.lanou.service.UserServiceImpl;
import com.lanou.util.JSONBean;

@WebServlet("/userbefore/userLoginServlet")
public class UserLoginServlet extends HttpServlet{
	private UserServiceImpl userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		try {
			User user = userService.qryByNameAndPwd(name, pwd);
			
			String id = user.getId().toString();
			String uname = user.getName();
			Cookie c1 = new Cookie("id",id);
			Cookie c2 = new Cookie("uname",uname);
			c1.setMaxAge(500);
			c2.setMaxAge(500);
			resp.addCookie(c1);
			resp.addCookie(c2);
			
			resp.setContentType("text/html;charset=UTF-8");
			JSONBean jb = new JSONBean("0", "", null, null);
			String jsonStr = JSON.toJSONString(jb);
			PrintWriter pw = resp.getWriter();
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
