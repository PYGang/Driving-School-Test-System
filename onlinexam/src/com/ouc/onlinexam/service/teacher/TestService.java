package com.ouc.onlinexam.service.teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ouc.onlinexam.dao.admin.IStuClassDao;
import com.ouc.onlinexam.dao.admin.StuClassDao;
import com.ouc.onlinexam.dao.teacher.ITestDao;
import com.ouc.onlinexam.dao.teacher.TestDao;
import com.ouc.onlinexam.po.Test;

public class TestService implements ITestService{
	private ITestDao td = new TestDao();
	@Override
	public void addTest(Test t) {
		// TODO Auto-generated method stub
		td.addTest(t);
	}
	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return td.getTestByStudent(id, currData);
	}
	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return td.findStudentTestsById(studentid, testid);
	}
	@Override
	public List<Map<String, Object>> getRencentTestByTeaId(int id) {
		// TODO Auto-generated method stub
		
		return td.getTestByTeaId(id);
	}
}
