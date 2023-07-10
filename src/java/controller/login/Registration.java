/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User.Users;
import model.User.UsersDB;
import validation.Validator;

/**
 *
 * @author ASUS-PRO
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "registration.jsp";
    public static final String SUCCESS = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        response.setContentType("text/html;charset=UTF-8");
        String fullname = Validator.upCassName(request.getParameter("fullName"));
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        String address = request.getParameter("address");
        String address = Validator.upCassName(request.getParameter("address"));
        String Cpassword = request.getParameter("repeatPassword");
        
        Users us = new Users("", fullname, address, email, password, "", "", "", "", gender, dob, phone);
        request.setAttribute("UserWrong", us);
        if (!(password != null && Cpassword != null && password.equals(Cpassword))) {
            request.setAttribute("msq", "Create failed");
            request.getRequestDispatcher(response.encodeURL(ERROR)).forward(request, response);
        } else {
            if (email == null || email.isEmpty()) {
                Users u = new Users();
                u.setIdUser(UsersDB.createID());
                u.setFullName(fullname);
                u.setDob(dob);
                u.setAddress(address);
                u.setGender(gender);
                u.setPhoneNumber(phone);
                u.setEmail("NULL");
                u.setPassword(password);
                u.setRole("Parent");
                u.setCerticate("NULL");
                u.setIdChild("NULL");
                u.setImgAvt("NULL");
                UsersDB.registration(u);
                request.setAttribute("msq", "Registration success");
                request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);
            } else {
                if (UsersDB.checkEmail(email, phone) == true) {
                    request.setAttribute("msq", "Email or PhoneNumber already exists");
                    request.getRequestDispatcher(response.encodeURL(ERROR)).forward(request, response);
                } else {
                    Users u = new Users();
                    u.setIdUser(UsersDB.createID());
                    u.setFullName(fullname);
                    u.setDob(dob);
                    u.setAddress(address);
                    u.setGender(gender);
                    u.setPhoneNumber(phone);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setRole("Parent");
                    u.setCerticate("NULL");
                    u.setIdChild("NULL");
                    u.setImgAvt("NULL");
                    UsersDB.registration(u);
                    request.setAttribute("msq", "Registration success");
                    request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
