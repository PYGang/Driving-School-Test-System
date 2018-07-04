package com.ouc.onlinexam.dao.admin;

import java.util.List;

import com.ouc.onlinexam.po.TeacherCourse;
import com.ouc.onlinexam.vo.TeacherCourseView;

public interface IScheduleDao {
	/**
	 * 返回一个集合，集合里的每个元素都是TeahcerCourseView类型
	 * 
	 * @return
	 */
	public List<TeacherCourseView> findAll(String name);


	/**
	 * 添加TeacherCourse对象
	 * 这个对象描述了班级教师课程时间的关系
	 * @return
	 */
	public void addSchedule(TeacherCourse tc);
	public TeacherCourse findTeacherCourseById(int id);
	public void updateTCById(TeacherCourse tc);
	public void deleteSchedule(int id);
}
