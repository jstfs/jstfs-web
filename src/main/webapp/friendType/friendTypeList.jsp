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
		<script type="text/javascript">
			function isDelete(typeName) {
				return confirm("您确定删除["+ typeName +"]这个朋友类别吗?");
			}
		</script>

		<title>朋友类别列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<table width="70%" border="2" align="center" style="border-collapse: collapse">
			<caption>
				<font color="#990099">朋友类别列表</font>
			</caption>
			<tr align="center" bgcolor="#6633CC">				
				<th>
					<font color="white">类别ID</font>
				</th>
				<th>
					<font color="white">名称</font>
				</th>
				<th>
					<font color="white">简介</font>
				</th>				
				<th>
					<font color="white">修改</font>
				</th>
				<th>
					<font color="white">删除</font>
				</th>
			</tr>
			
			<c:forEach items="${requestScope.list}" var="friendType">
				<tr bgcolor="#FFFFCC" onMouseOver="this.bgColor='red'"	onmouseout="this.bgColor='#FFFFCC'">
					<td align="center">${friendType.typeId}</td>
					<td align="center">${friendType.typeName}</td>
					<td align="center">${friendType.context}</td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/findFriendTypeById?typeId=${friendType.typeId}">修改</a>
					</td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/deleteFriendType?typeId=${friendType.typeId}" onclick="return isDelete('${friendType.typeName}')">删除</a>
					</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="5" align="center">
					<a href="${pageContext.request.contextPath}/friendType/addFriendType.jsp">添加朋友类别</a>
					<a href="${pageContext.request.contextPath}/index.jsp">返回</a>
				</td>
			</tr>
		</table>
	</body>
</html>