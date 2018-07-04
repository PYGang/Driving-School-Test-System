package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.po.Teacher;

public interface ITeacherService {
	/**
	 * 此方法用来查询符合条件的教师信息
	 * @param name 教师姓名
	 * @return 教师集合List，集合里都是Teacher对象
	 */
	public List<Teacher> findTeachers(String name);

	public void addTeacher(Teacher teacher);
	public Teacher findTeacherById(int id);
	public void updateTeacherById(Teacher t);
	public void teacherDelete(int id);
}
