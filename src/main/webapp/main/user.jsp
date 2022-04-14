
<%--
  Created by IntelliJ IDEA.
  User: william
  Date: 06/04/2022
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/partial/head.jsp"></jsp:include>

<body>

<jsp:include page="/partial/theme-loader.jsp"></jsp:include>

<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">

        <jsp:include page="/partial/navbar.jsp"></jsp:include>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">

                <jsp:include page="/partial/sidebar.jsp"></jsp:include>

                <div class="pcoded-content">

                    <div class="page-header">
                        <div class="page-block">
                            <div class="row align-items-center">
                                <div class="col-md-8">
                                    <div class="page-header-title">
                                        <h5 class="m-b-10">User registration</h5>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <ul class="breadcrumb-title">
                                        <li class="breadcrumb-item">
                                            <a href="main/main.jsp"> <i class="fa fa-home"></i> </a>
                                        </li>
                                        <li class="breadcrumb-item"><a
                                                href="<%=request.getContextPath()%>/main/main.jsp">Dashboard</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="pcoded-inner-content">
                        <!-- Main-body start -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-body start -->
                                <div class="page-body">

                                    <div class="card">
                                        <div class="card-header">
                                            <h3>User Registration Form</h3>
                                        </div>
                                        <div class="card-block">
                                            <form class="form-material"
                                                  action="<%= request.getContextPath()%>/ServletUserController"
                                                  method="post">
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">ID:</label>
                                                    <div class="col-sm-1">
                                                        <input name="id" id="id" type="text" class="form-control form-"
                                                               value="${model.id}"
                                                               disabled>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Name:</label>
                                                    <div class="col-sm-10">
                                                        <input name="name" id="name" type="text" class="form-control"
                                                               placeholder="User name" required="required"
                                                               value="${model.name}"
                                                        >
                                                        <div class="invalid-feedback">
                                                            please inform the user name
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Email:</label>
                                                    <div class="col-sm-10">
                                                        <input name="email" id="email" type="email" class="form-control"
                                                               placeholder="Email" required="required"
                                                               value="${model.email}"
                                                        >
                                                        <div class="invalid-feedback">
                                                            please inform the user email
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Login:</label>
                                                    <div class="col-sm-10">
                                                        <input name="login" id="login" type="text" class="form-control"
                                                               placeholder="Login" required="required"
                                                               value="${model.login}"
                                                        >
                                                        <div class="invalid-feedback">
                                                            please inform the user login
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Password:</label>
                                                    <div class="col-sm-10">
                                                        <input name="password" id="password" type="password"
                                                               class="form-control" placeholder="Password"
                                                               required="required"
                                                               value="${model.password}"
                                                        >
                                                        <div class="invalid-feedback">
                                                            please inform the user password
                                                        </div>
                                                    </div>
                                                </div>

                                                <button class="col-sm-2 btn btn-primary waves-effect waves-light">Clean
                                                </button>
                                                <button class="col-sm-2 btn btn-success waves-effect waves-light">Save
                                                </button>
                                                <button class="col-sm-2 btn btn-danger waves-effect waves-light">
                                                    delete
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Page-body end -->
                        </div>
                        <div id="styleSelector"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/partial/javascript-file.jsp"></jsp:include>

</body>

</html>
