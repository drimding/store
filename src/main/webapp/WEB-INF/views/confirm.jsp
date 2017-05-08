<%--
  Created by IntelliJ IDEA.
  User: dreamcatcher
  Date: 17/09/16
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<body>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <form class="form-horizontal" action="<c:url value="/confirmOrderNewUser"/>" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="fn">First name</label>
                <div class="col-md-4">
                    <input id="fn" name="firstName" type="text" placeholder="first name" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="ln">Last name</label>
                <div class="col-md-4">
                    <input id="ln" name="lastName" type="text" placeholder="last name" class="form-control input-md" required="">

                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="email" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="add1">Address 1</label>
                <div class="col-md-4">
                    <input id="add1" name="address" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="city">City</label>
                <div class="col-md-4">
                    <input id="city" name="city" type="text" placeholder="city" class="form-control input-md" required="">

                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Phone</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="text" placeholder="Phone#" class="form-control input-md" required="">

                </div>
            </div>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="button" name="BACK" class="btn">BACK</button>
                    <button id="submit" name="submit" class="btn btn-primary">SUBMIT</button>
                </div>

            </div>

        </div>
    </form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<form class="form-horizontal" action="<c:url value="/confirmOrderOldUser"/>" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div>

        <!-- Form Name -->
        <legend>Form Name</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fn">First name</label>
            <div class="col-md-4">
                <input id="fn2" readonly="readonly" name="firstName" type="text" placeholder="${currentUser.firstName}" value="${currentUser.firstName}" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="ln">Last name</label>
            <div class="col-md-4">
                <input id="ln2" readonly="readonly" name="lastName" type="text" placeholder="${currentUser.lastName}" value="${currentUser.lastName}" class="form-control input-md" required="">

            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input id="email2" readonly="readonly" name="email" type="text" placeholder="${currentUser.email}" value="${currentUser.email}" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="add1">Address 1</label>
            <div class="col-md-4">
                <input id="add12"  readonly="readonly" name="address" type="text" placeholder="${currentUser.address}" value="${currentUser.address}" class="form-control input-md" required="">

            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="city">City</label>
            <div class="col-md-4">
                <input id="city2"  readonly="readonly" name="city" type="text" placeholder="${currentUser.city}" value="${currentUser.city}" class="form-control input-md" required="">

            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="phone">Phone</label>
            <div class="col-md-4">
                <input id="phone2" readonly="readonly" name="phone" type="text" placeholder="${currentUser.phone}" value="${currentUser.phone}" class="form-control input-md" required="">

            </div>
        </div>
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="button2" name="BACK" class="btn">BACK</button>
                <button id="submit2" name="submit" class="btn btn-primary">SUBMIT</button>
            </div>

        </div>

    </div>
</form>
</sec:authorize>

</body>
</html>
