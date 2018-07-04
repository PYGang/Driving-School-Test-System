package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.po.TeacherCourse;
import com.ouc.onlinexam.vo.TeacherCourseView;

public interface IScheduleService {
	/**
	 * 查询所有的关系映射表
	 * @return
	 */
	public List<TeacherCourseView> findAll(String name);


	/**
	 * 添加排课信息，包括老师，班级，和课程。
	 * @return
	 */
	public void addSchedule(TeacherCourse tc);
	public TeacherCourse  findTeacherCourseById(int tcId);
	public void updateTeacherCourseById(TeacherCourse tc);
	public void deleteSchedule(int id);
}
