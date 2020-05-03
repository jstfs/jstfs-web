<%@ page 
	language="java"
	import="java.util.*,com.jstfs.web.friends.dto.*, com.jstfs.web.friends.dao.*"
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
			function isDelete(friendName) {
				return confirm("您确定删除[" + friendName + "]这个朋友吗?");
			}
			
			function changeNowPage(toPage,pageSize) {
				document.location.href = "${pageContext.request.contextPath}/dividePage?currentPage=" + toPage+ "&pageSize=" + pageSize;
			}
			
			function changePageSize(pageSize) {
				document.location.href = "${pageContext.request.contextPath}/dividePage?currentPage=1&pageSize=" + pageSize;
			}
		</script>

		<title>朋友列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	
	<body>		
		<table width="70%" border="2" align="center" style="border-collapse: collapse">
			<caption>
				<font color="#990099">朋友列表</font>
			</caption>
			<tr align="center" bgcolor="#6633CC">
				<th>
					<font color="white">朋友ID</font>
				</th>
				<th>
					<font color="white">朋友类型</font>
				</th>
				<th>
					<font color="white">姓名</font>
				</th>
				<th>
					<font color="white">地址</font>
				</th>
				<th>
					<font color="white">电话</font>
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
			<c:forEach items="${requestScope.friends}" var="friend">
				<tr bgcolor="#FFFFCC" onMouseOver="this.bgColor='red'" onmouseout="this.bgColor='#FFFFCC'">
					<td align="center">${friend.friendId}</td>
					<td align="center">${friend.typeName}</td>
					<td align="center">${friend.friendName}</td>
					<td align="center">${friend.friendAddress}</td>
					<td align="center">${friend.friendTel}</td>
					<td align="center">${friend.context}</td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/findFriendById?friendId=${friend.friendId}">修改</a>
					</td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/deleteFriend?friendId=${friend.friendId}" onclick="return isDelete('${friend.friendName}')">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>			
				<td colspan="8" align="center">
					<a href="${pageContext.request.contextPath}/findAllFriendType?forward=friend">添加朋友</a>
					<a href="${pageContext.request.contextPath}/index.jsp">返回</a>
				</td>
			</tr>
			<tr>
				<td colspan="8" align="left">
					&nbsp;
					<c:if test="${requestScope.currentPage == 1}" var="result">
						 首页&nbsp;上一页&nbsp;
					</c:if>
					<c:if test="${!result}">					
						<a href="${pageContext.request.contextPath}/dividePage?currentPage=1&pageSize=${requestScope.pageSize}">首页</a>&nbsp;
						<a href="${pageContext.request.contextPath}/dividePage?currentPage=${requestScope.currentPage -1}&pageSize=${requestScope.pageSize}">上一页</a>&nbsp;
					</c:if>
					<c:if test="${requestScope.currentPage == requestScope.pageCount}" var="result">						
						下一页&nbsp;末页&nbsp;
					</c:if>
					<c:if test="${!result}">										
						<a href="${pageContext.request.contextPath}/dividePage?currentPage=${requestScope.currentPage + 1}&pageSize=${requestScope.pageSize}">下一页</a>&nbsp;
						<a href="${pageContext.request.contextPath}/dividePage?currentPage=${requestScope.pageCount}&pageSize=${requestScope.pageSize}">末页</a>&nbsp;
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="8" align="right" style="color:#9900FF">
					共${requestScope.count}条记录,共${requestScope.pageCount}页,当前第${requestScope.currentPage}页,每页显示
					<select onchange="changePageSize(this.value)">
						<option value="${requestScope.count}" selected="selected">全部</option>
						<c:forEach begin="1" end="10" varStatus="status">
							<c:if test="${requestScope.pageSize == status.count}" var="result">
								<option value="${status.count}" selected="selected">${status.count}</option>
							</c:if>
							<c:if test="${!result}">
								<option value="${status.count}">${status.count}</option>
							</c:if>
						</c:forEach>												
					</select>
					条 转到第			
					<select onchange="changeNowPage(this.value,${requestScope.pageSize})">
						<c:forEach begin="1" end="${requestScope.pageCount}" varStatus="status">
							<c:if test="${status.count == (requestScope.currentPage)}" var="result">							
								<option value="${status.count}" selected="selected">${status.count}</option>
							</c:if>
							<c:if test="${!result}">
								<option value="${status.count}">${status.count}</option>
							</c:if>
						</c:forEach>
					</select>
					页
				</td>
			</tr>
		</table>				
	</body>
</html>