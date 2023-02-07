<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.renish.bean.User"%>
<%@page import="com.renish.dao.UserDao"%>
<%@page import="com.renish.web.SaveLogistic"%>
<%@page import="com.renish.web.deletLogistic"%>
<%@page import="com.renish.web.updateLogistic"%>
<%@page import="com.renish.dao.UserDao,com.renish.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>


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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">





 var deleteData;
function confirmLogistic(deleteID){
	// deleteData = deleteID;
	console.log("ID =>" + deleteID);
	$("#deleteModel").modal("toggle");
	
	myDeleteId = document.getElementById("item_hidden_id");
	myDeleteId.setAttribute('custome-id', deleteID);
}

/*  function deleteModel() {
	
	var del = myDeleteId.getAttribute('custome-id');
	
	console.log("Hello =>" + del);
	window.location.href="deletLogistic?id="+del+"";
}
*/


function deleteModel(userid){
	    return $.ajax({
    	url: "deletLogistic",
        type: 'GET',
        cache: false,
        dataType: 'json',
        success: function(data){
        	return data; 
			console.log("whats in the data ======>"+data)
        }
    } );
}


/*  function deleteModel() {
	  const xhttp = new XMLHttpRequest();
	  xhttp.onload = function() {
	    document.getElementById("item_hidden_id").innerHTML =
	    this.responseText;
	  }
	  xhttp.open("GET", "deletLogistic");
	  xhttp.send();
	}
*/















<!-- update Model -->
var updateData;
function confirmupdate(Update){
	console.log("ID =>" + updateData);
	$("#updateModel").modal("toggle");
	
	myUpdateid = document.getElementById("item_hidden_id");
	myUpdateid.setAttribute('custom-item-id', Update);
}

<!--model -->
function UpdateModel() {
	
	var Upa = myUpdateid.getAttribute('custom-item-id');
	
	console.log("Hello =>" + Upa);
	window.location.href="updateLogistic?id="+Upa+"";

}


  $(document).ready(function () {
	$("#tableData").on('click', "#updatebutton", function() {
		console.log("Renish");
		let editdata = $(this).closest('tr');
		console.log(editdata);
		$('#item_hidden_id').val(editdata.find('td:eq(0)').text());
		$('#itemNo').val(editdata.find('td:eq(1)').text());
		$('#itemName').val(editdata.find('td:eq(2)').text());
		$('#item_date').val(editdata.find('td:eq(3)').text());
		$('#item_category').val(editdata.find('td:eq(4)').text());
	    
	});
});
<%--   <%
	String id = request.getParameter("id");
	User user = UserDao.getLogisticRecord(Integer.parseInt(id));
	%> --%>


</script>


</head>
<body>
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
					<th hidden>Item ID</th>
					<th>Item No.</th>
					<th>Item Name</th>
					<th>Date</th>
					<th>category</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>





				<m:forEach var="user" items="${listUser }">

					<tr>
						<td hidden><m:out value="${user.id }"></m:out></td>
						<td class="itemname"><m:out value="${user.itemNo }"></m:out></td>
						<td class="itemname"><m:out value="${user.itemName }"></m:out></td>
						<td class="Date"><m:out value="${user.date}"></m:out></td>
						<td class="category"><m:out value="${user.category }"></m:out></td>

						<td>
							<button class="btn btn-link mt-2 shadow-none text-primary"
								onclick="confirmupdate('${user.id }')" id="updatebutton">
								<i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i>
							</button>

							<button class="btn btn-link mt-2 shadow-none text-danger delete"
								onclick="confirmLogistic('${user.id }')" id="et">
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
					<h4 class="modal-title fw-bolder" id="exampleModalLabel">Logistic
						Management</h4>
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
						id="deleteLogisticButton" data-bs-dismiss="modal"
						onclick="deleteModel()">Delete</button>

				</div>

			</div>
		</div>
	</div>




	<!-- Scrollable modal -->



	<div class="modal fade" id="updateModel" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">


				<div class="modal-header">
					<h4 class="modal-title fw-bolder" id="exampleModalLabel">Logistic
						Management</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<form class="container  col-lg-10" action="updateLogistic" method="Post">
						<div>
							<input type="hidden" name="id" id="item_hidden_id" /> 
							<div>
							<span>Item no:</span>
								<input type="text" id="itemNo" name="itemNo"
									placeholder="enter ID">
							</div>
							<span id="error" style="margin-left: 867px"></span>
						</div>
						<div>
						
							<div>
								<span>Itemn names:</span>
								<input type="text" id="itemName" name="itemName"
									placeholder="enter item name" />
							</div>
						</div>
						<div>
							<div>
								<span>Date:</span>
								<input type="date" id="item_date" name="date" id="date">

								<!-- </label> -->
							</div>
							<span id="dError"></span>
						</div>
						<div>
						<div>
							<span for="select" id="a3">Category:</span>
								<select type="option" id="item_category" name="category">
									<option></option>
									<option value="electronis">electronics</option>
									<option value="paper">paper</option>
									<option value="cheque">cheque</option>
								</select>

							</div>
						</div>


						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">cancel</button>

							<button type="submit" class="btn btn-danger"
								id="updateLogisticdata" data-bs-dismiss="modal">Update</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>


</body>
</html>