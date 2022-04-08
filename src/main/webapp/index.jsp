<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>JSP - Hello World</title>
</head>
<body>
<div class="container w-auto">

    <form class="row border w-50 needs-validation shadow-lg p-3 mb-5 bg-body rounded" novalidate style="margin:20% auto" action="<%=request.getContextPath()%>/ServletLogin" method="post">
        <h1 class="text-center">Login</h1>
        <h6 class="text-center text-danger">${msg}</h6>
        <input type="hidden" value="<%= request.getParameter("url") %>" name="url">
        <div class="mb-3 row ">
            <label class="col-sm-2 col-form-label">Login</label>
            <div class="col-sm-10">
                <input name="login" type="text" class="form-control" required="required">
                <div class="invalid-feedback">
                    please inform the login
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" required="required">
                <div class="invalid-feedback">
                    please inform the password
                </div>
            </div>
        </div>
            <input class=" btn btn-primary mb-3" type="submit">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<script type="text/javascript">
    //Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()

</script>

</body>
</html>