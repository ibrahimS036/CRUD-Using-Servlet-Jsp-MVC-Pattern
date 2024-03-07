<%@page import="java.util.List"%>
<%@page import="MvcPackage.*" %>
<%@page import="MvcPackage.DaoImpl"%>
<%@page import="MvcPackage.UserDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Showing Users</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    table {
        width: 100%;
        border-collapse: collapse;
        border: 1px solid #ddd;
    }
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<h1>All Users:</h1>
	<%
	DaoImpl dao = new DaoImpl();
	List<Bean> userList= dao.read();
	request.setAttribute("userList",userList );
	%>
<div class="container">
    <table>
        <thead>
            <tr>
                <th>User Name</th>
                <th>User phone</th>
                <th>User Email</th>
                <th>User password</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${userList}"
            >
                <tr>
                   
                   <td><c:out value="${user.name}" /></td>
                   <td><c:out value="${user.phone}" /></td>
                   <td><c:out value="${user.email}" /></td>
                   <td><c:out value="${user.password}" /></td>
                   
                   
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
