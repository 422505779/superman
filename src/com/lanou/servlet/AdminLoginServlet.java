package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Admin;
import com.lanou.service.AdminServiceImpl;
import com.lanou.service.IAdminService;
import com.lanou.util.JSONBean;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet{
	private AdminServiceImpl ias = new AdminServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminname = req.getParameter("adminname");
		String adminpwd = req.getParameter("password");
		try {
			Admin admin = ias.qryByNameAndPwd(adminname, adminpwd);
			req.getSession().setAttribute("admin", admin);
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
