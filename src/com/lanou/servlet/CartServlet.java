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
import com.lanou.bean.Cart;
import com.lanou.service.CarServiceImpl;
import com.lanou.service.ICarService;
import com.lanou.util.JSONBean;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	private ICarService carService = new CarServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null||op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			try {
				if(pagenum==null||pagecount==null) {
					pagenum="1";
					pagecount="10";
				}
				List<Cart> cartList = carService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				JSONBean jb = new JSONBean("0", "", carService.getCount(), cartList);
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
				carService.delCart(id);
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
