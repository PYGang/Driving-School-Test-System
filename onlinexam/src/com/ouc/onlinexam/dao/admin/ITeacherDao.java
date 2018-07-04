package com.ouc.onlinexam.dao.admin;

import java.util.List;

import com.ouc.onlinexam.po.Teacher;

public interface ITeacherDao {
	/**
	 * 通过姓名查询符合条件的教师对象
	 * 支持模糊查询
	 * @param name 教师姓名，如果name是null表示查询所有
	 * @return
	 */
	public List<Teacher> findAllTeacherByInfo(String name) ;
	
	public void addTeacher(Teacher teacher);
	public Teacher findTeacherById(int id);
	public void updateTeacherById(Teacher teacher);
	public void teacherDelete(int id);
}
