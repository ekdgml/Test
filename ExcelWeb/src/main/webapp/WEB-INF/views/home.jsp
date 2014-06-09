<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%  response.setHeader("Content-Disposition", "attachment;filename=DownloadFile.xls"); %>
	<title>Home</title>
</head>
<body>
<table>
	<tr>
		<td>이름</td>
		<td>전화번호</td>
		<td>주소</td>
	</tr>
	
	<tr>
		<td>홍길동</td>
		<td>010-1111-1111</td>
		<td>서울 강남구</td>
	</tr>
	
	<tr>
		<td>박상희</td>
		<td>010-2941-1630</td>
		<td>경기도 안양시</td>
	</tr>
</table>
</body>
</html>
