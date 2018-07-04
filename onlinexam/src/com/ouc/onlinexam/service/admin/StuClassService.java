package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.dao.admin.IStuClassDao;
import com.ouc.onlinexam.dao.admin.StuClassDao;
import com.ouc.onlinexam.po.StuClass;

public class StuClassService implements IStuClassService{
	private IStuClassDao scd = new StuClassDao();
	@Override
	public StuClass findStuClassById(int id) {
		// TODO Auto-generated method stub
		return scd.findStuClassById(id);
	}

	@Override
	public List findAll(String name) {
		// TODO Auto-generated method stub
		return scd.findAllStuClassInfo(name);
	}

	@Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClassById(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.updateStuClassByid(sc);
	}
	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return scd.findStuClassesByTeacherId(teaId);
	}
	@Override
	public String findClassNamesByIds(String ids) {
	// TODO Auto-generated method stub
	return scd.findClassNamesByIds(ids);
	}

	@Override
	public void StuClassDelete(int id) {
		// TODO Auto-generated method stub
		scd.StuClassDelete(id);
	}

}
