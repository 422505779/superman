package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Cart;
import com.lanou.bean.User;
import com.lanou.service.CarServiceImpl;
import com.lanou.service.ICarService;
import com.lanou.util.JSONBean;

@WebServlet("/userbefore/cart")
public class UserCartServlet extends HttpServlet{
	private ICarService carService = new CarServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		
		String id = "";
		String uname = "";
		Cookie[] cs = req.getCookies();
		
		if(cs==null||cs.length==0) {

		}else {
			for(Cookie c : cs) {
				String key = c.getName();
				if(key.equals("id")) {
					id = c.getValue();
				}
				if(key.equals("uname")) {
					uname = c.getName();
				}
			}
		}
		
		
		if(uname!="") {
			if(op==null||op.equals("")) {
				String pagenum = req.getParameter("page");
				String pagecount = req.getParameter("limit");
				try {
					if(pagenum==null||pagecount==null) {
						pagenum="1";
						pagecount="10";
					}
					List<Cart> cartList = carService.getByPage(Integer.parseInt(id),Integer.parseInt(pagenum), Integer.parseInt(pagecount));
					resp.setContentType("text/html;charset=utf-8");
					String jsonStr = JSON.toJSONString(cartList);
					PrintWriter pw = resp.getWriter();
					pw.write(jsonStr);
					pw.flush();
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(op.equals("add")) {
				String pagenum = req.getParameter("page");
				String pagecount = req.getParameter("limit");
				String pid = req.getParameter("id");
				String uid = req.getParameter("uid");
				try {
					carService.addCart(Integer.parseInt(uid), Integer.parseInt(pid));
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
			}else if(op.equals("del")) {
				String id1 = req.getParameter("id");
				try {
					carService.delCart(id1);
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
}
