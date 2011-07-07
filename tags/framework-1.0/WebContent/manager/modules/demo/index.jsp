<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>demo page</title>
	</head>
	<body>
		<h1><a href="manager/modules/demo/save.jsp">添加数据</a></h1>
		<s:iterator value="#request.DEMO_LIST">
			<a href="demoDeleteAction?id=${id}" >删除</a> ${id}： ${title} ------- ${content} ${publishdate}<br />
		</s:iterator>
	</body>
</html>