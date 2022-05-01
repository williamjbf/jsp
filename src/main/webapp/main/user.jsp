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
                                            <h4>${msg}</h4>
                                        </div>
                                        <div class="card-block">
                                            <form id="formUser" class="form-material"
                                                  action="<%= request.getContextPath()%>/ServletUserController"
                                                  method="post">
                                                <input type="hidden" name="action" id="action" value="">
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">ID:</label>
                                                    <div class="col-sm-1">
                                                        <input name="id" id="id" type="text" class="form-control form-"
                                                               value="${model.id}"
                                                               readonly>
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

                                                <button type="button"
                                                        class="col-sm-2 btn btn-primary waves-effect waves-light"
                                                        onclick="clearForm()">Clean
                                                </button>
                                                <button type="submit"
                                                        class="col-sm-2 btn btn-success waves-effect waves-light">Save
                                                </button>
                                                <button type="button"
                                                        class="col-sm-2 btn btn-danger waves-effect waves-light"
                                                        onclick="deleteUser()">
                                                    delete
                                                </button>
                                                <button type="button" class="col-sm-2 btn btn-secondary"
                                                        data-toggle="modal" data-target="#modalUser">Search
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

<!-- Modal -->
<div class="modal fade" id="modalUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">user search</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Name" aria-label="name" id="searchName"
                           aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-success" type="button" onclick="searchUsers();">Search</button>
                    </div>
                </div>

                <div style="height: 300px;overflow: scroll;">
                    <table class="table" id="resultsTable">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">View</th>
                            <th scope="col">Delete</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <span id="totalResults"></span>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>

    function editUser(id) {


        window.location.href = '/ServletUserController?action=edit&id=' + id;

    }

    function searchUsers() {
        const searchName = document.getElementById('searchName').value;

        if (searchName != null && searchName !== '' && searchName.trim() !== '') {

            $.ajax({
                method: "get",
                url: "/ServletUserController",
                data: "searchName=" + searchName + '&action=search',
                success: function (response) {
                    let json = JSON.parse(response)

                    $('#resultsTable > tbody > tr').remove();

                    for (let position = 0; position < json.length; position++) {
                        $('#resultsTable > tbody').append(
                            '<tr> ' +
                            '<td>' + json[position].id + '</td> +' +
                            '<td>' + json[position].name + '</td>+' +
                            '<td> <button class="btn btn-info" type="button" onclick="editUser(' + json[position].id + ')">View</button></td>' +
                            '<td> <button class="btn btn-warning" type="button" onclick="">Delete</button> </td>' +
                            '</tr>')
                    }
                    document.getElementById('totalResults').textContent = ('Results:' + json.length);
                }

            }).fail(function (xhr, status, errorThrown) {
                alert('Error fetching user: ' + xhr.responseText);
            });
        }
    }

    function clearForm() {
        let elements = document.getElementById("formUser").elements;

        for (let field = 0; field < elements.length; field++) {
            elements[field].value = "";
        }
    }

    function deleteUser() {

        if (confirm('do you really want to delete this user?')) {
            const idUser = document.getElementById('id').value;

            $.ajax({
                method: "get",
                url: "/ServletUserController",
                data: "id=" + idUser + '&action=delete',
                success: function (response) {
                    clearForm();
                    document.getElementById('msg').textContent = response;
                }

            }).fail(function (xhr, status, errorThrown) {
                alert('Error deleting user: ' + xhr.responseText);
            });
        }

    }

</script>

</body>

</html>
