<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>

<body>

    <!-- Header Start -->
        <div class="container-fluid bg-primary mb-5 row">
            <div class="d-flex flex-column  justify-content-center container" style="min-height: 70px">
                <div class="d-inline-flex text-white">
                    <p class="m-0"><a class="text-white" href="">Home</a></p>
                    <p class="m-0 px-2">/</p>
                    <p class="m-0">Admin Page</p>
                </div>
            </div>
        </div>
<!--    <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0 px-lg-5">

        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav font-weight-bold mx-auto py-0">
                            <a href="gallery.jsp" class="nav-item nav-link">Create Timetable</a>
                            <a href="newAnouncement.jsp" class="nav-item nav-link">Announcement</a>
                            <a href="admin-list?role=${'Teacher'}" class="nav-item nav-link">User Management</a>
                            <a href="class-management" class="nav-item nav-link">Class Management</a>
                            <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">Classes</a>
            
            <c:if test="${role == 'Admin'}">
                <a href="addClass.jsp" class="nav-item nav-link">Create class</a>
                <a href="class-registration-list" class="nav-item nav-link">Class registration list</a>
            </c:if>

        </div>

        </div>
    </nav>-->

    <div class="container ">
        <div class="row">

            <!--==========================================-->
            <div class="col-sm-3">
                <a href="gallery.jsp" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-calendar-week"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Timetable</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="newAnouncement.jsp" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-scroll"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Announcement</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="admin-list?role=${'Teacher'}" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-users"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>User Manager</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="class-management" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-th-list"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Class Manager</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-graduation-cap"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Classes</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="addClass.jsp" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-plus-square"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Create class</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="class-registration-list" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-list-ol"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Regist Class</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
            <!--==========================================-->
            <div class="col-sm-3">
                <a href="Analys" class="nav-item nav-link">
                    <div class="card">
                        <div class="card-body d-flex flex-column  justify-content-center container">
                            <div class="col-12 text-center display-1">
                                <i class="fas fa-calendar-week"></i>
                            </div>
                            <div class="col-12 text-center">
                                <h4>Dashboard</h4>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <!--==========================================-->
        </div>
    </div>
    <!-- Header End -->


    <!-- Class Start -->

    <!-- Class End -->


    <!-- Registration Start -->


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
</body>

</html>