package com.ouc.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.dao.admin.IStudentDao;
import com.ouc.onlinexam.dao.admin.StudentDao;
import com.ouc.onlinexam.po.Student;

public class StudentService implements IStudentService {
	private IStudentDao sd= new StudentDao();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll(String name) {
		// TODO Auto-generated method stub
		return sd.findAll(name);
	}

	@Override
	public void updateStudentByInfo(Student s) {
		// TODO Auto-generated method stub
		sd.updateStudentByInfo(s);
	}

	@Override
	public void studentDelete(int id) {
		// TODO Auto-generated method stub
		sd.deleteStudent(id);
	}

}
