<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link href="css/stylesChild.css" rel="stylesheet">
<body>

    <!-- Header Start -->
    <div class="container-fluid bg-primary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 400px">
            <h3 class="display-3 font-weight-bold text-white">Class List</h3>

        </div>
    </div>
    <!-- Header End -->


    <!-- Team Start -->
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="main-box clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                    <th>Index</th>
                                    <th><span>Class Name</span></th>
                                    <th><span>ID Teacher</span></th>
                                    <th><span>ID Child</span></th>
                                    <th class="text-center"><span>Total Seat</span></th>
                                    <th><span>Time Start</span></th>
                                    <th><span>Time End</span></th>
                                    <th><span>Status</span></th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%int count = 0;%>
                                <c:forEach items="${adclasslist}" var="adl">
                                    <c:if test="${adl.status.trim() == 'regist'}">
                                        <tr>
                                                <td><%count++;
                                            out.print(count);%></td>
                                            <td>
                                                ${adl.getClassName()}
                                            </td>
                                            <td>
                                                ${adl.getIdteacher()}
                                            </td>
                                            <td>
                                                ${adl.getIdchild()}
                                            </td>

                                            <td >
                                                ${adl.getTotalSeat()}
                                            </td>
                                            <td>
                                                ${adl.getTimeStart1()}
                                            </td>
                                            <td>
                                                ${adl.getTimeEnd1()}
                                            </td>
                                            <td>
                                                ${adl.getStatus()}
                                            </td>
                                            <td style="width: 10%;">
                                                <a href="updateClassRegist?idClass=${adl.getStatus()}"
                                                   class="table-link" data-toggle="modal" data-target="#confirmClassregist">
                                                    <span class="fa-stack">
                                                        <i class="fa fa-square fa-stack-2x"></i>
                                                        <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                    </span>
                                                </a>
                                                <a href="#" class="table-link danger">
                                                    <span class="fa-stack">
                                                        <i class="fa fa-square fa-stack-2x"></i>
                                                        <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                                    </span>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div id="confirmClassregist" class="modal fade" role="dialog">
                            <div class="modal-dialog modal-lg" role="content">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Confirm Register Class</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="addCourse" method="POST">
                                            <div class="form-row row container">
                                                <div class="row mb-3 col-12">
                                                    <div class="col-sm-3 col-12">
                                                        <h6 class="mb-0 pt-2">Update Class Register</h6>
                                                    </div>
                                                    <div class="col-sm-9 text-secondary">
                                                        <input type="text" name ="skillName" class="form-control input_confirm" value=""  "required>
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
                        <nav>
                            <ul class="pagination">
                                <li class="page-item">
                                    <c:if test="${tag > 1}">
                                        <a href="adClassList?page=${tag-1}" class="page-link" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </c:if>

                                </li>
                                <c:forEach begin="1" end="${endPage}" var="i">
                                    <li class="page-item "><a href="adClassList?page=${i}" class="page-link ${tag==i? "active" : ""}">${i}</a></li>
                                    </c:forEach>
                                    <c:if test="${tag < endPage}">
                                    <li class="page-item">
                                        <a href="adClassList?page=${tag+1}" class="page-link" aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </li>
                                </c:if>

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
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
</body>

</html>