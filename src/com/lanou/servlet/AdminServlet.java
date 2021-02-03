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
import com.lanou.bean.Admin;
import com.lanou.service.AdminServiceImpl;
import com.lanou.service.IAdminService;
import com.lanou.util.JSONBean;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet{
	private AdminServiceImpl ias = new AdminServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String id = req.getParameter("id");
		String adminname = req.getParameter("adminname");
		String adminpwd = req.getParameter("adminpwd");
		if(op.equals("add")) {
			try {
				ias.addAdmin(adminname, adminpwd);
				JSONBean jb = new JSONBean("200", "", null, null);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")) {
			try {
				ias.editAdmin(id, adminname, adminpwd);
				JSONBean jb = new JSONBean("200", "", null, null);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null||op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			try {
				List<Admin> adminlist = ias.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				PageInfo<Admin> list = new PageInfo<>(adminlist);
				JSONBean jb = new JSONBean("0", "", (int)list.getTotal(), list.getList());
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id = req.getParameter("id");
			try {
				ias.delAdmin(Integer.parseInt(id));
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
