<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NamooEvent</title>
<link rel="shortcut icon" href="${ctx}/resources/img/namoo.ico">
<script type="text/javascript" src="${ctx}/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/show.js"></script>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<style type="text/css">
body {
	font-family: NanumGothic, 나 눔 고 딕, "Malgun Gothic", "맑은 고딕", sans-serif;
}

table {
	border-collapse: collapse;
	margin-left: 1px;
	border-right: 1px solid #222;
	border-bottom: 1px solid #222;
}

td,th {
	padding: 0;
	border-top: 1px solid #222;
	border-left: 1px solid #222;
	padding: 5px;
}

.small-image {
	width: 100px;
	height: 100px;
	background: aqua;
}

.large-image {
	width: 750px;
	height: 250px;
	background: gray;
	display: inline-block;
}

.mt20 {
	margin-top: 20px;
}

input,button,select,textarea {
	font-family: inherit;
	font-size: inherit;
	line-height: inherit;
}

a {
	color: #428bca;
	text-decoration: none;
}

a:hover,a:focus {
	color: #2a6496;
	text-decoration: underline;
}

a:focus {
	outline: thin dotted #333;
	outline: 5px auto -webkit-focus-ring-color;
	outline-offset: -2px;
}

img {
	vertical-align: middle;
}

.img-responsive {
	display: block;
	height: auto;
	max-width: 100%;
}

.img-rounded {
	border-radius: 6px;
}

.img-thumbnail {
	display: inline-block;
	height: auto;
	max-width: 100%;
	padding: 4px;
	line-height: 1.428571429;
	background-color: #ffffff;
	border: 1px solid #dddddd;
	border-radius: 4px;
	-webkit-transition: all 0.2s ease-in-out;
	transition: all 0.2s ease-in-out;
}

.img-circle {
	border-radius: 50%;
}
</style>
</head>
<body>
<h1>모임 목록</h1>
<button onclick="location.href='${ctx}/registEvent'">모임 등록</button><br/><br/>

    <c:forEach var="event" items="${events}">
<div class="event-item">
	    <table border="1" style="width: 800px">
	        <tr>
	            <td rowspan="3" style="width: 105px"><img src="${ctx}/${event.id}/smallImg" class="img-responsive"></img></td>
	            <td style="width: 100px">모임명</td>
	            <td>${event.name}</td>
	        </tr>
	        <tr>
	            <td>일시</td>
	            <td>${event.openDate}</td>
	        </tr>
	        <tr>
	            <td>소개</td>
	            <td>${event.summaryDes}</td>
	        </tr>
	        <tr>
	            <td colspan="3"><button name="show_btn" data-id="${event.id}">펼치기</button>
	            <button name="hide_btn" style="display:none;">접기</button><br />
	            <button name="remove_btn" onclick="location.href='${ctx}/remove/${event.id}'" >삭제</button>
	            <div style="display:none;"></div>
	            </td>
         </tr>
     </table>
</div>
</c:forEach>
</body>
</html>