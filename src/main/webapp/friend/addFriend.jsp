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
		<title>添加朋友</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/addFriend" method="post" name="addFriend" id="addFriend">
			<table width="40%" border="1" align="center" style="border-collapse: collapse">
				<caption>
					<font color="#990099">添加朋友</font>
				</caption>
				<tr bgcolor="#FFFFCC">
					<th width="33%" align="right">朋友类别:</th>
					<td width="67%" align="left">
						<select name="typeId">
							<option value="0">请选择...</option>
							<c:forEach items="${requestScope.list}" var="friendType">
								<option value="${friendType.typeId}">${friendType.typeName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">姓名:</th>
					<td align="left">
						<input name="friendName" value="">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">地址:</th>
					<td align="left">
						<input name="friendAddress" value="">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">电话:</th>
					<td align="left">
						<input name="friendTel" value="">
					</td>
				</tr>
				<tr bgcolor="#FFFFCC">
					<th align="right">简介:</th>
					<td align="left">
						<input name="context" value="">
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" name="Submit" value="添加">
						<input type="reset" name="Submit2" value="重置">
						<a href="${pageContext.request.contextPath}/index.jsp">取消</a>
					</th>
				</tr>
			</table>
		</form>
	</body>
</html>