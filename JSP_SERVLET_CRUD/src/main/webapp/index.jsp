<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script type="text/javascript">
var deleteData;
<!-- Open Model and transfer ID-->
function confirmDeleteGrocery(deleteID){
	// deleteData = deleteID;
	console.log("ID =>" + deleteData);
	$("#deleteModel").modal("toggle");
	
	myDeleteId = document.getElementById("hiddenId");
	myDeleteId.setAttribute('custome-id', deleteID);
}
<!-- Model Delete Button-->
function deleteModel() {
	
	var del = myDeleteId.getAttribute('custome-id');
	
	console.log("Hello =>" + del);
	window.location.href="deletLogistic?id="+del+"";
}

</script>



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
			<thead>
				<tr>
					<th>Item No.</th>
					<th>Item Name</th>
					<th>Date</th>
					<th>category</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>


				<input type="hidden" id="hiddenId">


				<m:forEach var="user" items="${listUser }">

					<tr>
						<td><m:out value="${user.itemNo }"></m:out></td>
						<td><m:out value="${user.itemName }"></m:out></td>
						<td><m:out value="${user.date}"></m:out></td>
						<td><m:out value="${user.category }"></m:out></td>

						<td><a href="edit-form.jsp?id=<m:out value='${user.id }'/>"
							class="btn btn-link mt-2 shadow-none text-primary"><i
								class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i></a>
							<button class="btn btn-link mt-2 shadow-none text-danger delete"
								onclick="confirmDeleteGrocery('${user.id }')" id="et">
								<i class="fa fa-trash-o fa-2x" aria-hidden="true"></i>
							</button>
							</td>

					</tr>
				</m:forEach>

			</tbody>
		</table>

	</div>


	<!--deleteMessage-->

	<div class="modal fade" id="deleteModel" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title fw-bolder" id="exampleModalLabel">Logistic Management</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<p class="fs-4">Are you sure to delete this data?</p>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">cancel</button>

					<button type="button" class="btn btn-danger"
						id="deleteGroceryButton" data-bs-dismiss="modal"
						onclick="deleteModel()">Delete</button>

				</div>

			</div>
		</div>
	</div>

</body>
</html>