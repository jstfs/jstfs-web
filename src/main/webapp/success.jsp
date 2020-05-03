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
		<title>操作成功</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<font color="red" size="6">${requestScope.srcPage}成功</font>,
		<c:if test="${requestScope.srcPage == '添加朋友'}">
			<a href="${pageContext.request.contextPath}/findAllFriendType?forward=friend">继续${requestScope.srcPage}</a>,或者
		</c:if>
		<c:if test="${requestScope.srcPage == '添加朋友类别'}">
			<a href="${pageContext.request.contextPath}/friendType/addFriendType.jsp">继续${requestScope.srcPage}</a>,或者
		</c:if>
		<a href="${pageContext.request.contextPath}/index.jsp">返回主页面</a>
	</body>
</html>