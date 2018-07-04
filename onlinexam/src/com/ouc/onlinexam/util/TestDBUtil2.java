package com.ouc.onlinexam.util;

import com.ouc.onlinexam.po.Course;

public class TestDBUtil2 {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		/*String sql = "insert into course(name) values('ssh')";
		db.execute(sql);*/
		
		/*String sql1="update course set name='ssh1' where name='ssh'";
		db.execute(sql1);*/
		
		/*String sql2 ="insert into teacher(name,pwd,deptName) values(?,?,?) ";
		db.execute(sql2, new Object[]{"小薇","123","开发"});*/
		
		/*String sql3="update teacher set name =? where name ='小薇'";
		db.execute(sql3,new Object[]{"小biang"});*/
		
		String sql4="select * from course where id =?";
		Course c = (Course)db.getObject(Course.class,sql4,new Object[]{1});
		System.out.println(c.getName());
	}
}
