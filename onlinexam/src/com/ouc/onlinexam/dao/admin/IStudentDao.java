package com.ouc.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Student;

public interface IStudentDao {
	
	public void addStudent(Student s);
	
	public Student findStudentById(int id);
	
	public List<Map<String,Object>> findAll(String name);
	public void updateStudentByInfo(Student s);
	public void deleteStudent(int id);
}
