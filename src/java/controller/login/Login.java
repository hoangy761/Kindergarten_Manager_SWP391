/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.login;

import java.io.IOException;
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
import model.proposal.Proposal;
import model.proposal.ProposalDB;
import static model.proposal.ProposalDB.checkTimeEnd;

/**
 *
 * @author ASUS-PRO
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "login.jsp";
    public static final String SUCCESS = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String acc = request.getParameter("acc");
        String password = request.getParameter("password");
        Users user = null;

        if (acc != null && password != null && acc != "" && password != "" && !password.matches("^[\\s]+$") && !acc.matches("^[\\s]+$")) {
            user = UsersDB.checkLogin(acc, password);
            if (user != null) {
                List<Child> listChild = null;
                listChild = ChildDB.getChildbyIdParent(user.getIdUser());

                

                request.getSession().setAttribute("listChild", listChild);
                
                request.getSession().setAttribute("USER", user);
                request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);
            } else {
//                request.setAttribute("email1", acc);
                request.setAttribute("msq", "Incorrect phone number, email or password");
                request.getRequestDispatcher(ERROR).forward(request, response);
            }
        } else {
//            request.setAttribute("email1", acc);
            request.setAttribute("msq", "Incorrect phone number, email or password");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
