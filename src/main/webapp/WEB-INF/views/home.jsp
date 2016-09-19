<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Checkout</title>
</head>

<body>
<div class="row">
    <div class="dual-list list-left col-md-3">
        <div class="well text-left">
            <div class="row">
                <div class="col-md-12">
                    <div class="input-group">
                        <span class="input-group-addon glyphicon glyphicon-search"></span>
                        <input type="text" name="SearchDualList" class="form-control" placeholder="search" />
                    </div>
                </div>
            </div>
            <ul class="list-group">
                <c:forEach items="${ProductCategoru}" var="ProductCategoru">
                    <li class="list-group-item"><a href="<c:url value="/getItemsContent?id=${ProductCategoru.id}"/>">${ProductCategoru.catName}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="col-md-9">
        <div class="row">
        <c:set var="count" value="0" scope="page" />
        <c:forEach items="${Products}" var="Products">

            <div class="col-sm-3">
                <%--<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-rounded">--%>
               <div class="product-block">
                <h3>
                    ${Products.productCategory.catName}
                </h3>
                <p>
                ${Products.nomenclature}
                </p>
<%--                <p>
                    <a class="btn" href="#">View details »</a>
                </p>--%>
                <div class="row">
                    <div class="col-md-8" style="color:green; font-size: small">
                        Price: $${Products.priceUSD}
                    </div>
                    <div class="col-md-4">
                        <form action="<c:url value="/add-basketElement"/>" method="post">
                            <input type="hidden" name="productId" value="${Products.id}">
                            <input type="hidden" name="productCategoryId" value="">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit" name="add"  value="add" class="btn btn-success">
                        </form>
                    </div>
                </div>
                </div>

            </div>
            <c:set var="count" value="${count + 1}" scope="page"/>
                <c:if test="${count%4==0 && count>1}">
                    </div>
        <div class="row">
                </c:if>
      </c:forEach>
        </div>

    </div>
</div>
</body>
</html>
