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
    <div class="container-fluid ">
        <!-- Class Start -->
        <div class="tab-content">
            <div role="tabpanel" class=" tab-pane fade show active " id="Class">
                <div class="container">
                    <div class="text-center pb-2">
                        <p class="section-title px-5"><span class="px-2">Tuition Payment</span></p>
                        <h1 class="mb-4">Your child's tuition fee sheet</h1>
                    </div>
                    
                    <div class="row">
                        <c:forEach var="o" items="${listChild}" >
                            <div class="col-lg-4 mb-5">
                                <div class="card border-0 bg-light shadow-sm pb-2">
                                    <div class="card-body text-center">
                                        <input type="hidden" name ="id" value="">
                                        <h4 class="card-title"><input name="className" type="hidden" value=""/>Tuition Fees:${o.getChildName()}</h4>
                                    </div>
                                    <div class="card-footer bg-transparent py-4 px-5">
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Parent Name</strong></div>
                                            <div class="col-6 py-1" name ="idUser"> ${u.getFullName()}</div>
                                        </div>
                                        <div class="row border-bottom">
                                            <div class="col-6 py-1 text-right border-right"><strong>Child Name</strong></div>
                                            <div class="col-6 py-1">${o.getChildName()}</div>
                                        </div>
                                    </div>
                                            <span class="navbar-text text-center">
                                               <a href="PaymentByIdChild?idChild=${o.idChild.trim()}">
                                                   <span class="btn btn-primary px-4 " >Go for payment</span>
                                                </a>
                                                <span class="text-primary ">${msq}</span>
                                            </span>
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
</body>

</html>
