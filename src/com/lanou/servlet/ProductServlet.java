package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImpl;
import com.lanou.service.IProductService;
import com.lanou.service.ITypeService;
import com.lanou.service.ProductServiceImpl;
import com.lanou.service.TypeServiceImpl;
import com.lanou.util.JSONBean;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class ProductServlet extends HttpServlet{
	private IProductService proService = new ProductServiceImpl();
	private ITypeService typeService = new TypeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null||op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			try {
				List<Product> proList = proService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				JSONBean jb = new JSONBean("0", "", proService.getCount(), proList);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("seartext")) {
			try {
				String seartext = req.getParameter("seartext");
				List<Product> proList2 = new ArrayList<Product>();
				List<Product> proList = proService.getByPage(1, 10);
				for(Product pro : proList) {
					if(pro.getPname().contains(seartext)) {
						proList2.add(pro);
					}
				}
				JSONBean jb = new JSONBean("0", "", proService.getCount(), proList2);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("type")) {
			String typeid = req.getParameter("typeid");
			try {
				List<Product> proList = proService.getProByTypeid(Integer.parseInt(typeid));
				JSONBean jb = new JSONBean("0", "", proService.getCount(), proList);
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
				proService.delProduct(Integer.parseInt(id));
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
		String parentid = req.getParameter("parentid");
		if(op==null||op.equals("")) {
			Part part = req.getPart("file");
			String filename = part.getSubmittedFileName();
			String path = req.getServletContext().getRealPath("");
			path = path.substring(0, path.lastIndexOf("\\"));
			path = path.substring(0, path.lastIndexOf("\\"));
			path = path+File.separator+"img"+File.separator;
			part.write(path+filename);
			JSONBean jb = new JSONBean("0", "", null, filename);
			String jsonStr = JSON.toJSONString(jb);
			PrintWriter pw = resp.getWriter();
			pw.write(jsonStr);
			pw.flush();
			pw.close();
			
		}else if(op.equals("add")) {
			String filename = req.getParameter("pimg");
			String pname = req.getParameter("pname");
			String price = req.getParameter("price");
			String quiz1 = req.getParameter("quiz1");
			String quiz2 = req.getParameter("quiz2");
			String quiz3 = req.getParameter("quiz3");
			String title1 = "";
			String title2 = "";
			String title3 = "";
			try {
				List<Type> list1 = typeService.getAllById(Integer.parseInt(quiz1));
				for(Type t : list1) {
					title1 = t.getTitle();
				}
				List<Type> list2 = typeService.getAllById(Integer.parseInt(quiz2));
				for(Type t : list2) {
					title2 = t.getTitle();
				}
				List<Type> list3 = typeService.getAllById(Integer.parseInt(quiz3));
				for(Type t : list3) {
					title3 = t.getTitle();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String ptitle = title1+"-"+title2+"-"+title3;
			String pv = req.getParameter("pv");
			String typeid = req.getParameter("typeid");
			try {
				proService.addProduct(pname, filename, price, ptitle, pv, typeid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")) {
			String id = req.getParameter("id");
			String pimg = req.getParameter("pimg");
			System.out.println(op+pimg);
			String pname = req.getParameter("pname");
			String price = req.getParameter("price");
			String quiz1 = req.getParameter("quiz1");
			String quiz2 = req.getParameter("quiz2");
			String quiz3 = req.getParameter("quiz3");
			String title1 = "";
			String title2 = "";
			String title3 = "";
			try {
				List<Type> list1 = typeService.getAllById(Integer.parseInt(quiz1));
				for(Type t : list1) {
					title1 = t.getTitle();
				}
				List<Type> list2 = typeService.getAllById(Integer.parseInt(quiz2));
				for(Type t : list2) {
					title2 = t.getTitle();
				}
				List<Type> list3 = typeService.getAllById(Integer.parseInt(quiz3));
				for(Type t : list3) {
					title3 = t.getTitle();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String ptitle = title1+"-"+title2+"-"+title3;
			
			String pv = req.getParameter("pv");
			String typeid = req.getParameter("typeid");
			try {
				proService.editProduct(id, pname, pimg, price, ptitle, pv, typeid);
				JSONBean jb = new JSONBean("200", "", null, null);
				resp.setContentType("text/html;charset=UTF-8");
				String jsonStr = JSON.toJSONString(jb);
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("one")) {
			try {
				List<Type> oneList = typeService.getAll(0);
				String jsonStr = JSON.toJSONString(oneList);
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("two")){
			try {
				List<Type> twoList = typeService.getAll(Integer.parseInt(parentid));
				String jsonStr = JSON.toJSONString(twoList);
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("three")){
			try {
				List<Type> thrList = typeService.getAll(Integer.parseInt(parentid));
				String jsonStr = JSON.toJSONString(thrList);
				resp.setContentType("text/html;charset=UTF-8");
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
