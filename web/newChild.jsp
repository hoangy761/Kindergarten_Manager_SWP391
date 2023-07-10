<%-- 
    Document   : profileParent
    Created on : May 26, 2023, 5:15:06 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp" %>

<head>
    <title>My Profile</title>
    <link href="css/styleMyProfileParent.css" rel="stylesheet">

</head>
<div class="container">
    <div class="main-body">
        <div class="row">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin"
                                 class="rounded-circle p-1 bg-primary" width="110">
                            <div class="mt-3 align-items-center">
                                <!--<input type="file" id="id" accept="image/png,image/jpeg">-->
                            </div>
                        </div>
                        <hr class="my-4">

                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card">
                    <form action="UpdateProfileParent" method="POST">
                        <div class="card-body">
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Full Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input type="text" class="form-control input_form" placeholder="Enter name child"required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Birthday</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input name="dob" class="form-control input_form" type="date" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Gender</h6>
                                </div>
                                <div class="col-sm-9 text-secondary" >
                                    <select class="form-select col-sm-12 py-2 form-control  custom-select input_form" name="gender" required>
                                        <option value="M"  >Male</option>
                                        <option value="F"  >Female</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-9 text-secondary">
                                    <span class="navbar-text">
                                        <a data-toggle="modal" data-target="#confirmEditProfile">
                                            <input type="submit" class="btn btn-primary px-4"  value="Add new Child"></a>
                                            <span class="text-danger ml-5">${msq}</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
            <!--Start  confirm edit--> 
            <div id="confirmEditProfile" class="modal fade" role="dialog">
                <div class="modal-dialog modal-lg" role="content">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Confirm Edit</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body container">
                            <form action="AddNewChild" method="POST">
                                <div class="card-body">
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Full Name</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name ="fullName" class="form-control input_confirm" placeholder="Enter name child" value=""required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Birthday</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input name="dob" class="form-control input_confirm" type="date" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Gender</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary" >
                                            <select class="form-select col-sm-12 py-2 form-control  custom-select input_confirm " name="gender" required>
                                                <option value="M"  >Male</option>
                                                <option value="F"  >Female</option>
                                            </select>
                                        </div>
                                    </div>
                                    <input type="hidden" name ="idUser" class="form-control input_confirm" placeholder="Enter name child" value="${u.idUser}"required>
                                    <div class="form-row text-left col-12">
                                        <button type="button" class="btn btn-secondary btn-sm ml-auto"
                                                data-dismiss="modal">Cancel</button>
                                        <button type="submit" class="btn btn-primary btn-sm ml-3 px-5">Save</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--End  confirm edit--> 
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

</script>
 <script>
        var inputForms = document.querySelectorAll('.input_form');
        var inputConfirms = document.querySelectorAll('.input_confirm');

        for (let i = 0; i < inputForms.length; i++) {
            inputForms[i].addEventListener('change', function () {
                console.log(i);
              inputConfirms[i].value = inputForms[i].value;
            });
        }
        
    </script>
</body>
</html>
