package com.lanou.service;

import java.util.List;

import com.lanou.bean.Img;

public interface IImgService {
	public List<Img> getAll() throws Exception;
	
	public void addImg(String img) throws Exception;
	
	public void delImg(String id) throws Exception;
	
	public void editImg(String id,String img) throws Exception;
}
