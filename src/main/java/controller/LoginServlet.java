package controller;

import model.Account;
import repository.LoginRepositoryImpl;
import util.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");


        Account user = null;
        boolean hasError = false;
        String errorString = null;

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Nhập tên đăng nhập và mật khẩu!";
        } else {
            Connection connection = MyUtils.getStoredConnection(request);
            try {
                user = LoginRepositoryImpl.findUser(connection, userName, password);

                if (user == null) {
                    hasError = true;
                    errorString  = "Tên đăng nhập hoặc mật khẩu không đúng!";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        if (hasError) {
            user = new Account();
            user.setUserName(userName);
            user.setPassword(password);
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}