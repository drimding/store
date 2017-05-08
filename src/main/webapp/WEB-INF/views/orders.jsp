<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: dreamcatcher
  Date: 17/09/16
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table class="table-bordered col-md-12">
        <c:forEach items="${orders}" var="orders">
            <c:set var="cleanedDateTime" value="${fn:replace(orders.orders.dateTime, 'T', ' ')}" />
            <fmt:parseDate value="${ cleanedDateTime }" pattern="yyyy-MM-dd HH:mm:ss" var="parsedDateTime" type="both" />
            <tr>
                <td class="col-md-1">${orders.orders.id}</td>
                <td class="col-md-2">${orders.orders.customUser.email}</td>
                <td class="col-md-2"> <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${ parsedDateTime }" /></td>
                <td class="col-md-4">${orders.product.nomenclature}</td>
                <td class="col-md-1">${orders.quantity}</td>
                <td class="col-md-2">${orders.priceUSD}</td>
           </tr>
        </c:forEach>
    </table>

</body>
</html>
