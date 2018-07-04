package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.dao.admin.ITeacherDao;
import com.ouc.onlinexam.dao.admin.TeacherDao;
import com.ouc.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService{
	private ITeacherDao td = new TeacherDao();
	@Override
	public List<Teacher> findTeachers(String name) {
		return td.findAllTeacherByInfo(name);
		// TODO Auto-generated method stub
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		td.addTeacher(teacher);
	}

	@Override
	public Teacher findTeacherById(int id) {
		// TODO Auto-generated method stub
		return td.findTeacherById(id);
	}

	@Override
	public void updateTeacherById(Teacher t) {
		// TODO Auto-generated method stub
		td.updateTeacherById(t);
	}

	@Override
	public void teacherDelete(int id) {
		// TODO Auto-generated method stub
		td.teacherDelete(id);
	}
	
}
