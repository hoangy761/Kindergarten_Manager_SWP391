<%-- 
    Document   : profileParent
    Created on : May 26, 2023, 5:15:06 PM
    Author     : PC
--%>

<%@page import="model.proposal.Proposal"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="include/header.jsp" %>

<head>
    <title>My Profile</title>
    <link href="css/styleMyProfileParent.css" rel="stylesheet">
    <style>
        .proposal_item:hover{
            background-color: rgb(247, 247, 255);
        }
        .contentBox{
            height: 5rem;
            overflow-y: hidden;
        }
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
                                <a href="index.jsp" class="navbar-brand font-weight-bold text-secondary" style="font-size: 50px;">
                                    <i class="flaticon-043-teddy-bear"></i>
                                    <span class="text-primary">Kid ABC</span>
                                </a>
                                <h4>Proposal</h4>
                                <a href="newProposal.jsp">+ New Proposal</a>
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

                            <c:forEach var="proposal" items="${listProposal}">
                                <a href="ProposalView?idProposal=${proposal.idProposal}" class="nav-link proposal_item">
                                    <div class="row">
                                        <div class="col-sm-8 text-secondary font-weight-bold " style="font-size: large">
                                            ${proposal.title}
                                        </div>

                                        <div class=" col-sm-4 text-secondary text-right">
                                            <span class="bg-success"  style="border-radius: 20px; padding: 1px 5px">
                                                ${proposal.status}
                                            </span>
                                        </div>
                                        <div class="col-sm-3 text-secondary">
                                            Content
                                        </div>
                                        <div class="col-sm-9 text-dark contentBox">
                                            ${proposal.contentProposal}

                                        </div>
                                        <div class="col-sm-12 text-secondary text-right">


                                            ${proposal.getTimeStartF()} - ${proposal.getTimeEndF()}

                                        </div>
                                        <div class="col-sm-3 text-secondary mt-5">
                                            Vote: ${proposal.getTotalVote()}
                                        </div>
                                        <c:choose>
                                            <c:when test="${proposal.getTotalVote() > 0}">
                                                <div class="col-sm-9 card-body mt-3">
                                                    <h4 class="small font-weight-bold">
                                                        Vote 
                                                        <span class="float-right">
                                                            Accept: ${proposal.getAccept()/proposal.getTotalVote()*100}%
                                                        </span>
                                                    </h4>
                                                    <div class="progress ">
                                                        <div class="progress-bar bg-success" role="progressbar" 
                                                             style="width: ${proposal.getAccept()/proposal.getTotalVote()*100}%" 
                                                             aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
                                                             
                                                             >
                                                        </div>
                                                    </div>
                                                </div>

                                            </c:when>
                                            <c:when test="${proposal.getTotalVote() == 0}">
                                                <div class="col-sm-9 card-body mt-3">
                                                    <h4 class="small font-weight-bold">
                                                        Vote
                                                        <span class="float-right">
                                                            Accept: 0%
                                                        </span>
                                                    </h4>
                                                    <div class="progress ">
                                                        <div class="progress-bar bg-success" role="progressbar" style="width: ${0}%" 
                                                             aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </a>
                                <hr>
                            </c:forEach>
                        </div>
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
