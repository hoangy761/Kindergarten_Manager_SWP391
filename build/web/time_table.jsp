<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp" %>

 <link href="css/timeTable.css" rel="stylesheet">
<body>

    <!-- Header Start -->
    <div class="container-fluid bg-primary row">
        <div class="d-flex flex-column  justify-content-center container" style="min-height: 70px">
            <div class="d-inline-flex text-white">
                <p class="m-0"><a class="text-white" href="">Home</a></p>
                <p class="m-0 px-2">/</p>
                <p class="m-0">TimeTable</p>
            </div>
        </div>
    </div>
    <!-- Header End -->


    <!-- Gallery Start -->
    <div class="container-fluid pt-1 pb-3">
        <div class="container">
            <div class="timetable-img text-center">
                <img src="img/content/timetable.png" alt>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered text-center">
                    <thead>
                        <tr class="bg-light-gray">
                            <th class="text-uppercase">Time
                            </th>
                            <th class="text-uppercase">Monday</th>
                            <th class="text-uppercase">Tuesday</th>
                            <th class="text-uppercase">Wednesday</th>
                            <th class="text-uppercase">Thursday</th>
                            <th class="text-uppercase">Friday</th>
                            <th class="text-uppercase">Saturday</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="align-middle">7:00 - 8:30</td>
                            <td>
                                <span
                                    class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13">Dance</span>
<!--                                <div class="margin-10px-top font-size14">9:00-10:00</div>-->
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-green padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Yoga</span>
                                    <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-yellow padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Music</span>
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Dance</span>
                              <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-purple padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Art</span>
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-pink padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">English</span>
                               <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle">9:00 - 10:30</td>
                            <td>
                                <span
                                    class="bg-yellow padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Music</span>
                               <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td class="bg-light-gray">
                            </td>
                            <td>
                                <span
                                    class="bg-purple padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Art</span>
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-green padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Yoga</span>
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-pink padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">English</span>
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td class="bg-light-gray">
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle">11:00 - 14:00</td>
                            <td>
                                <span
                                    class="bg-lightred padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Break</span>
                            </td>
                            <td>
                                <span
                                    class="bg-lightred padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Break</span>
                            </td>
                            <td>
                                <span
                                    class="bg-lightred padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Break</span>
                            </td>
                            <td>
                                <span
                                    class="bg-lightred padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Break</span>
                            </td>
                            <td>
                                <span
                                    class="bg-lightred padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Break</span>
                            </td>
                            <td>
                                <span
                                    class="bg-lightred padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Break</span>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle">14:00 - 15:30</td>
                            <td class="bg-light-gray">
                            </td>
                            <td>
                                <span
                                    class="bg-purple padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Art</span>
                                <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-sky padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Dance</span>
                              <div class="font-size13 text-light-gray pt-2">Teacher Name</div>
                            </td>
                            <td>
                                <span
                                    class="bg-yellow padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Music</span>
                                <div class="font-size13 text-light-gray pt-2">Ivana Wong</div>
                            </td>
                            <td class="bg-light-gray">
                            </td>
                            <td>
                                <span
                                    class="bg-green padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Yoga</span>
                                <div class="font-size13 text-light-gray pt-2">Marta Healy</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle">16:00 - 17:30</td>
                            <td>
                                <span
                                    class="bg-pink padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">English</span>
                                <div class="font-size13 text-light-gray pt-2">James Smith</div>
                            </td>
                            <td>
                                <span
                                    class="bg-yellow padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Music</span>
                                <div class="font-size13 text-light-gray pt-2">Ivana Wong</div>
                            </td>
                            <td class="bg-light-gray">
                            </td>
                            <td>
                                <span
                                    class="bg-pink padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">English</span>
                                <div class="font-size13 text-light-gray pt-2">James Smith</div>
                            </td>
                            <td>
                                <span
                                    class="bg-green padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Yoga</span>
                                <div class="font-size13 text-light-gray pt-2">Marta Healy</div>
                            </td>
                            <td>
                                <span
                                    class="bg-yellow padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16  xs-font-size13">Music</span>
                                <div class="font-size13 text-light-gray pt-2">Ivana Wong</div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Gallery End -->


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
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>
</body>

</html>