<%@page import="com.renish.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.renish.dao.userdao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.renish.dao.userdao"%>  
<jsp:useBean id="u" class="com.renish.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=userdao.update(u);  
response.sendRedirect("viewuser.jsp");  
%>   
</body>
</html>