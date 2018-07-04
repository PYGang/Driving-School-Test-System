package com.ouc.onlinexam.po;

/**
 * 教师课程关联
 * @author Moons
 *
 */
public class TeacherCourse {
	private int id;//所教课程编号
	private int teaId;//教师编号
	private int courseId;//课程编号
	private int classId;//班级编号

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
}
