/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Class.ClassList;
import model.Class.ClassListDB;
import model.tuition.TuitionV2;
import model.tuition.TuitionV2DB;
import validation.Validator;

/**
 *
 * @author ASUS-PRO
 */
public class DecisionRegistClass extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String status = request.getParameter("status");
        String idChild = request.getParameter("id");
        String idTuition = Validator.createID();
        if (status.equals("Accept")) {
            ClassListDB.UpdateStatus(idChild, status);
            ClassList list = ClassListDB.getClassChildByIdChild(idChild, status);

            if (ClassListDB.getTotalSeat(list.getIdClass()) > 0) {
                ClassListDB.UpdateSubTotalSeat(list.getIdClass());
                if (TuitionV2DB.checkTuition(idChild) == true) {
                    ClassList list1 = ClassListDB.getAllChildByIdChild2(idChild);
                    TuitionV2 v1 = TuitionV2DB.getTuition(idChild);
                    TuitionV2DB.addListFeesV2(Validator.createID(), list.getIdClass(), idChild, list1.getTuition(), "No", v1.getIdTuition());
                    TuitionV2DB.UpdateTuition(v1.getIdTuition(), list1.getTuition() + v1.getTuition());
                    response.sendRedirect("class-registration-list");
                } else {
                    ClassList list1 = ClassListDB.getAllChildByIdChild2(idChild);
                    TuitionV2 tuitionV2 = new TuitionV2(idTuition, idChild, list1.getTuition(), list1.getTimeStartSemester(),
                            list1.getTimeStartSemester(), list1.getTimeEndSemester(), "No");
                    TuitionV2DB.addTuitionV2(tuitionV2,idTuition);
                    TuitionV2DB.addListFeesV2(Validator.createID(), list.getIdClass(), idChild, tuitionV2.getTuition(), "No", tuitionV2.getIdTuition());
                    response.sendRedirect("class-registration-list");
                }
            } else {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
        } else if (status.equals("NoAccept")) {
            ClassList list = ClassListDB.getAllChildByIdChild2(idChild);

            if (ClassListDB.delete(list.getIdClass())) {
                response.sendRedirect("class-registration-list");
            } else {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
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
