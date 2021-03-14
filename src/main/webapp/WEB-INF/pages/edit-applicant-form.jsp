<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>The page for editing applicants</title>
</head>
<body>
<h1>The page for editing applicants</h1>
<p>Here you can edit the existing applicant.</p>
<p>${message}</p>
<form:form method="POST" action="${pageContext.request.contextPath}/applicant/edit/${applicant.id}.html"
           modelAttribute="applicant">
    <table>
        <tbody>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit"/></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Come back</a></p>
</body>
</html>