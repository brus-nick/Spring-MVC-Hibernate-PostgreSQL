<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>The page for editing vacancies</title>
</head>
<body>
<h1>The page for editing vacancies</h1>
<p>Here you can edit the existing vacancy.</p>
<p>${message}</p>
<form:form method="POST" action="${pageContext.request.contextPath}/vacancy/edit/${vacancie.id}.html"
           modelAttribute="vacancie">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td><form:input path="status"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><form:input path="type"/></td>
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