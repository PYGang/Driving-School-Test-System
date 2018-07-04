package com.ouc.onlinexam.dao.login;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.po.Teacher;

public interface ILoginDao {
	/**
	 * 判断是否能登录
	 * @param t 封装的teacher对象，包含登陆的用户名和密码
	 * @return 如果返回null，表示用户不存在或用户名密码不匹配，不允许登录
	 * 			如果不返回null，则返回一个Teacher对象，说明用户名密码匹配，可以登录
	 */
	public Teacher canLogin(Teacher t);
	public Student canLogin(Student s);
}
