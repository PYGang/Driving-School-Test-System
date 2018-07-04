package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.po.Course;


public interface ICourseService {
	public List<Course> findCourses(String name);

	public void addCourse(String name);
	public Course findCourseById(int id);
	public void updateCourseByInfo(Course course);
	public void deleteCourse(int id);
	/**
	 * 根据当前的教师id查询属于这个教师的课程
	 * @param teaId
	 * @return
	 */
	public List<Course> findCoursesByTeacherId(int teaId);

}
