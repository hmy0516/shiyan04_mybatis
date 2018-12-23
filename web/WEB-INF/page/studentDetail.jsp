<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生详细信息页面</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/StudentServlet" method="post">
		<table border="2">
			<tr>
				<td>学号</td>
				<td>${students.get(0).getSnum()}</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>${students.get(0).getName()}</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>${students.get(0).getAge()}</td>
			</tr>
			<tr>
				<td>个人介绍</td>
				<td>
					${students.get(0).getIntro()}
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="关闭"/>&nbsp;
				</td>
			</tr>
		</table>
	</form>

</body>
</html>