<%-- 
    Document   : profileParent
    Created on : May 26, 2023, 5:15:06 PM
    Author     : PC
--%>

<%@page import="model.Class.ClassListDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="include/header.jsp" %>

<head>
    <title>My Profile</title>
    <link href="css/styleMyProfileParent.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <a data-toggle="modal" data-target="#confirmImg">
                                    <img src="./img/${userRequest.getImgAvt().trim()}"  class="rounded-circle p-1 bg-primary" width="150" height="150">
                                </a>
                                <div class="mt-3">
                                    <h4>${userRequest.getFullName()}</h4>
                                    <p class="text-secondary mb-1">ID: @${userRequest.getIdUser()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-3">
                        <ul class="list-group list-group-flush">

                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info"><path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>Twitter</h6>
                                <span class="text-secondary">None</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram mr-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
                                <span class="text-secondary">None</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook mr-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
                                <span class="text-secondary">None</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info">
                                    <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z">
                                    </path>
                                    </svg> certificate
                                </h6> 
                                <span class="text-secondary"><a data-toggle="modal" data-target="#confirmImgCertificate" href="#">certificate</a></span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Full Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userRequest.getFullName()}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Birthday</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userRequest.getDob()}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Gender</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <c:choose>
                                        <c:when test="${userRequest.gender.equals('M')}">
                                            Male
                                        </c:when>
                                        <c:when test="${userRequest.gender.equals('F')}">
                                            Female
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userRequest.getEmail().trim()}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Phone</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userRequest.getPhoneNumber()}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Address</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userRequest.getAddress()}
                                </div>
                            </div>
                            <hr>
                            <c:if test="${u.idUser.trim() == userRequest.getIdUser().trim()}">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <a class="btn btn-primary px-5" href="ProfileParentEdit?idUser=${userRequest.getIdUser()}">Edit</a>
                                        <span class=" ml-5 text-success ">${msq}</span>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="row gutters-sm">
                        <div class="col-sm-6 mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h6 class="d-flex align-items-center mb-3">My child</h6>



                                    <ul class="list-group list-group-flush">
                                        <c:if test="${u.idUser.trim() == userRequest.getIdUser().trim()}">
                                            <c:forEach items="${listChild}" var="child"> 

                                                <c:if test="${userRequest.idUser.trim() == child.idUser.trim()}">
                                                    <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                                        <h6 class="mb-0">
                                                            <a href="ProfileChildById?idChild=${child.idChild.trim()}">${child.childName}</a>
                                                        </h6>
                                                        <span class="text-secondary">${classList.getClassName()}</span>
                                                    </li>   
                                                </c:if>
                                            </c:forEach>
                                        </ul>

                                        <div class="text-secondary">
                                            <a href="newChild.jsp"><input type="button" class="btn btn-primary px-4" value="Add new Child"></a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h6 class="d-flex align-items-center mb-3">My proposal</h6>

                                    <ul class="list-group list-group-flush">

                                        <c:forEach var="proposal" items="${listProposal}"> 
                                            <c:if test="${proposal.idUser.trim() == userRequest.getIdUser().trim()}">

                                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                                    <a href="ProposalView?idProposal=${proposal.idProposal}" class="nav-link proposal_item">

                                                        <h6 class="mb-0"> ${proposal.title} </h6>

                                                        <span class="ml-3">${proposal.getTimeStartF()}</span>

                                                        <small class="ml-3 bg-success text-dark" style="border-radius: 20px; padding: 1px 5px">
                                                            ${proposal.status}
                                                        </small>
                                                    </a>
                                                </li>   
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                    <c:if test="${u.idUser.trim() == userRequest.getIdUser().trim()}">
                                        <div class="text-secondary text-right">
                                            <a href="newProposal.jsp"><input type="button" class="btn btn-primary px-4" value="New Proposal"></a>
                                        </div>
                                    </c:if >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="confirmImg" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg" role="content">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Change avatar</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="fileuploadservlet" enctype="multipart/form-data">
                            <input type="hidden" name ="idUser" class="form-control input_confirm" value="${u.getIdUser()}">
                            <input type="file" class="btn btn-primary"  name="file" value="" placeholder="edit"/>
                            <input type="submit" class="btn btn-primary" value="Upload" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="confirmImgCertificate" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg" role="content">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Change avatar</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="FileUploadCertificate" enctype="multipart/form-data">
                            <img src="./img/${userRequest.getCerticate().trim()}"    width="100%" height="100%"><br>
                            <input type="hidden" name ="idUser" class="form-control input_confirm" value="${u.getIdUser()}">
                            <c:if test="${userRequest.idUser.trim() == u.idUser.trim()}">
                                <input type="file"  class="btn btn-primary"  name="file" value="" placeholder="edit"/>
                                <input type="submit"  class="btn btn-primary"  value="Upload" />
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>
</body>
</html>