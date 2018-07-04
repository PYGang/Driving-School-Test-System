package com.ouc.onlinexam.po;

public class Student {
	private int id;//学生学号
	private String name;//学生姓名
	private String pwd;//学生密码
	//private String school;//学校名称
	private String sex;//性别
	private String born;//出生日期
	//private String deptName;//
	private int classId;//所在班级
	public Student(){}
	public Student(int id,String name ,String pwd,String sex,String born,int classId){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		//this.school = school;
		this.sex = sex;
		this.born= born;
		//this.deptName = deptName;
		this.classId = classId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
}
