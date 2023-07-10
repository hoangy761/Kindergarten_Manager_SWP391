<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>


<body>

    <!-- Header Start -->
    <div class="container-fluid bg-primary mb-5 row">
        <div class="d-flex flex-column  justify-content-center container" style="min-height: 70px">
            <div class="d-inline-flex text-white">
                <p class="m-0"><a class="text-white" href="index.jsp">Home</a></p>
                <p class="m-0 px-2">/</p>
                <p class="m-0">Class</p>
            </div>
        </div>
    </div>

    <!-- Header End -->
    <div class="container-fluid pt-5">
        <ul class="nav nav-tabs">
            <li class="nav-item" >
                <a class="nav-item nav-link "  href="#Class" onclick="saveTabState('Class')"role="tab" data-toggle="tab" >Class</a>
            </li>
            <li class="nav-item">
                <a class="nav-item nav-link " href="#Course" role="tab" onclick="saveTabState('Course')"data-toggle="tab">Course </a>
            </li>

        </ul>



        <!-- Class Start -->
        <div class="tab-content">

            <div role="tabpanel" class=" tab-pane fade show " id="Class">
                <div class="col-12 d-flex">
                    <form action="SortList" method="post">
                        <div class="col-12 d-flex">
                            <input type="hidden" name ="id" value="${u.getIdUser()}">
                            <select class="form-select form-control input_form" name="sCriteria">

                                <option value="all" ${sCriteria == "all" ? "selected" : ""}>All</option>
                                <option value="03"${sCriteria == "03" ? "selected" : ""}> condition 3 old</option>
                                <option value="04"${sCriteria == "04" ? "selected" : ""}>condition 4 old</option>
                                <option value="05"${sCriteria == "05" ? "selected" : ""}>condition 5 old</option>
                                <option value="06"${sCriteria == "06" ? "selected" : ""}>condition 6 old</option>
                                <option value="0"${sCriteria == "0" ? "selected" : ""}>Class is full</option>
                                <option value="avai"${sCriteria == "avai" ? "selected" : ""}>Class is available</option>
                            </select>
                            <button type="submit" class="btn btn-primary btn-sm ml-3 px-5" onclick="saveTabState('Class')">Sort</button>
                        </div>
                    </form>
                    <form action="search" method="post">
                        <input type="hidden" name ="id" value="${u.getIdUser()}">
                        <div class="col-12 d-flex">
                            <input type="text" class="searchinput form-control" name="search" placeholder="Search&hellip;" style="margin-bottom: 0;"> 
                            <div class="input-group-btn" > <div class="input-group input-group-sm">
                                    <button type="submit" class="searchbutton btn btn-primary" style="padding-left: 10%;border-radius: 0" ><i class="fa fa-search fa-lg"></i></button>
                                </div>


                            </div>
                        </div>
                    </form>
                </div>

                <div class="container">
                    <div class="text-center pb-2">
                        <p class="section-title px-5"><span class="px-2">Popular Classes</span></p>
                        <h1 class="mb-4">Classes for Your Kids</h1>
                        <h3 class="text-danger" style="text-align: center">${msq}</h3>
                    </div>
                    <div class="row">

                        <c:forEach var="o" items="${listcl}" >
                            <div class="col-lg-4 mb-5">
                                <div class="card border-0 bg-light shadow-sm pb-2">
                                    <img class="card-img-top mb-2" src="img/class-1.jpg" alt="">
                                    <div class="card-body text-center">
                                        <input type="hidden" name ="idClass" value="${o.getIdClass()}">
                                        <h4 class="card-title"><input name="className" type="hidden" value="${o.getClassName()}"/>Class ${o.getClassName()}</h4>
                                    </div>
                                    <div class="card-footer bg-transparent py-4 px-5">
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Teacher</strong></div>
                                            <div class="col-6 py-1"> <a href="ProfileById?idUser=${o.getIdUser()}" class="table-link">${o.getFullName()}</a></div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Age condition</strong></div>
                                            <div class="col-6 py-1">${o.getCondition()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right" for="seat"><strong>Total Seats</strong></div>
                                            <div class="col-6 py-1" name="totalSeat">${o.getTotalSeat()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Time Start</strong></div>
                                            <div class="col-6 py-1" name="timeStartSemester">${o.getStartDate1()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Time End</strong></div>
                                            <div class="col-6 py-1" name="timeEndSemester">${o.getEndDate1()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Slot</strong></div>
                                            <div class="col-6 py-1" name="slot">${o.getSlot()}</div>
                                        </div>
                                    </div>
                                    <c:if test="${user1 != null}">
                                        <c:choose>
                                            <c:when test="${o.getTotalSeat() > 15}">
                                                <span class="navbar-text text-center">
                                                    <a data-toggle="modal" data-target="#confirmClass${o.getIdClass().trim()}">
                                                        <input type="button" class="btn btn-primary px-4 " value="Join Now">
                                                    </a>
                                                </span>
                                            </c:when>
                                            <c:when test="${o.getTotalSeat()==0}">
                                                <span class="navbar-text text-center">
                                                    <input type="button" class="btn btn-danger px-4 " value="Full">
                                                </span>
                                            </c:when>
                                            <c:when test="${o.getTotalSeat()< 15 && o.getTotalSeat() >0}">
                                                <span class="navbar-text text-center">
                                                    <a data-toggle="modal" data-target="#confirmClass${o.getIdClass().trim()}">
                                                        <input type="button" class="btn btn-warning px-4 " value="Join Now">
                                                    </a>
                                                </span>
                                            </c:when>
                                        </c:choose>

                                    </c:if>
                                    <c:if test="${user1 == null}">
                                        <span class="navbar-text text-center">
                                            <a  href="login.jsp">
                                                <input type="button" class="btn btn-success px-4 " value="Join Now">
                                            </a>
                                        </span>
                                    </c:if>


                                </div>
                            </div>

                            <div id="confirmClass${o.getIdClass().trim()}" class="modal fade " role="dialog" >
                                <div class="modal-dialog modal-lg" role="content">
                                    Modal content
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Confirm Register Class</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="registerClass" method="POST">
                                                <div class="form-row row container">
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3 col-12">
                                                            <h6 class="mb-0 pt-2">Parent Name</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <input type="hidden" name ="idUser" value="${u.getIdUser()}"> ${u.getFullName()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3 col-12">
                                                            <h6 class="mb-0 pt-2">Child Name</h6>
                                                        </div>

                                                        <select class="form-select form-control" style="width: 60%;margin-left: 19px"name="idChild" >

                                                            <c:forEach items="${listc4}" var="c">
                                                                <c:if test="${year - c.getDateOB().toLocalDate().getYear() == o.getCondition()}">
                                                                    <option value="${c.idChild}">${c.childName}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>

                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3 col-12">
                                                            <h6 class="mb-0 pt-2">Class Name</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <input type="hidden" name ="idClass" class="form-control input_confirm" value="${o.getIdClass()}"required>${o.getClassName()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Total Seats</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${o.getTotalSeat()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Time Start</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${o.getTimeStart1()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Time End</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${o.getTimeEnd1()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Slot</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${o.getSlot()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Tuition Fee</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${o.getTuition()}
                                                        </div>
                                                    </div>
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
                        </c:forEach>


                    </div>
                </div>
            </div>

            <div role="tabpanel" class="tab-pane fade show " id="Course">
                <div class="col-12 d-flex">
                    <form action="SortList" method="post">
                        <div class="col-12 d-flex">
                            <input type="hidden" name ="id" value="${u.getIdUser()}">
                            <select class="form-select form-control input_form" name="sCriteria">
                                <option value="">---Sort Course by---</option>
                                <option value="03"${sCriteria == "03" ? "selected" : ""}> condition 3 old</option>
                                <option value="04"${sCriteria == "04" ? "selected" : ""}>condition 4 old</option>
                                <option value="05"${sCriteria == "05" ? "selected" : ""}>condition 5 old</option>
                                <option value="06"${sCriteria == "06" ? "selected" : ""}>condition 6 old</option>
                                <option value="0"${sCriteria == "0" ? "selected" : ""}>Course is full</option>
                                <option value="avai"${sCriteria == "avai" ? "selected" : ""}>Course is available</option>
                            </select>
                            <button type="submit" class="btn btn-primary btn-sm ml-3 px-5" onclick="saveTabState('Course')">Sort</button>
                        </div>
                    </form>
                    <form action="search" method="post">
                        <input type="hidden" name ="id" value="${u.getIdUser()}">
                        <div class="col-12 d-flex">
                            <input type="text" class="searchinput form-control" name="search" placeholder="Search&hellip;" style="margin-bottom: 0;"> 
                            <div class="input-group-btn" > <div class="input-group input-group-sm">
                                    <button type="submit" class="searchbutton btn btn-primary" style="padding-left: 10%;border-radius: 0" ><i class="fa fa-search fa-lg"></i></button>
                                </div>


                            </div>
                        </div>
                    </form>
                </div>

                <div class="container">
                    <div class="text-center pb-2">
                        <p class="section-title px-5"><span class="px-2">Popular Course</span></p>
                        <h1 class="mb-4">Course for Your Kids <br>(Only Kids Have Class)</h1>
                        <h3 class="text-danger" style="text-align: center">${msq1}</h3>
                    </div>
                    <div class="row">
                        <c:forEach var="i" items="${listc3}" >
                            <div class="col-lg-4 mb-5">
                                <div class="card border-0 bg-light shadow-sm pb-2">
                                    <img class="card-img-top mb-2" src="img/class-1.jpg" alt="">
                                    <div class="card-body text-center">
                                        <input type="hidden" name ="idSkill" value="${i.getIdSkill()}">
                                        <h4 class="card-title"><input name="skillName" type="hidden" value="${i.skillName}"/>Class ${i.skillName}</h4>
                                    </div>
                                    <div class="card-footer bg-transparent py-4 px-5">
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Teacher</strong></div>
                                            <div class="col-6 py-1"> <a href="ProfileById?idUser=${i.getIdUser()}" class="table-link">${i.getFullName()}</a></div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Age condition</strong></div>
                                            <div class="col-6 py-1">${i.getCondition()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right" for="seat"><strong>Total Seats</strong></div>
                                            <div class="col-6 py-1" name="totalSeat">${i.getTotalSeat()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Time Start</strong></div>
                                            <div class="col-6 py-1" name="timeStartSemester">${i.getStartDate1()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Time End</strong></div>
                                            <div class="col-6 py-1" name="timeEndSemester">${i.getEndDate1()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Slot</strong></div>
                                            <div class="col-6 py-1" name="slot">${i.getSlot()}</div>
                                        </div>

                                    </div>
                                    <c:if test="${user1 != null}">
                                        <c:choose>
                                            <c:when test="${i.getTotalSeat() > 15}">
                                                <span class="navbar-text text-center">
                                                    <a data-toggle="modal" data-target="#confirmClass${i.getIdSkill().trim()}">
                                                        <input type="button" class="btn btn-primary px-4 " value="Join Now">
                                                    </a>
                                                </span>
                                            </c:when>
                                            <c:when test="${i.getTotalSeat()==0}">
                                                <span class="navbar-text text-center">
                                                    <input type="button" class="btn btn-danger px-4 " value="Full">

                                                </span>
                                            </c:when>
                                            <c:when test="${i.getTotalSeat()< 15 && i.getTotalSeat() >0}">
                                                <span class="navbar-text text-center">
                                                    <a data-toggle="modal" data-target="#confirmClass${i.getIdSkill().trim()}">
                                                        <input type="button" class="btn btn-warning px-4 " value="Join Now">
                                                    </a>
                                                </span>
                                            </c:when>
                                        </c:choose>
                                    </c:if>

                                    <c:if test="${user1 == null}">
                                        <span class="navbar-text text-center">
                                            <a  href="login.jsp">
                                                <input type="button" class="btn btn-success px-4 " value="Join Now">
                                            </a>
                                        </span>
                                    </c:if>

                                </div>
                            </div>

                            <div id="confirmClass${i.getIdSkill().trim()}" class="modal fade " role="dialog" >
                                <div class="modal-dialog modal-lg" role="content">
                                    Modal content
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Confirm Register Class</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="registerCousre" method="POST">
                                                <div class="form-row row container">
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3 col-12">
                                                            <h6 class="mb-0 pt-2">Parent Name</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <input type="hidden" name ="idUser" value="${u.getIdUser()}"> ${u.getFullName()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3 col-12">
                                                            <h6 class="mb-0 pt-2">Child Name</h6>
                                                        </div>
                                                        <select class="form-select form-control" style="width: 60%;margin-left: 19px"name="idChild" >
                                                            <c:forEach items="${listc2}" var="c">
                                                                <c:if test="${year - c.getDateOB().toLocalDate().getYear() == i.getCondition()}">
                                                                    <option value="${c.idChild}">${c.childName}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>

                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3 col-12">
                                                            <h6 class="mb-0 pt-2">Skill Name</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <input type="hidden" name ="idSkill" class="form-control input_confirm" value="${i.getIdSkill()}"required>${i.skillName}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Total Seats</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${i.getTotalSeat()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Time Start</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${i.getTimeStart1()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Time End</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${i.getTimeEnd1()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Slot</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${i.getSlot()}
                                                        </div>
                                                    </div>
                                                    <div class="row mb-3 col-12">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0 pt-2">Tuition Fee</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            ${i.getTuition()}
                                                        </div>
                                                    </div>
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
                        </c:forEach>


                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Class End -->





    <!-- Footer Start -->
    <%@ include file="include/footer.jsp" %>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary p-3 back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/isotope/isotope.pkgd.min.js"></script>
    <script src="lib/lightbox/js/lightbox.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script>
                                var inputForms = document.querySelectorAll('.input_form');
                                var inputConfirms = document.querySelectorAll('.input_confirm');

                                for (let i = 0; i < inputForms.length; i++) {
                                    inputForms[i].addEventListener('change', function () {
                                        console.log(i);
                                        inputConfirms[i].value = inputForms[i].value;
                                    });
                                }
                                function saveTabState(tabId) {
                                    localStorage.setItem("currentTab", tabId);
                                }
                                window.addEventListener("DOMContentLoaded", function () {
                                    var currentTab = localStorage.getItem("currentTab");
                                    if (currentTab) {
                                        var tabPanes = document.getElementsByClassName("tab-pane");
                                        for (var i = 0; i < tabPanes.length; i++) {
                                            tabPanes[i].classList.remove("active");
                                        }
                                        var selectedTabPane = document.getElementById(currentTab);
                                        selectedTabPane.classList.add("active");
                                    }
                                });
    </script>
</body>

</html>
