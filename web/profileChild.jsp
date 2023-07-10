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
<body>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <a data-toggle="modal" data-target="#confirmImg">
                                    <img src="./img/${childRequest.getImgAvt().trim()}"  class="rounded-circle p-1 bg-primary" width="150" height="150">
                                </a>
                                <div class="mt-3">
                                    <h4>${childRequest.childName.trim()}</h4>
                                    <p class="text-secondary mb-1">ID: @${childRequest.getIdChild()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-3">
                        <ul class="list-group list-group-flush">


                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info">
                                    <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z">

                                    </path>
                                    </svg>
                                    Class
                                </h6>

                                <span class="text-secondary">${classList.getClassName()}</span>

                                <c:choose>
                                    <c:when test="${classList.getClassName() ==  null}">
                                        <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">Regist Class</a>
                                    </c:when>
                                </c:choose>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info">
                                    <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z">
                                    </path>
                                    </svg>
                                    birth certificate
                                </h6> 
                                <span class="text-secondary"><a data-toggle="modal" data-target="#confirmImgDob" href="#">birth certificate </a></span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">

                            <!--them moi--> 
                            <div class="card-header text-center">
                                <ul class="nav nav-tabs">
                                    <li class="nav-item" >
                                        <a class="nav-item nav-link active "  href="#Infor" role="tab" data-toggle="tab" >Infor</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-item nav-link" href="#ClassCourse" role="tab" data-toggle="tab">Class/Course</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-item nav-link" href="#Certificate" role="tab" data-toggle="tab">Certificate</a>
                                    </li>

                                </ul>
                            </div>
                            <!--them moi--> 

                            <div  class="tab-content">
                                <!--tab infor------------------------------------------------>
                                <div role="tabpanel" class=" tab-pane fade show card-body active" id="Infor">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Parent Name</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${userRequest.getFullName()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Full Name</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${childRequest.childName.trim()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Birthday</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${childRequest.getDob()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Gender</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <c:choose>
                                                <c:when test="${childRequest.gender.trim().equals('M')}">
                                                    Male
                                                </c:when>
                                                <c:when test="${childRequest.gender.trim().equals('F')}">
                                                    Female
                                                </c:when>
                                            </c:choose>
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

                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Weight</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${childRequest.getWeight()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Height</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${childRequest.getHeight()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Health</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${childRequest.getHealth()}
                                        </div>
                                    </div>


                                    <hr>
                                    <c:if test="${role == 'Parent'}">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <a class="btn btn-primary px-5" href="ProfileChildByIdEdit?idChild=${childRequest.idChild.trim()}&idUser=${userRequest.idUser}">Edit</a>
                                                <span class=" ml-5 text-success ">${msq}</span>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${role == 'Teacher' && userRequest.getIdUser().trim() == u.getIdUser().trim() }">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <a class="btn btn-primary px-5" href="ProfileChildByIdEdit?idChild=${childRequest.idChild.trim()}&idUser=${userRequest.idUser}">Edit</a>
                                                <span class=" ml-5 text-success ">${msq}</span>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${role == 'Admin' && userRequest.getIdUser().trim() == u.getIdUser().trim() }">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <a class="btn btn-primary px-5" href="ProfileChildByIdEdit?idChild=${childRequest.idChild.trim()}&idUser=${userRequest.idUser}">Edit</a>
                                                <span class=" ml-5 text-success ">${msq}</span>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>

                                <!--tab infor------------------------------------------------>


                                <!--tab Class/ course------------------------------------------------>
                                <div role="tabpanel" class=" tab-pane fade card-body rounded-bottom " id="ClassCourse">

                                    <div class="text-center">
                                        <ul class="nav nav-tabs">
                                            <li class="nav-item" >
                                                <a class="nav-item nav-link active "  href="#Learning" role="tab" data-toggle="tab" >Learning</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-item nav-link" href="#Done" role="tab" data-toggle="tab">Done</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-item nav-link" href="#Regist" role="tab" data-toggle="tab">Regist</a>
                                            </li>

                                        </ul>
                                    </div>
                                    <div  class="tab-content">
                                        <!--Learning ----------------------------->
                                        <div role="tabpanel" class=" tab-pane fade show card-body active" id="Learning">
                                            <c:if test="${tuition == null}">
                                                    <h3 class="bg-success text-center text-white">
                                                        completely payment
                                                    </h3>
                                            </c:if>
                                            <c:if test="${tuition != null}">
                                                
                                                    <a href="PaymentByIdChild?idChild=${childRequest.getIdChild()}" class="nav-item nav-link d-flex justify-content-end align-items-center">
                                                        Total tuition: ${tuition.tuition}$. <span class="btn btn-warning ml-5"> Go to Payment ===></span> 
                                                    </a>
                                            </c:if>
                                            <h1>Class</h1>
                                            <c:choose>
                                                <c:when test="${classList.getClassName() ==  null}">
                                                    <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">
                                                        Children do not have Course yet. <span class="btn btn-primary">Go to Regist_Course ===></span> 
                                                    </a>
                                                </c:when>
                                                <c:when test="${classList.getClassName() !=  null}">
                                                    <h4>Semester: ${classList.getStartDate2()} - ${classList.getEndDate2()}</h4>
                                                    <table class="table user-list">
                                                        <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>ClassName</th>
                                                                <th>Teacher</th>
                                                                <th>Seat</th>
                                                                <th>Slot</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr  class="bg-gray-300">
                                                                <td>
                                                                    ${classList.className}
                                                                </td>
                                                                <td>
                                                                    <c:forEach items="${allTeacher}" var="teacher">
                                                                        <c:if test="${teacher.idUser.trim() == classList.idTeacher.trim() }">
                                                                            <a href="ProfileById?idUser=${classList.idTeacher}" class="table-link"> ${teacher.fullName}</a>
                                                                        </c:if>
                                                                    </c:forEach> 

                                                                </td>
                                                                <td>
                                                                    30(still ${classList.totalSeat} )
                                                                </td>

                                                                <td >
                                                                    ${classList.slot}
                                                                </td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </c:when>
                                            </c:choose>


                                            <h1> Course </h1>
                                            <c:choose>
                                                <c:when test="${skillList ==  null}">

                                                    <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">
                                                        Children do not have Course yet. <span class="btn btn-primary">Go to Regist_Course ===></span> 
                                                    </a>
                                                </c:when>

                                                <c:when test="${skillList !=  null}">
                                                    <table class="table user-list">
                                                        <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>Course Name</th>
                                                                <th>Teacher</th>
                                                                <th>Seat</th>
                                                                <th>Semester</th>

                                                                <th>Slot</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${skillList}" var="skill">


                                                                <tr  class=" btn-light">
                                                                    <td>
                                                                        ${skill.skillName}
                                                                    </td>
                                                                    <td>
                                                                        <c:forEach items="${allTeacher}" var="teacher">
                                                                            <c:if test="${teacher.idUser.trim() == skill.idTeacher.trim() }">
                                                                                <a href="ProfileById?idUser=${skill.idTeacher}" class="table-link"> ${teacher.fullName}</a>
                                                                            </c:if>
                                                                        </c:forEach> 

                                                                    </td>
                                                                    <td>
                                                                        30<br>(still ${skill.totalSeat} )
                                                                    </td>
                                                                    <td>
                                                                        ${skill.getStartDate1()}</br>${skill.getEndDate1()}
                                                                    </td>

                                                                    <td >
                                                                        ${skill.slot}
                                                                    </td>
                                                                </tr>

                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                        <!--Learning ----------------------------->
                                        <!--Regist ----------------------------->


                                        <div role="tabpanel" class=" tab-pane fade card-body rounded-bottom " id="Regist">
                                            <h1>Class Regist</h1>
                                            <c:choose>
                                                <c:when test="${classListRegist.getClassName() ==  null}">
                                                    <h4>Children do not have REGIST Class yet.</h4>  
                                                </c:when>
                                                <c:when test="${classListRegist.getClassName() !=  null}">
                                                    <h4>Semester: ${classListRegist.getStartDate2()} - ${classListRegist.getEndDate2()}</h4>
                                                    <table class="table user-list">
                                                        <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>ClassName</th>
                                                                <th>Teacher</th>
                                                                <th>Seat</th>
                                                                <th>Slot</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr  class="bg-gray-300">
                                                                <td>
                                                                    ${classListRegist.className}
                                                                </td>
                                                                <td>
                                                                    <c:forEach items="${allTeacher}" var="teacher">
                                                                        <c:if test="${teacher.idUser.trim() == classListRegist.idTeacher.trim() }">
                                                                            <a href="ProfileById?idUser=${classListRegist.idTeacher}" class="table-link"> ${teacher.fullName}</a>
                                                                        </c:if>
                                                                    </c:forEach> 

                                                                </td>
                                                                <td>
                                                                    30(still ${classListRegist.totalSeat} )
                                                                </td>

                                                                <td >
                                                                    ${classListRegist.slot}
                                                                </td>

                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </c:when>
                                            </c:choose>


                                            <h1> Course Regist </h1>
                                            <c:choose>
                                                <c:when test="${skillListRegist ==  null}">
                                                    Children do not have Course yet.
                                                    <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">Go to Regist_Course</a>
                                                </c:when>

                                                <c:when test="${skillListRegist !=  null}">
                                                    <table class="table user-list">
                                                        <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>Course Name</th>
                                                                <th>Teacher</th>
                                                                <th>Seat</th>
                                                                <th>Semester</th>

                                                                <th>Slot</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${skillListRegist}" var="skill">


                                                                <tr  class=" btn-light">
                                                                    <td>
                                                                        ${skill.skillName}
                                                                    </td>
                                                                    <td>
                                                                        <c:forEach items="${allTeacher}" var="teacher">
                                                                            <c:if test="${teacher.idUser.trim() == skill.idTeacher.trim() }">
                                                                                <a href="ProfileById?idUser=${skill.idTeacher}" class="table-link"> ${teacher.fullName}</a>
                                                                            </c:if>
                                                                        </c:forEach> 

                                                                    </td>
                                                                    <td>
                                                                        30<br>(still ${skill.totalSeat} )
                                                                    </td>
                                                                    <td>
                                                                        ${skill.getStartDate1()}</br>${skill.getEndDate1()}
                                                                    </td>

                                                                    <td >
                                                                        ${skill.slot}
                                                                    </td>
                                                                </tr>

                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                        <!--Regist ----------------------------->
                                        <div role="tabpanel" class=" tab-pane fade card-body rounded-bottom " id="Done">
                                            <h1>Class Done</h1>
                                            <c:choose>
                                                <c:when test="${classListDone.getClassName() ==  null}">
                                                    <h4>Children do not have DONE Class yet.</h4>  
                                                </c:when>
                                                <c:when test="${classListDone.getClassName() !=  null}">
                                                    done
                                                    <h4>Semester: ${classListDone.getStartDate2()} - ${classListDone.getEndDate2()}</h4>
                                                    <table class="table user-list">
                                                        <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>ClassName</th>
                                                                <th>Teacher</th>
                                                                <th>Seat</th>
                                                                <th>Slot</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr  class="bg-gray-300">
                                                                <td>
                                                                    ${classListDone.className}
                                                                </td>
                                                                <td>
                                                                    <c:forEach items="${allTeacher}" var="teacher">
                                                                        <c:if test="${teacher.idUser.trim() == classListDone.idTeacher.trim() }">
                                                                            <a href="ProfileById?idUser=${classListDone.idTeacher}" class="table-link"> ${teacher.fullName}</a>
                                                                        </c:if>
                                                                    </c:forEach> 

                                                                </td>
                                                                <td>
                                                                    30(still ${classListDone.totalSeat} )
                                                                </td>

                                                                <td >
                                                                    ${classListDone.slot}
                                                                </td>

                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </c:when>
                                            </c:choose>


                                            <h1> Course Done</h1>
                                            <c:choose>
                                                <c:when test="${skillListDone ==  null}">
                                                    Children do not have Course yet.
                                                    <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">Go to Regist_Course</a>
                                                </c:when>

                                                <c:when test="${skillListDone !=  null}">
                                                    <table class="table user-list">
                                                        <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>Course Name</th>
                                                                <th>Teacher</th>
                                                                <th>Seat</th>
                                                                <th>Semester</th>

                                                                <th>Slot</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${skillListDone}" var="skill">


                                                                <tr  class=" btn-light">
                                                                    <td>
                                                                        ${skill.skillName}
                                                                    </td>
                                                                    <td>
                                                                        <c:forEach items="${allTeacher}" var="teacher">
                                                                            <c:if test="${teacher.idUser.trim() == skill.idTeacher.trim() }">
                                                                                <a href="ProfileById?idUser=${skill.idTeacher}" class="table-link"> ${teacher.fullName}</a>
                                                                            </c:if>
                                                                        </c:forEach> 

                                                                    </td>
                                                                    <td>
                                                                        30<br>(still ${skill.totalSeat} )
                                                                    </td>
                                                                    <td>
                                                                        ${skill.getStartDate1()}</br>${skill.getEndDate1()}
                                                                    </td>

                                                                    <td >
                                                                        ${skill.slot}
                                                                    </td>
                                                                </tr>

                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>








                                    <!--idSkill, skillName, idTeacher, totalSeat, timeStartSemester, timeEndSemester, tuition, status1, condition, slot)-->



                                </div>
                                <!--tab Class/ course------------------------------------------------>





                                <!--tab Certificate------------------------------------------------>

                                <div role="tabpanel" class=" tab-pane fade card-body rounded-bottom " id="Certificate">
                                    <div>
                                        <img src="./img/${childRequest.getImgDob().trim()}"  class=" bg-primary" width="100%" height="100%"><br>
                                    </div>
                                </div>
                                <!--tab Certificate------------------------------------------------>
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
                    <form method="post" action="FileUpLoadChild" enctype="multipart/form-data">
                        <input type="hidden" name ="idChild" class="form-control input_confirm" value="${childRequest.getIdChild()}">
                        <input type="hidden" name ="idUser" class="form-control input_confirm" value="${userRequest.getIdUser().trim()}">
                        <input type="file" class="btn btn-primary"  name="file" value="" placeholder="edit"/>
                        <input type="submit" class="btn btn-primary"  value="Upload" />
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="confirmImgDob" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg" role="content">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Add birth certificate</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form method="post" action="FileUploadDob" enctype="multipart/form-data">
                        <div>
                            <!--<img src="./img/${childRequest.getImgDob().trim()}"  class=" p-1 bg-primary" width="770" height="750"><br>-->
                            <img src="./img/${childRequest.getImgDob().trim()}"  class=" p-1 bg-primary" width="100%" height="100%"><br>
                        </div>
                        <input type="hidden" name ="idChild" class="form-control input_confirm" value="${childRequest.getIdChild()}">
                        <input type="hidden" name ="idUser" class="form-control input_confirm" value="${userRequest.getIdUser().trim()}">
                        <input type="file" class="btn btn-primary"  name="file" value="" placeholder="edit"/>
                        <input type="submit" class="btn btn-primary"  value="Upload" />
                    </form>
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

