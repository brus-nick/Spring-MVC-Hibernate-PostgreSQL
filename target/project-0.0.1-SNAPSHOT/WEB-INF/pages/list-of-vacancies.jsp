<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <title>List of vacancies</title>
</head>
<body>
<h1>List of vacancies</h1>
<p>Here you can view the list of vacancies, edit them, remove them.</p>
<table class="table" border="1px" cellpadding="0" cellspacing="0">
    <thead class="thead-dark">
    <tr>
        <th width="15%">Id</th>
        <th width="15%">Name</th>
        <th width="15%">Status</th>
        <th width="15%">Type</th>
        <th width="10%">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vacancie" items="${vacancies}">
        <tr>
            <td>${vacancie.id}</td>
            <td>${vacancie.name}</td>
            <td>${vacancie.status}</td>
            <td>${vacancie.type}</td>
            <td>
                <a href="${pageContext.request.contextPath}/vacancy/edit/${vacancie.id}.html">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/vacancy/delete/${vacancie.id}.html">Delete</a><br/>
                <a href="${pageContext.request.contextPath}/record/submitForApproval/${"vacancy"}/${vacancie.id}.html")>Submit for approval</a><br/>
                <a href="${pageContext.request.contextPath}/record/approve/${"vacancy"}/${vacancie.id}.html">Approve</a><br/>
                <a href="${pageContext.request.contextPath}/record/reject/${"vacancy"}/${vacancie.id}.html">Reject</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a class="btn btn-primary" href="${pageContext.request.contextPath}/index.html">Come back</a></p>

</body>
</html>