/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.proposal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User.UserVote;
import model.User.UserVoteDB;
import model.User.UsersDB;
import model.proposal.Proposal;
import model.proposal.ProposalDB;

/**
 *
 * @author PC
 */
public class VoteProposal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "proposalView.jsp";
    public static final String SUCCESS = "proposalView.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String idVote = UsersDB.createID();
        String idUser = request.getParameter("idUser");
        int vote = Integer.parseInt(request.getParameter("vote"));
        String idProposal = request.getParameter("idProposal");

        LocalDateTime dateVote = LocalDateTime.now();

        UserVote userVote = new UserVote(idVote, idUser, vote, dateVote, idProposal);

        Proposal proIdProposal = null;

        //Check idUser and idProposal co trong bang khong?
        if (UserVoteDB.checkVoted(idUser, idProposal) == null) {
            if (UserVoteDB.voteProposal(userVote)) {

                if (ProposalDB.setCountAcceptVote(userVote)) {
                    proIdProposal = ProposalDB.getProposalById(idProposal);
                    request.setAttribute("proIdProposal", proIdProposal);
                    request.setAttribute("msq", "Vote Success");
                    request.setAttribute("text-color", "text-success");

                    request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);
                } else {
                    proIdProposal = ProposalDB.getProposalById(idProposal);
                    request.setAttribute("proIdProposal", proIdProposal);
                    request.setAttribute("msq", "Vote Fail");
                    request.setAttribute("text-color", "text-danger");
                    request.getRequestDispatcher(response.encodeURL(ERROR)).forward(request, response);
                }

            } else {
                proIdProposal = ProposalDB.getProposalById(idProposal);
                request.setAttribute("proIdProposal", proIdProposal);
                request.setAttribute("msq", "Vote Fail");
                request.setAttribute("text-color", "text-danger");
                request.getRequestDispatcher(response.encodeURL(ERROR)).forward(request, response);
            }
        } else {
            proIdProposal = ProposalDB.getProposalById(idProposal);
            request.setAttribute("proIdProposal", proIdProposal);
            request.setAttribute("msq", "Vote Fail");
            request.setAttribute("text-color", "text-danger");
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
            Logger.getLogger(VoteProposal.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VoteProposal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
