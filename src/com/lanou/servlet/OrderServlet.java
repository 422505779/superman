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
import com.lanou.bean.Order;
import com.lanou.service.IOrderService;
import com.lanou.service.OrderServiceImpl;
import com.lanou.util.JSONBean;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet{
	private IOrderService orService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null||op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				
				List<Order> cartList = orService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				JSONBean jb = new JSONBean("0", "", orService.getCount(), cartList);
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
				orService.delOrder(id);
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
