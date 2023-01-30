<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.renish.bean.User,com.renish.dao.userdao,java.util.*"%>
	<%
	String id = request.getParameter("id");
	User u = userdao.getRecordById(Integer.parseInt(id));
	%>
	<h1>EDIT FORM</h1>
	<form action="edituser.jsp" method="post">
		<input type="hidden" name="id" value="<%=u.getId()%>" />
		<table>
			<tr>
				<td>NAME:</td>
				<td><input type="text" name="name" value="<%=u.getName() %>"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"  value="<%=u.getPassword()%>"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=u.getEmail() %>"/></td>
			</tr>
			<tr>
				<td>Sex</td>
				<td><input type="radio" value="male" name="sex" value="male"/>MALE <input
					type="radio" name="sex" value="female"  value="female"/>FEMALE</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" style="width: 155px">
						<option>INDIA</option>
						<option>USA</option>
						<option>CANADA</option>
						<option>UAE</option>
						<option>ARAB</option>
						<option>YEMEN</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit User" /></td>
			</tr>
		</table>



	</form>
</body>
</html>