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
                        <h1 class="mb-4">${childRequest.childName} - tuition fee sheet</h1>
                    </div>


                    <div class="row">

                        <table class="table user-list col-12 mb-5">
                            <thead  class="bg-primary text-white">
                                <tr>
                                    <th class="text-center">Class</th>
                                    <!--vong lap skill-->

                                    <% int count = 0;%>
                                    <c:forEach items="${listFees}" var="fee">
                                        <th class="text-center"><%= count++%>. Name Fee</th>
                                        </c:forEach>

                                    <!--vong lap skill-->

                                    <th class="text-center">Start Semester</th>
                                    <th class="text-center">End Semester</th>
                                    <th class="text-center">Total Tuition</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr   class=" btn-light">


                                    <td class="text-center">
                                        ${childClass.getClassName()}
                                    </td>
                                    <!--vong lap skill-->

                                    <c:forEach items="${listFees}" var="fee">
                                        <td class="text-center">
                                            <c:forEach items="${listClass}" var="classL">
                                                <c:if test="${classL.idClass.trim() == fee.idNameFee.trim() }">
                                                    ${classL.className} (${fee.tuition}$)
                                                </c:if>
                                            </c:forEach>

                                            <c:forEach items="${listSkill}" var="skill">
                                                <c:if test="${skill.idSkill.trim() == fee.idNameFee.trim() }">
                                                    ${skill.skillName} (${fee.tuition}$)
                                                </c:if>
                                            </c:forEach>

                                        </td>
                                    </c:forEach>
                                    <!--vong lap skill-->
                                    <td class="text-center">
                                        ${childClass.getStartDate2()}
                                    </td>
                                    <td class="text-center">
                                        ${childClass.getEndDate2()}
                                    </td>
                                    
                                    <c:if test="${tuition == null}">
                                        <td class=" btn-success">
                                            <h5 class="text-center text-white">
                                                completely payment
                                            </h5>
                                        </td>
                                    </c:if>
                                    <c:if test="${tuition != null}">
                                        <td class="text-center px-5 btn-warning ">
                                            ${tuition.tuition}$
                                        </td>
                                    </c:if>
                                </tr>
                                </a>
                            </tbody>
                        </table>
                        <div class="container">
                            <div class="header clearfix">

                                <h3 class="text-muted">Payment Choice</h3>
                            </div>
                            <div class="d-flex justify-content-center" style="min-height: 70px">
                                <div class="form-group p-3">
                                    <a href="PaymentTution?tution=${tuition.tuition}">
                                        <span class=" btn bg-success text-white">
                                            Payment Transaction
                                        </span>
                                    </a>
                                    <br>
                                </div>
                                <div class="form-group p-3">
                                    <button onclick="querydr()" class=" btn bg-secondary text-white">Payment Result Query API</button><br>
                                </div>
                                <div class="form-group p-3">
                                    <button onclick="refund()" class=" btn bg-primary text-white">Transaction Refund API</button><br>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center">
                                <p>
                                    &nbsp;
                                </p>
                                <footer class="footer">
                                    <p>&copy; VNPAY 2020</p>
                                </footer>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Class End  ProfileChildById?idChild=${childRequest.idChild.trim()}-->





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
                                        function pay() {
                                            window.location.href = "vnpay_pay.jsp";
                                        }
                                        function querydr() {
                                            window.location.href = "vnpay_querydr.jsp";
                                        }
                                        function refund() {
                                            window.location.href = "vnpay_refund.jsp";
                                        }
    </script>
</body>


</html>
