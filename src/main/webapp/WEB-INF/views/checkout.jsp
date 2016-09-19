<%--
  Created by IntelliJ IDEA.
  User: dreamcatcher
  Date: 16/09/16
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Checkout</title>
</head>

<body>
<div class="container">
    <h2>Your Shopping Cart</h2>
    <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:50%">Product</th>
            <th style="width:10%">Price</th>
            <th style="width:8%">Quantity</th>
            <th style="width:22%" class="text-center">Subtotal</th>
            <th style="width:10%"></th>
        </tr>
        </thead>
        <c:set var="totalPrice" value="0" scope="page" />
        <c:forEach items="${busketItems}" var="busketItems">
        <tbody>

        <tr>
            <td data-th="Product">
                <div class="row">
                    <%--<div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>--%>
                    <div class="col-sm-10">
                        <h4 class="nomargin">${busketItems.product.productCategory.catName}</h4>
                        <p>${busketItems.product.nomenclature}</p>
                    </div>
                </div>
            </td>
            <td data-th="Price">$<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">${busketItems.product.priceUSD}</fmt:formatNumber></td>
            <form action="<c:url value="/updateQuantity-inBasket"/>" method="post" >
            <td data-th="Quantity">
                <input type="number" name="quantity" class="form-control text-center" value="${busketItems.quantity}">
            </td>
            <td data-th="Subtotal" class="text-center">$<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">${busketItems.product.priceUSD*busketItems.quantity}</fmt:formatNumber></td>
            <td class="actions" data-th="">

                    <input type="hidden" name="basketItemId" value="${busketItems.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
                </form>
                <form action="<c:url value="/delItem-inBasket"/>" method="post" class="col-md-6">
                    <input type="hidden" name="basketItemId" value="${busketItems.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
                </form>
            </td>
        </tr>
        </tbody>
            <c:set var="totalPrice" value="${totalPrice+busketItems.product.priceUSD*busketItems.quantity}" scope="page" />
        </c:forEach>
        <tfoot>
<%--        <tr class="visible-xs">
            <td class="text-center"><strong>Total 1.99</strong></td>
        </tr>--%>
        <tr>
            <td><a href="<c:url value="/"/>" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
            <td colspan="2" class="hidden-xs"></td>
            <td class="hidden-xs text-center"><strong>Total $<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">${totalPrice}</fmt:formatNumber></strong></td>
            <c:if test="${not empty  busketItems}">
            <td><a href="<c:url value="/confirm"/> " class="btn btn-success btn-block">Confirm <i class="fa fa-angle-right"></i></a></td>
            </c:if>
        </tr>
        </tfoot>

    </table>
</div>

</body>
</html>
