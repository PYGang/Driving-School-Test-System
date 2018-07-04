package com.ouc.onlinexam.po;

/**
 * 教师表
 * @author Moons
 *
 */
public class Teacher {
	private int id;//教师工号
	private String name;//教师姓名
	private String pwd;//教师密码
	//private String deptName;//所属方向
	//private int role;//
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
	/*public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}*/
	/*public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}*/
	
}
