package com.ouc.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.StuClass;
import com.ouc.onlinexam.util.DBUtil;

/**
 * StuClassDao表示专门访问班级的Dao
 * 因为我们已经定义好了接口，所以在这里实现接口即可
 * 实现接口的时候，犯法已经定义
 * 实现接口，implements IStuClassDao
 * @author Moons
 *
 */
public class StuClassDao implements IStuClassDao {
	
	private DBUtil db = new DBUtil();
	@Override
	public List findAllStuClassInfo(String name) {
		// TODO Auto-generated method stub
		//定义一个sql语句
		String sql = "select * from stuclass";
		if(name!=null)
			sql = sql+" where name like '%"+name+"%'";
		List stuClassList = new ArrayList();
		try {
			/**
			 * StuClass.class表示查询结果，要封装成哪个类型
			 * 需要加上.class，不能直接写类名
			 * 直接使用类名的话，在生命变量的时候，可以作为变量的类型
			 * 以为sql语句里面已经写完整了，不需要填充任何参数，所以第三个参数是个空的Object类型的数据
			 * 光查询还不够，还要赋给一个变量
			 */
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public StuClass findStuClassById(int classId) {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass where id =?";
				//String sql = "select * from stuclass where id ="+classId + "and name = "+name;
		StuClass sc = new StuClass();
		try {
			sc = (StuClass) db.getObject(StuClass.class, sql, new Object[]{classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}
	
	@Override
	public void addStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "insert into stuclass values(?,?)";
		//查重
		String sql2 = "select * from stuclass where name =?";
		StuClass deptStuClass = new StuClass();
		try {
			deptStuClass = (StuClass) db.getObject(StuClass.class, sql2, new Object[]{sc.getName()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null == deptStuClass){
			try {
				db.execute(sql, new Object[]{sc.getId(),sc.getName()});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void updateStuClassByid(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "update stuclass set name =? where id="+sc.getId();
		String sql2 = "select * from stuclass where name =?";
		StuClass deptStuClass = new StuClass();
		try {
			deptStuClass = (StuClass) db.getObject(StuClass.class, sql2, new Object[]{sc.getName()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null == deptStuClass)
		try {
			db.execute(sql, new Object[]{sc.getName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from stuclass where id in (SELECT classId from teachercourse where teaId = ?)";
		List stuClassList= new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[]{teaId});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == stuClassList)
			stuClassList = new ArrayList();
		return stuClassList;
	}
	
	@Override
	public String findClassNamesByIds(String ids) {
	// TODO Auto-generated method stub
	String sql = "SELECT name from stuclass where id in ("+ids+")";
	List<Map<String, Object>> nameList = new ArrayList();
	try {
	nameList = db.getQueryList(sql, new Object[]{});
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}	
	String names = "";
	if (null != nameList){
		/**
		 * 遍历编辑名称集合，元素和元素之间用空格隔开
		 * StirngBuffer可以当成String理解
		 * 区别在于，如果一个字符串不断修改的话，使用StringBuffer
		 * 对于字符串增加内容，使用append方法
		 * 修改完字符串后，使用toString方法转换成字符串
		 */
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nameList.size();i++){
		sb.append(nameList.get(i).get("name")).append(" ");
		}
		names = sb.toString();
	}
	
	return names;
	}

	
	
	/**
	 * 测试的方法
	 * @param args
	 * 如果一个类中有main方法，那么这个类可以使用java application运行
	 * 运行的时候是在这个类上点击右键，运行方式有两种:run和debug
	 * 什么时候用run？我想直接看结果
	 * 如果我们想看中间过程，例如某个变量的值或者某个集合某个对象使用debug
	 * 
	 * 对于Web项目，要运行在服务器(tomacat)上
	 * 运行后，一般我们能够直接浏览页面
	 * 在运行项目的过程中，如果我们只关注结果，使用run on server
	 * 如果在项目运行过程中，我们关注中间过程，使用debug on server
	 */
	
	
	
	
	
	
	public static void main(String[] args) {
		/**
		 * 声明一个接口对象
		 * 苹果是水果
		 */
		IStuClassDao scd = new StuClassDao();
		List stuclassList =  scd.findAllStuClassInfo(null);
		System.out.println(stuclassList.size());
		StuClass sc = scd.findStuClassById(6);
		System.out.println(sc.getName());
//		StuClass depC = new StuClass();
//		depC.setId(Integer.valueOf("6"));
//		depC.setName("开发六班");
//		depC.setDeptName("开发");
//		scd.updateStuClassByid(depC, 6);
		String classNames = scd.findClassNamesByIds("1,2");
		System.out.println(classNames);

		
	}

	@Override
	public void StuClassDelete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from stuclass where id = "+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	
}
