<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam Index</title>
<script type="text/javascript" src="${ctx}/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/exam.js"></script>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
</head>
<body>

<h1>사용자 목록</h1>

<table border="1">
	<c:forEach var="user" items="${users}">
	<tr>
		<td>${user.name}</td>
		<td><button name="show_btn" data-name="${user.name}">펼치기</button><button name="hide_btn" style="display:none">접기</button></td>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>