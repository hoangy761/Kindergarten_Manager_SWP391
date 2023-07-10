/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.proposal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User.UsersDB;
import model.proposal.Proposal;
import model.proposal.ProposalDB;

/**
 *
 * @author PC
 */
public class NewProposal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "newProposal.jsp";
    public static final String SUCCESS = "proposal.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String idProposal = UsersDB.createID();
        String idUser = request.getParameter("idUser");
        String title = request.getParameter("title");
        String contentProposal = request.getParameter("contentProposal");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        DateTimeFormatter timeStart = now.format(formatter);

        // hạn vote chỉ 7 ngày 
        LocalDateTime after7Days = now.plusDays(7);
        DateTimeFormatter formatterAfter7 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        DateTimeFormatter timeEnd = after7Days.format(formatterAfter7);

        Proposal pro = new Proposal(idProposal, idUser, title, contentProposal, now, after7Days, 0, "active", 0);

        if (ProposalDB.newProposal(pro)) {
            List<Proposal> listProposal = null;
            listProposal = ProposalDB.getProposalAll();
            request.getSession().setAttribute("listProposal", listProposal);
            
//            request.setAttribute("msq", "Registration success !!!");
            request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);
        } else {
//            request.setAttribute("msq", "Registration Fail !!!");
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
            Logger.getLogger(NewProposal.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewProposal.class.getName()).log(Level.SEVERE, null, ex);
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
