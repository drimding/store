<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
<header class="row col-md-12">
    <div class="col-md-12">
        <h3 class="text-center text-muted">
            TechShop
        </h3>
        <h4 class="text-center text-muted">build your dreams here</h4>
        <div class="row">
            <div class="col-md-9">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="<c:url value="/"/>">Home</a>
                    </li>
               </ul>
            </div>
            <div class="col-md-3">
                <ul class="nav nav-pills navbar-right">
                    <li >
                        <a class="btn btn-success" href="<c:url value="/checkout"/>"><i class="glyphicon glyphicon-shopping-cart"> &nbsp</i><span class="badge pull-right">${countItem}</span></a>

                    </li>
                               <li class="dropdown">
                                    <a href="#" class="dropdown-toggle glyphicon glyphicon-user" data-toggle="dropdown"><b> <sec:authentication property="name"/></b> <span class="caret"></span></a>
                                   <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                                    <ul id="login-dp" class="dropdown-menu">
                                        <li>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    Login via
                                                    <form class="form" role="form" method="post" action="<c:url value="/login"/>" accept-charset="UTF-8" id="login-nav">
                                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                        <div class="form-group">
                                                            <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                            <input type="email" class="form-control"  name="username" id="exampleInputEmail2" placeholder="Email address" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                            <input type="password" name="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                                            <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                                                            <div class="help-block text-right"><a href="<c:url value="/registerPage"/>">Register now</a></div>
                                                        </div>
                                                        <div class="form-group">
                                                            <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                                        </div>
                                                     </form>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                   </sec:authorize>
                                   <sec:authorize access="isAuthenticated()">
                                       <ul id="login-dp" class="dropdown-menu">
                                           <li>
                                               <div class="row">
                                                   <div class="col-md-6">
                                                       <a class="btn btn-success" href="<c:url value="/orders"/>"><span>My Orders</span></a>
                                                   </div>
                                                   <div class="col-md-6">
                                                           <form action="logout" method="post" class="logout ">
                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                <input type="submit" value="LogOut" class="btn btn-warning"> <input type="hidden">
                                                            </form>
                                                   </div>
                                              </div>
                                           </li>
                                       </ul>
                                   </sec:authorize>
                                </li>

                </ul>
            </div>
        </div>
    </div>
    <ul class="nav navbar-nav navbar-right">
        <li></li>


    </ul>
</header>
</body>
