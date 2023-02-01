<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@page import="com.renish.bean.User"%>
	<%@page import="com.renish.dao.UserDao"%>
	<%@page import="com.renish.web.SaveLogistic"%>
	<%@page import="com.renish.web.deletLogistic"%>
	<%@page import="com.renish.web.updateLogistic"%>
	<%@page import="com.renish.dao.UserDao,com.renish.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
	
	<%
	UserDao userDao;
	List<User> listUser = UserDao.GetitemRecord();
	request.setAttribute("listUser", listUser);
	%>




	<a href="index-form.jsp"
		class="btn btn-success col-sm-1 mt-2 px-1 fs-5 mx-5 shadow bg-green"
		id="addUser">Add User</a>
	<div class="container mt-5 col-sm-10">
		<table class="table table-bordered text-center fs-5 col-sm-1"
			id="tableData">
			</thead>
			<tbody>


				<input type="hidden" id="hiddenId">


				<m:forEach var="user" items="${listUser }">

					<tr>
						<td><m:out value="${user.itemNo }"></m:out></td>
						<td><m:out value="${user.itemName }"></m:out></td>
						<td><m:out value="${user.Date }"></m:out></td>
						<td><m:out value="${user.category }"></m:out></td>
						<!--  <td><m:out value="${user.quantity }"></m:out></td>-->

						<td><a href="edit-form.jsp?id=<m:out value='${user.id }'/>"
							class="btn btn-link mt-2 shadow-none text-primary"><i
								class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i></a>
							<button class="btn btn-link mt-2 shadow-none text-danger delete"
								onclick="confirmDeleteGrocery('${user.id }')" id="et">
								<i class="fa fa-trash-o fa-2x" aria-hidden="true"></i>
							</button>
							<button class="btn btn-link mt-2 shadow-none text-primary"
								id="view" onclick="confirmViewGrocery('${user.id }')">
								<i class="fa fa-eye fa-2x" aria-hidden="true"></i>
							</button></td>

					</tr>
				</m:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>