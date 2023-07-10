<%-- 
    Document   : header
    Created on : May 24, 2023, 8:41:52 AM
    Author     : ASUS-PRO
--%>
<%@page import="model.User.Users"%>
<%--<%@page import="Model.UsersDB.*"%>--%>
<%@page import="Model.User.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${USER}" var="u"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Kid ABC</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Handlee&family=Nunito&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">


        <!-- Flaticon Font -->
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="img/icon.ico">
        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <!--    <body>
    
        </body>-->

    <header id="header" class="fixed-top" >

        <c:set var="user1" value="${u}"/>
        <c:set var="role" value="${u.getRole()}"/>


        <div  class="container-fluid bg-light position-relative shadow">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0 px-lg-5">
                <a href="index.jsp" class="navbar-brand font-weight-bold text-secondary" style="font-size: 50px;">
                    <i class="flaticon-043-teddy-bear"></i>
                    <span class="text-primary">Kid ABC</span>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav font-weight-bold mx-auto py-0">
                        <a href="index.jsp" class="nav-item nav-link">Home</a>
                        <a href="time_table.jsp" class="nav-item nav-link">Timetable</a>
                        <a href="GetAllProposal" class="nav-item nav-link">Proposal</a>
                        <a href="AnnouncementList" class="nav-item nav-link">Announcement</a>

                        <a href="ListClass?id=${u.getIdUser()}" class="nav-item nav-link">Classes</a>
                        <c:if test="${role == 'Parent' || role == 'Teacher'}">
                            
                            <a href="payList?idUser=${user1.idUser}" class="nav-item nav-link">Payment</a>
                        </c:if>
                        <c:if test="${role == 'Teacher'}">
                            <a href="class-list?id=${u.getIdUser()}" class="nav-item nav-link">Teachers</a>
                        </c:if>
                            
                        <c:if test="${role == 'Admin'}">
                            <a href="admin.jsp" class="nav-item nav-link">ADMIN</a>
                        </c:if>
                            
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="blog.jsp" class="dropdown-item">Blog Grid</a>
                                <a href="single.jsp" class="dropdown-item">Blog Detail</a>
                            </div>
                        </div>



                    </div>
                    <c:if test="${user1 == null}">
                        <a href="login.jsp" class="btn btn-primary px-5">Login</a>
                    </c:if>
                    <c:if test="${user1 != null}">
                        <div class="nav-item dropdown row">
                            <a class="btn btn-primary px-5 nav-link dropdown-toggle col-12" data-toggle="dropdown" href="#">${u.getFullName()}</a>
                            <div class="dropdown-menu col-10 rounded-bottom ml-3">
                                <a href="ProfileById?idUser=${user1.idUser}" class="dropdown-item">My Profile</a>
                                <a href="logout" class="dropdown-item">Logout</a>
                            </div>
                        </div>
                    </c:if>
                </div>
            </nav>
        </div>
    </header>
    <div style="margin-bottom: 4rem">header</div>

