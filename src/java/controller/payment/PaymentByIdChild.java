/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.payment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Class.ClassList;
import model.Class.ClassListDB;
import model.child.Child;
import model.child.ChildDB;
import model.listfee.ListFeesV2;
import model.listfee.ListFeesV2DB;
import model.skillList.SkillList;
import model.skillList.SkillListDB;
import model.tuition.TuitionV2;
import model.tuition.TuitionV2DB;

/**
 *
 * @author PC
 */
public class PaymentByIdChild extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String SUCCESS = "TuitionPaymentChild.jsp";
    public static final String ERORR = "TuitionPaymentChild.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idChild = request.getParameter("idChild");

        Child childRequest = null;

        childRequest = ChildDB.getChildbyIdChild(idChild);

//        ClassList classList = ClassListDB.getClassChildByIdChild(idChild, "Accept");
        TuitionV2 tuition = TuitionV2DB.getTuitionByIdChild(idChild, "No");
        
        
        ClassList childClass = ClassListDB.getClassChildByIdChild(idChild, "Accept");
        
        List<ListFeesV2> listFees = ListFeesV2DB.getListFeeV2ByIdChildStatus(idChild, "No");
         
        
        List<ClassList> listClass = ClassListDB.getAllClassAnalys();
        List<SkillList> listSkill = SkillListDB.getAllSkilAnalys();
        
        
        request.setAttribute("childRequest", childRequest);
        request.setAttribute("tuition", tuition);
        request.setAttribute("childClass", childClass);
        
        request.setAttribute("listFees", listFees);
        request.setAttribute("listClass", listClass);
        request.setAttribute("listSkill", listSkill);
        
        
        
        request.getRequestDispatcher(response.encodeURL(SUCCESS)).forward(request, response);

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
