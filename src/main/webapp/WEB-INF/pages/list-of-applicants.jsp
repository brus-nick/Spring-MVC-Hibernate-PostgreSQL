<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <title>List of applicants</title>
</head>
<body>
<h1>List of applicants</h1>
<p>Here you can view the list of applicants, edit them, remove them.</p>
<table class="table" border="1px" cellpadding="0" cellspacing="0">
    <thead class="thead-dark">
    <tr>
        <th width="15%">Id</th>
        <th width="15%">First Name</th>
        <th width="15%">Last Name</th>
        <th width="15%">Email</th>
        <th width="15%">Phone</th>
        <th width="10%">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="applicant" items="${applicants}">
        <tr>
            <td>${applicant.id}</td>
            <td>${applicant.firstName}</td>
            <td>${applicant.lastName}</td>
            <td>${applicant.email}</td>
            <td>${applicant.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/applicant/edit/${applicant.id}.html">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/applicant/delete/${applicant.id}.html">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/index.html">Come back</a></p>

</body>
</html>