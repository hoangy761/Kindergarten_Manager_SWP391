/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.updateProfile;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User.Users;
import model.User.UsersDB;
import org.apache.catalina.User;
import validation.Validator;

/**
 *
 * @author PC
 */
public class UpdateProfileParent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "profileParent_Edit.jsp";
    public static final String SUCCESS = "profileParent.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idUser = request.getParameter("idUser");

        try {
            String name = Validator.upCassName(request.getParameter("fullName"));
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = Validator.upCassName(request.getParameter("address"));
// Users( idUser,fullName,address,email, password, idChild, certicate, imgAvt, role,  gender, dob, phoneNumber) 
            Users s = (Users) (request.getSession().getAttribute("USER"));
            Users user = new Users(idUser, name, address, email, s.getPassword(), s.getIdChild(), s.getCerticate(), s.getImgAvt(), s.getRole(), gender, dob, phoneNumber);
            if (UsersDB.updateProfile(user)) {
                request.getSession().setAttribute("USER", user);
                request.setAttribute("userRequest", user);
                request.setAttribute("msq", "Update Success!!!");
                request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);

            } else {
//            request.setAttribute("email1", acc);
                request.setAttribute("msq", "Update fail!!!");
                request.getRequestDispatcher(ERROR).forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msq", "Update fail!!!");
            request.getRequestDispatcher(ERROR).forward(request, response);
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
