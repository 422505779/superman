package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeService {
	public List<Type> getAll() throws Exception;
	
	public List<Type> getAll(int parentid) throws Exception;
	
	public void addType(String typename,int parentid) throws Exception;
	
	public void updateType(int id,String typename) throws Exception;
	
	public void delType(int id) throws Exception;
	
	public List<Type> getAllById(int id) throws Exception;
}
