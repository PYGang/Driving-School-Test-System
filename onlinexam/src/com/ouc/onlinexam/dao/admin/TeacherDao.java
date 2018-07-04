package com.ouc.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.ouc.onlinexam.po.StuClass;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao{
	private DBUtil db = new DBUtil();
	@Override
	public List<Teacher> findAllTeacherByInfo(String name) {
		// TODO Auto-generated method stub
		/**
		 * 如果是查询所有，sql语句是:select * from teacher
		 * 如果模糊查询，sql语句是:select * from reacher where name like '%yao%'
		 * 这两句里共用的语句是select * from teacher,把共用的语句提取出来作为一个
		 * 这两局的区别在于如果是模糊查询，还需要加限定条件
		 * 模糊查询的语法是:like '%%'，两个百分号之间是模糊查询的变量名
		 */
		String sql = "select * from teacher ";
		List teacherList = new ArrayList();
		if(null!=name){
			sql=sql+" where name like '%"+name+"%'";
			try {
				teacherList=db.getQueryList(Teacher.class, sql, new Object[]{});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				teacherList = db.getQueryList(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
      return teacherList;
		
		
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql="insert teacher values(?,?,?)";
		//查重检测
		/*String sql2 = "select * from teacher where name =? and pwd =?";
		Teacher deptTeacher = new Teacher();
		try {
			deptTeacher = (Teacher) db.getObject(Teacher.class, sql2, new Object[]{teacher.getName(),teacher.getPwd(),teacher.getDeptName()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null == deptTeacher)*/
		try {
			db.execute(sql, new Object[]{teacher.getId(),teacher.getName(),teacher.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Teacher findTeacherById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where id =?";
		Teacher t = new Teacher();
		try {
			t = (Teacher) db.getObject(Teacher.class, sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	
	
	public static void main(String[] args) {
		ITeacherDao td = new TeacherDao();
		List teacherList = td.findAllTeacherByInfo("小");
		System.out.println(teacherList.size());
	}

	@Override
	public void updateTeacherById(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "update teacher set name =?,pwd=? where id="+teacher.getId();
		try {
			db.execute(sql, new Object[]{teacher.getName(),teacher.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void teacherDelete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from teacher where id = "+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
