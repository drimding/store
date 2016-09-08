<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta id="csrf" content="${_csrf.token}"/>
    <meta id="csrf_header" content="${_csrf.headerName}"/>

    <title><tiles:getAsString name="title"></tiles:getAsString></title>
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


<tiles:insertAttribute name="header"></tiles:insertAttribute>

<tiles:insertAttribute name="body"></tiles:insertAttribute>

<tiles:insertAttribute name="footer"></tiles:insertAttribute>



</body>
</html>