package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.User;
import com.lanou.service.IUserService;
import com.lanou.service.UserServiceImpl;
import com.lanou.util.JSONBean;

@WebServlet("/userbefore/userServlet")
public class UserServlet extends HttpServlet{
	private UserServiceImpl userServlet = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null||op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			try {
				List<User> userlist = userServlet.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				PageInfo<User> list = new PageInfo<>(userlist);
				JSONBean jb = new JSONBean("0", "", (int)list.getTotal(), list.getList());
				resp.setContentType("text/html;charset=utf-8");
				String jsonStr = JSON.toJSONString(jb);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id = req.getParameter("id");
			try {
				userServlet.delUser(id);
				JSONBean jb = new JSONBean("200", "", null, null);
				resp.setContentType("text/html;charset=utf-8");
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("mail");
		String address = req.getParameter("address");
		if(op.equals("add")) {
			try {
				userServlet.addUser(name, pwd, phone, mail, address);
				JSONBean jb = new JSONBean("200", "", null, null);
				resp.setContentType("text/html;charset=utf-8");
				String jsonStr = JSON.toJSONString(jb);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")) {
			String id = req.getParameter("id");
			try {
				userServlet.editUser(id, name, pwd, phone, mail, address);
				JSONBean jb = new JSONBean("200", "", null, null);
				resp.setContentType("text/html;charset=utf-8");
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
}
