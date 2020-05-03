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
		<title>修改朋友</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/updateFriend" name="update" id="update" method="post">
			<table width="40%" border="1" align="center" style="border-collapse: collapse">
				<caption>
					<font color="#990099">修改朋友</font>
				</caption>
				<tr bgcolor="#FFFFCC">
					<th width="32%" align="right">朋友Id:</th>
					<td width="68%" align="left">
						<input name="friendId" value="${requestScope.friend.friendId}" readonly="readonly" id="friendId">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">朋友类别:</th>
					<td align="left">
						<select name="typeId">
							<c:forEach items="${requestScope.list}" var="friendType">
								<c:if test="${requestScope.friend.typeId == friendType.typeId}" var="result">
									<option value="${friendType.typeId}" selected="selected">${friendType.typeName}</option>
								</c:if>
								<c:if test="${!result}">
									<option value="${friendType.typeId}">${friendType.typeName}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">姓名:</th>
					<td align="left">
						<input name="friendName" value="${requestScope.friend.friendName}" id="friendName">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">地址:</th>
					<td align="left">
						<input name="friendAddress" value="${requestScope.friend.friendAddress}" id="friendAddress">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">电话:</th>
					<td align="left">
						<input name="friendTel" value="${requestScope.friend.friendTel}" id="friendTel">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">简介:</th>
					<td align="left">
						<input name="context" value="${requestScope.friend.context}" id="context">
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