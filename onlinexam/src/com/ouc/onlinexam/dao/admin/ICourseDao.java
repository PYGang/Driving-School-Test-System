package com.ouc.onlinexam.dao.admin;

import java.util.List;

import com.ouc.onlinexam.po.Course;

public interface ICourseDao {
	public List<Course> findAllCourseByInfo(String name) ;
	
	public void addCourse(String name);
	public Course findCourseById(int id);
	public void updateCourseById(Course course);
	public void deleteCourse(int id);
	/**
	 * 根据当前的教师id查询属于这个教师的课程
	 * @param teaId
	 * @return
	 */
	public List<Course> findCoursesByTeacherId(int teaId);

}
