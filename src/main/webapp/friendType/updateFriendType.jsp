<%@ page
	language="java"
	import="java.util.*, com.jstfs.web.friends.dto.*, com.jstfs.web.friends.dao.*"
	contentType="text/html; charset=utf-8"
%>

<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>更新朋友类别</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/updateFriendType" method="post" name="update" id="update">
			<table width="40%" border="1" align="center" style="border-collapse: collapse">
				<caption>
					<font color="#990099">修改朋友类别信息</font>
				</caption>
				<tr bgcolor="#FFFFCC">
					<th align="right">类别Id:</th>
					<td align="left">
						<input name="typeId" readonly="readonly" value="${requestScope.friendType.typeId}">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">名称:</th>
					<td align="left">
						<input name="typeName" value="${requestScope.friendType.typeName}">
					</td>
				</tr>      
				<tr bgcolor="#FFFFCC">
					<th align="right">简介:</th>
					<td align="left">
						<input name="context" value="${requestScope.friendType.context}">
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" name="Submit" value="修改">
						<input type="reset" name="Submit2" value="重置">
						<a href="${pageContext.request.contextPath}/index.jsp">取消</a>
					</th>
				</tr>
			</table>
		</form>
	</body>
</html>