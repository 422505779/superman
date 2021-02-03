package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImpl;

public class TypeServiceImpl implements ITypeService{
	private ITypeDao typeDao = new TypeDaoImpl();
	@Override
	public List<Type> getAll() throws Exception {
		List<Type> list1 = typeDao.getAll(0);
		for(Type type : list1) {
			List<Type> list2 = typeDao.getAll(type.getId());
			type.setChildren(list2);
			for(Type t : list2) {
				List<Type> list3 = typeDao.getAll(t.getId());
				t.setChildren(list3);
			}
		}
		return list1;
	}
	
	
	
	@Override
	public void addType(String typename, int parentid) throws Exception {
		typeDao.addType(typename, parentid);
	}
	@Override
	public void updateType(int id, String typename) throws Exception {
		typeDao.updateType(id, typename);
	}
	@Override
	public void delType(int id) throws Exception {
		typeDao.delType(id);
		
	}
	@Override
	public List<Type> getAll(int parentid) throws Exception {
		
		return typeDao.getAll(parentid);
	}



	@Override
	public List<Type> getAllById(int id) throws Exception {
		
		return typeDao.getAllById(id);
	}

}
