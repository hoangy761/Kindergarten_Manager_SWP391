<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="css/teacher.css" rel="stylesheet">
<body>

    <!-- Header Start -->
    <div class="container-fluid bg-primary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 400px">
            <h3 class="display-3 font-weight-bold text-white">Our Teachers</h3>
            <div class="d-inline-flex text-white">
                <p class="m-0"><a class="text-white" href="index.jsp">Home</a></p>
                <p class="m-0 px-2">/</p>
                <p class="m-0">Our Teachers</p>
            </div>
        </div>
    </div>
    <!-- Header End -->


    <!-- Team Start -->
    <div class="container">
        <div class="mt-5">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-item nav-link input_form"  href="class-list?id=${id}" >Main class</a>
                </li>
                <li class="nav-item">
                    <a class="nav-item nav-link" href="skill-list?id=${id}" >Talents' class</a>
                </li>

            </ul>
            <c:forEach var="o" items="${listA}">
                <div class="d-style  border-2 bgc-white  btn-h-outline-blue btn-a-outline-blue w-100 my-2 py-3 shadow-sm">
                    <!-- Basic Plan -->

                    <div class="row align-items-center">
                        <div class="col-12 col-md-4 text-center">
                            <h4 class="pt-3 text-170 text-600 text-primary-d1 letter-spacing">
                                ${o.className}
                            </h4>
                        </div>

                        <ul class="list-unstyled mb-0 col-12 col-md-4 text-dark-l1 text-90 text-left my-4 my-md-0">
                            <li>
                                <label class="btn-success "> Start Date</label>
                                <p>${o.getStartDate1()}</p>
                            </li>

                            <li>
                                <label class="btn-danger "> End Date</label>
                                <p>${o.getEndDate1()}</p>
                            </li>
                        </ul>

                        <div class="col-12 col-md-4 text-center">
                            <a href="child-list?id=${o.getIdClass()}" class="f-n-hover btn btn-info btn-raised px-4 py-25 w-75 text-600">Get Started</a>
                        </div>
                    </div>

                </div>



            </c:forEach>

            <c:forEach var="o" items="${listB}">
                <div class="d-style  border-2 bgc-white  btn-h-outline-blue btn-a-outline-blue w-100 my-2 py-3 shadow-sm">
                    <!-- Basic Plan -->

                    <div class="row align-items-center">
                        <div class="col-12 col-md-4 text-center">
                            <h4 class="pt-3 text-170 text-600 text-primary-d1 letter-spacing">
                                ${o.skillName}
                            </h4>
                        </div>

                        <ul class="list-unstyled mb-0 col-12 col-md-4 text-dark-l1 text-90 text-left my-4 my-md-0">
                            <li>
                                <label class="btn-success "> Start Date</label>
                                <p>${o.getStartDate1()}</p>
                            </li>

                            <li>
                                <label class="btn-danger "> End Date</label>
                                <p>${o.getEndDate1()}</p>
                            </li>
                        </ul>

                        <div class="col-12 col-md-4 text-center">
                            <a href="skill-child?id=${o.getIdSkill()}" class="f-n-hover btn btn-info btn-raised px-4 py-25 w-75 text-600">Get Started</a>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>

        <nav>
            <ul class="pagination">
                <li class="page-item">
                    <c:if test="${tagA > 1}">
                        <a href="class-list?pageA=${tagA-1}&id=${id}" class="page-link input_confirm" aria-label="Previous">
                            <span aria-hidden="true">«</span>
                        </a>
                    </c:if>

                </li>
                <c:if test="${endPageA > 1}">
                     <c:forEach begin="1" end="${endPageA -1}" var="i">
                         <c:if test="${tagA < endPageA}">
                             <li class="page-item "><a href="class-list?pageA=${i}&id=${id}" class="page-link ${tagA==i? "active" : ""}">${i}</a></li>
                         </c:if>
                    
                    </c:forEach>
                </c:if>
               
                    <c:if test="${tagA < endPageA-1}">
                    <li class="page-item">
                        <a href="class-list?pageA=${tagA+1}&id=${id}" class="page-link" aria-label="Next">
                            <span aria-hidden="true">»</span>
                        </a>
                    </li>
                </c:if>

            </ul>
        </nav>
        <nav>
            <ul class="pagination">
                <li class="page-item">
                    <c:if test="${tag > 1}">
                        <a href="skill-list?page=${tag-1}&id=${id}" class="page-link" aria-label="Previous">
                            <span aria-hidden="true">«</span>
                        </a>
                    </c:if>
                </li>
                <c:if test="${endPage > 1}">
                     <c:forEach begin="1" end="${endPage -1}" var="i">
                         <c:if test="${tag < endPage}">
                              <li class="page-item "><a href="skill-list?page=${i}&id=${id}" class="page-link ${tag==i? "active" : ""}">${i}</a></li>
                         </c:if>
                   
                    </c:forEach>
                </c:if>
                 <c:if test="${tag < endPage -1}">
                    <li class="page-item">
                        <a href="skill-list?page=${tag+1}&id=${id}" class="page-link" aria-label="Next">
                            <span aria-hidden="true">»</span>
                        </a>
                    </li>
                </c:if>

            </ul>
        </nav>
    </div>
    <!-- Team End -->

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

    </script>
</body>

</html>