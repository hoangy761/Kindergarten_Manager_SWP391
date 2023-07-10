/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.updateProfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.child.Child;
import model.User.Users;
import model.child.ChildDB;
import model.User.UsersDB;
import validation.Validator;

/**
 *
 * @author PC
 */
public class AddNewChild extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "newChild.jsp";
    public static final String SUCCESS = "profileChild.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String fullname = Validator.upCassName(request.getParameter("fullName"));
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String idUser = request.getParameter("idUser");
        String idChild = UsersDB.createID();

        Child child = new Child(idChild, fullname, idUser, dob, gender, "NULL", 0, 0, "NULL", "NULL","NULL");
        Users s = (Users) (request.getSession().getAttribute("USER"));

        if (ChildDB.newChild(child)) {
            List<Child> listChild = null;
            listChild = ChildDB.getChildbyIdParent(s.getIdUser());

            Users userRequest = null;
            userRequest = UsersDB.getUserById(idUser);
            request.getSession().setAttribute("listChild", listChild);
            request.setAttribute("userRequest", userRequest);
            request.setAttribute("childRequest", child);
            request.setAttribute("msq", "Registration success !!!");
            request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);
        } else {
            request.setAttribute("msq", "Registration Fail !!!");
            request.getRequestDispatcher(response.encodeURL(ERROR)).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddNewChild.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddNewChild.class.getName()).log(Level.SEVERE, null, ex);
        }
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
