package com.lanou.service;

import java.util.List;

import com.lanou.bean.Img;
import com.lanou.dao.IImgDao;
import com.lanou.dao.ImgDaoImpl;

public class ImgServiceImpl implements IImgService{
	private IImgDao imgDao = new ImgDaoImpl();
	@Override
	public List<Img> getAll() throws Exception {
		return imgDao.getAll();
	}
	@Override
	public void addImg(String img) throws Exception {
		imgDao.addImg(img);
	}
	@Override
	public void delImg(String id) throws Exception {
		imgDao.delImg(id);
		
	}
	@Override
	public void editImg(String id, String img) throws Exception {
		imgDao.editImg(id, img);
	}

}
