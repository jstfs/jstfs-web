<%@ page
	language="java"
	import="java.util.*"
	contentType="text/html; charset=utf-8"
%>

<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>朋友管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<table width="266" height="280" border="2" align="center">
			<tr align="center" bgcolor="#6633CC">
				<th>
					<font color="white" size="5" face="华文细黑">我的通讯录</font>
				</th>
			</tr>
			<tr bgcolor="#FFFFCC">
				<td align="center">
					<a href="${pageContext.request.contextPath}/dividePage?currentPage=1&pageSize=5">显示所有朋友</a>
				</td>
			</tr>
			<tr bgcolor="#CCFF99">
				<td align="center">
					<a href="${pageContext.request.contextPath}/findAllFriendType?forward=friend">添加朋友</a>
				</td>
			</tr>
			<tr bgcolor="#FFFFCC">
				<td align="center">
					<a href="${pageContext.request.contextPath}/findAllFriendType?forward=friendType">显示所有朋友类别</a>
				</td>
			</tr>
			<tr bgcolor="#CCFF99">
				<td align="center">
					<a href="${pageContext.request.contextPath}/friendType/addFriendType.jsp">添加朋友类别</a>
				</td>
			</tr>
		</table>
	</body>
</html>