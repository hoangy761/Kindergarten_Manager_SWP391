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
    <style>
        .proposal_item:hover{
            background-color: rgb(247, 247, 255);
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="main-body row">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="./img/${u.getImgAvt()}"  alt="Admin" class="rounded-circle" width="150" height="150">
                            <div class="mt-3">
                                <!--<h4>${u.getFullName()}</h4>-->
                                <p class="text-secondary mb-1">ID: @${proIdProposal.idUser}</p>
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

                        <div class="row">
                            <div class="col-sm-8 text-secondary font-weight-bold " style="font-size: large">
                                ${proIdProposal.title}
                            </div>

                            <div class=" col-sm-4 text-secondary text-right">
                                <span class="bg-success"  style="border-radius: 20px; padding: 1px 5px">${proIdProposal.status}</span>
                            </div>
                            <div class="col-sm-3 text-secondary">
                                Content
                            </div>
                            <div class="col-sm-9 text-dark">
                                ${proIdProposal.contentProposal}
                            </div>
                            <div class="col-sm-12 text-secondary text-right">
                                ${proIdProposal.getTimeStartF()} - ${proIdProposal.getTimeEndF()}
                            </div>
                            <div class="col-sm-3 text-secondary mt-5">
                                Vote: ${proIdProposal.getTotalVote()}
                            </div>
                            <c:choose>
                                <c:when test="${proIdProposal.getTotalVote() > 0}">
                                    <div class="col-sm-9 card-body mt-3">
                                        <h4 class="small font-weight-bold">
                                            Vote 
                                            <span class="float-right">
                                                Accept: ${proIdProposal.getAccept()/proIdProposal.getTotalVote()*100}%
                                            </span>
                                        </h4>
                                        <div class="progress ">
                                            <div class="progress-bar bg-success" role="progressbar" 
                                                 style="width: ${proIdProposal.getAccept()/proIdProposal.getTotalVote()*100}%" 
                                                 aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
                                            </div>
                                        </div>
                                    </div>

                                </c:when>
                                <c:when test="${proIdProposal.getTotalVote() == 0}">
                                    <div class="col-sm-9 card-body mt-3">
                                        <h4 class="small font-weight-bold">
                                            Vote
                                            <span class="float-right">
                                                Accept: 0%
                                            </span>
                                        </h4>
                                        <div class="progress ">
                                            <div class="progress-bar bg-success" role="progressbar" style="width: ${0}%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <c:if test="${proIdProposal.status.trim() == 'active'}">
                    <div class="card mb-3">
                        <div class="card-body">
                            <form action="VoteProposal" method="POST">
                                <div class="row container">
                                    <div class="col-12 text-secondary font-weight-bold " style="font-size: large">
                                        <h2>Cast your vote</h2>
                                    </div>

                                    <div class="col-12 text-center">
                                        <div class="btn-group btn-group-toggle row" data-toggle="buttons">
                                            <label class="btn btn-success" style="width:  11rem;">
                                                <input type="radio" name="options" id="option1" autocomplete="off" value="1" >
                                                Yes
                                            </label>
                                            <label class="btn btn-danger " style="width:  11rem;">
                                                <input type="radio" name="options" id="option2" autocomplete="off" value="0" > 
                                                No
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group col-12 text-center mt-3">
                                        <span class="navbar-text">
                                            <a data-toggle="modal" data-target="#previewVote">
                                                <input type="submit" class="btn btn-primary px-4" id="vote_"  value="Vote">
                                            </a>
                                            <span class=" ${text-color} ">${msq}</span>
                                        </span>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <div id="" class="modal fade previewVote" role="dialog">
        <div class="modal-dialog modal-lg" role="content">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Cast your vote</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="VoteProposal" method="POST">
                        <div class="form-row row container">
                            <div class="col-12">
                                <div class="col-12 text-center" id="you_say">


                                </div>
                            </div>

                            <div class="form-row text-left col-12 mt-3 ">
                                <button type="button" class="btn btn-secondary btn-sm ml-auto" data-dismiss="modal">
                                    Cancel
                                </button>

                                <input type="hidden" class="" id="id" name="idUser" value="${u.idUser}">
                                <input type="hidden" class="form_submit" id="voteValue" name="vote" value="">
                                <input type="hidden" class="form_submit" id="id" name="idProposal" value="${proIdProposal.idProposal}">


                                <button type="submit" class="btn btn-primary btn-sm ml-3 px-5">Vote</button>
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


        //        console.log(value_Vote)
        //        if (value_Vote == 1 || value_Vote == 0) {
        //            document.getElementById("vote_").disabled = true;
        //        }
        var vote_ = document.getElementById("vote_");
        var voteValue = document.getElementById("voteValue");
        var previewVote_ = document.querySelector('.previewVote');
        var you_say = document.getElementById("you_say");
        vote_.onclick = () => {
            var value_Vote = document.querySelector('input[name="options"]:checked').value;
            if (value_Vote == 1) {
                you_say.innerHTML = '<h2 class="text-success">You Say  "Yes" </h2>'
                previewVote_.id = "previewVote";
                voteValue.value = value_Vote;
            } else {
                you_say.innerHTML = '<h2 class="text-danger">You Say  "No" </h2>'
                previewVote_.id = "previewVote";
                voteValue.value = value_Vote;
            }
        }

    </script>
    <script>



    </script>

</body>
</html>
