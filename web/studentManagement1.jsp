<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>

</head>
<body>
	<a href="${ pageContext.request.contextPath }/StudentAddServlet?type=addPage">添加</a>&nbsp;&nbsp;
    <input name="search" id="searchname"/><button>查询</button>
		<table border="2" width="500px">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
            <c:forEach items="${stulist1}" var="s">
                <tr>
                    <td>${s.getSnum()}</td>
                    <td>${s.getName()}</td>
                    <td>${s.getAge()}</td>
                    <td>
                        <a href="${ pageContext.request.contextPath }/StudentDetailServlet?id=${s.getId()}">详细</a>&nbsp;
                        <a href="${ pageContext.request.contextPath }/StudentEditServlet?id=${s.getId()}">编辑</a>&nbsp;
                        <a href="#" onclick="btnDelete('${s.getId()}')">删除</a>
                    </td>
                </tr>
            </c:forEach>
		</table>

    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $("button").on("click",function(){
            $.ajax({
                url:'${ pageContext.request.contextPath }/SearchServlet',
                type:'post',
                dataType:'text',
                data:{
                    name:$('#searchname').val()
                },
                success:function () {
                    request.removeAttribute("stulist1")
                }
            });
        });
        function btnDelete(id){
            if(confirm("确认删除该条记录吗?"))
                location.href="${ pageContext.request.contextPath }/StudentDelServlet?id="+id;
        }
    </script>
</body>
</html>