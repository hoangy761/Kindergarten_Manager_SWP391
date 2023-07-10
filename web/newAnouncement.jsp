<%-- 
    Document   : newAnouncement
    Created on : Jun 9, 2023, 10:34:16 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp" %>

<head>
    <title>My Profile</title>
    <link href="css/styleMyProfileParent.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                               <img src="./img/${u.getImgAvt().trim()}"  class="rounded-circle p-1 bg-primary" width="150" height="150">
                                <div class="mt-3">
                                    <h4>${u.getFullName()}</h4>
                                    <p class="text-secondary mb-1">ID: @${u.getIdUser()}</p>
                                </div>
                                <div class="mt-3">
                                    <p class="text-secondary mb-1">Author</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-3">
                        <ul class="list-group list-group-flush">


                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info"><path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>Twitter</h6>
                                <a href="https://www.facebook.com/Se17a01" target="target"><span class="text-secondary">@kid_abc</span></a>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram mr-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
                                <a href="https://www.facebook.com/Se17a01" target="target"><span class="text-secondary">@kid_abc</span></a>

                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook mr-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
                                <a href="https://www.facebook.com/Se17a01" target="target"><span class="text-secondary">@kid_abc</span></a>

                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row row-content">
                                <div class="col-12">
                                    <h3>Send your Announcement</h3>
                                </div>
                                <div class="col-12 ">
                                    <form action="newProposal.jsp">
                                        <div class="form-group row">
                                            <label for="firstname" class="col-12 col-form-label">Title</label>
                                            <div class="col-md-12">
                                                <input type="text" class="form-control input_form" id="title" name="title" placeholder="Enter title" >
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="feedback" class="col-12 col-form-label">Description (optional)</label>
                                            <div class="col-12">
                                                <textarea class="form-control input_form" id="contentAnn" name="contentAnn" rows="12" ></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-12 text-right">
                                                <!--<button type="submit" class="btn btn-primary">Send Proposal</button>-->
                                                <span class="navbar-text">
                                                    <a data-toggle="modal" data-target="#previewProposal">
                                                        <input type="submit" class="btn btn-primary px-4"  value="Preview">
                                                    </a>
                                                    <span class="text-danger ">${msq}</span>
                                                </span>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="previewProposal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg" role="content">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Announcement</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="NewAnnouncement" method="POST">
                        <div class="form-row row container">
                            <div class="col-12">
                                <div class="col-12">
                                    <h2 class="mb-0 pt-2 input_confirm"> 
                                    </h2>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="col-12">
                                    <span class="input_confirm">
                                    </span>
                                </div>

                            </div>
                            <div class="form-row text-left col-12 mt-3 ">
                                <button type="button" class="btn btn-secondary btn-sm ml-auto" data-dismiss="modal">
                                    Cancel
                                </button>
                                <input type="hidden" class="form_submit" id="id" name="title" value="value">
                                <input type="hidden" class="form_submit" id="id" name="contentAnn" value="value">
                                <input type="hidden" class="" id="id" name="idUser" value="${u.idUser}">
                                
                                <button type="submit" class="btn btn-primary btn-sm ml-3 px-5">Post</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>

    <script>
        var inputForms = document.querySelectorAll('.input_form');
        var inputConfirms = document.querySelectorAll('.input_confirm');
        var inputSubmit = document.querySelectorAll('.form_submit');

        for (let i = 0; i < inputForms.length; i++) {
            inputForms[i].addEventListener('change', function () {
                
                inputConfirms[i].textContent = inputForms[i].value;
                inputSubmit[i].value = inputForms[i].value;
            });
        }
    </script>
</body>
</html>

