package controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User.Users;
import model.User.UsersDB;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        String email = request.getParameter("email");
        Users user = new Users(email, newPassword);
        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            UsersDB.getNewPassword(newPassword, email);
            user.setPassword(newPassword);
                    request.setAttribute("msq", "Reset Successfully");
                request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            request.setAttribute("msq", "Passwords do not match!!!");
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
        }
    }

}
