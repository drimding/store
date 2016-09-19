<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta id="csrf" content="${_csrf.token}"/>
    <meta id="csrf_header" content="${_csrf.headerName}"/>

    <title><tiles:getAsString name="title"></tiles:getAsString></title>

        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<%--
    <link rel="stylesheet" href="<jstl:url value="/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/sticky-footer.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/bootstrap-theme.min.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/bootstrap-datetimepicker.css"/>"/>

    <script src="<jstl:url value="resources/js/jquery-2.1.4.js"/> "></script>
    <script src="<jstl:url value="resources/js/bootstrap.min.js"/> "></script>
    <script src="<jstl:url value="resources/js/moments.js"/> "></script>
    <script src="<jstl:url value="resources/js/bootstrap-datetimepicker.min.js"/> "></script>--%>




</head>
<body>

<div class="container-fluid">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>

    <tiles:insertAttribute name="body"></tiles:insertAttribute>

    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>

</html>