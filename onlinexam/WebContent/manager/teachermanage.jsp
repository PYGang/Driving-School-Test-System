<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
-->
</style>
</head>

<body>
	<h3 class="subTitle">
		教练管理
		<div class="search">
			<form id="form1" method="get" action="<%=path %>/teacherQueryServlet">
				教练姓名：<input type="text" name="searchkey" value='' /> <input
					type="submit" name="Submit" class="btn" value="搜索" />
			</form>

		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path %>/teacherAddServlet">增加教练</a>
	</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td width="187" height="51">教练工号</td>
			<td width="91">教练姓名</td>
			<td width="156">登录密码</td>
			<!--<td width="138" >课程名称</td>  -->
			<td width="91">修改操作</td>
			<td width="92">删除操作</td>
		</tr>
		<c:forEach items="${teacherList }" var="teacher">
			<tr align="center">
				<td>${teacher.id }</td>
				<td>${teacher.name }</td>
				<td>${teacher.pwd }</td>
				<!--<td>${teacher.deptName }</td>  -->
				<td><a href="<%=path %>/teacherModifyServlet?id=${teacher.id }"
					target="_self">修改</a></td>
				<td><a href="<%=path %>/teacherDeleteServlet?id=${teacher.id }"
					target="_self" onclick="javascript: return confirm('确认删除吗？')">删除</td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>