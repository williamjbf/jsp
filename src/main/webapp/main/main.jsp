<%--
  Created by IntelliJ IDEA.
  User: william
  Date: 03/04/2022
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../partial/head.jsp"></jsp:include>

<body>

<jsp:include page="../partial/theme-loader.jsp"></jsp:include>

<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">

        <jsp:include page="../partial/navbar.jsp"></jsp:include>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">

                <jsp:include page="../partial/sidebar.jsp"></jsp:include>

                <div class="pcoded-content">

                    <jsp:include page="../partial/page-header.jsp"></jsp:include>

                    <div class="pcoded-inner-content">
                        <!-- Main-body start -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-body start -->
                                <div class="page-body">
                                    <div class="row">


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
</div>

<jsp:include page="../partial/javascript-file.jsp"></jsp:include>

</body>

</html>

