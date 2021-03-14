<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Exchange applicants and vacancies administration application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <style>
        .btn-primary:hover {
            color: #000000;
            background-color: #fff;
            border-color: #000000;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <h1>Exchange applicants and vacancies administration application.</h1>
</div>

<div style="text-align: center"><h5>${message}</h5></div>
<br/>
<p style="text-align:center">
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/vacancy/add.html">Add new vacancy</a><br/>
    <br/><a class="btn btn-primary" href="${pageContext.request.contextPath}/vacancy/list.html">List of vacancies</a><br/>
    <br/><a class="btn btn-primary" href="${pageContext.request.contextPath}/applicant/add.html">Add new applicant</a><br/>
    <br/><a class="btn btn-primary" href="${pageContext.request.contextPath}/applicant/list.html">List of applicants</a><br/>
</p>
</body>
</html>