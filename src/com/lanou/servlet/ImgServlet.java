package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Img;
import com.lanou.service.IImgService;
import com.lanou.service.ImgServiceImpl;
import com.lanou.util.JSONBean;

public class ImgServlet extends HttpServlet{
	private IImgService imgService = new ImgServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null||op.equals("")) {
			try {
				List<Img> imglist = imgService.getAll();
				JSONBean jb = new JSONBean("0", "", imglist.size(), imglist);
				resp.setContentType("text/html;charset=utf-8");//解决乱码
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
				imgService.delImg(id);
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				JSONBean jb = new JSONBean("200", "", null, null);
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Part part = req.getPart("file");
				String filename = part.getSubmittedFileName();
				String path = req.getServletContext().getRealPath("");
				path = path.substring(0, path.lastIndexOf("\\"));
				path = path.substring(0, path.lastIndexOf("\\"));
				path = path+File.separator+"img"+File.separator;
				part.write(path+filename);
				imgService.addImg(filename);
				JSONBean jb = new JSONBean("0", "", null, null);
				resp.setContentType("text/html;charset=utf-8");//解决乱码
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
