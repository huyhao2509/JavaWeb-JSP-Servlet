package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "list":
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.findAll();
        HttpSession session = request.getSession();
        String message = (String) session.getAttribute("message");
        session.removeAttribute("message");
        request.setAttribute("message", message);
        request.setAttribute("list", studentList);
        request.getRequestDispatcher("/student/list.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/student/create.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student_code = request.getParameter("student_code");
        studentService.delete(student_code);
        response.sendRedirect(request.getContextPath() + "/student?action=list");
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student_code = request.getParameter("student_code");
        request.setAttribute("student", studentService.findById(student_code));
        request.getRequestDispatcher("/student/update.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int temp1 = studentService.create(getStudentFormView(request));
        String message = temp1 > 0 ? "Create success" : "Create fail";
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect(request.getContextPath() + "/student?action=list");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int temp = studentService.update(getStudentFormView(request));
        String message = temp > 0 ? "Update success" : "Update fail";
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect(request.getContextPath() + "/student?action=list");
    }

    private Student getStudentFormView(HttpServletRequest request) {
        String student_code = request.getParameter("student_code");
        String studentName = request.getParameter("studentName");
        String studentBirthdayAsString = request.getParameter("student_birthday");
        String studentStatusAsString = request.getParameter("student_status");
        String student_username = request.getParameter("student_username");
        int student_year_id = Integer.parseInt(request.getParameter("student_year_id"));
        int student_class_id = Integer.parseInt(request.getParameter("student_class_id"));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date student_birthday = null;
        try {
            student_birthday = format.parse(studentBirthdayAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean student_status = "Đã nộp".equals(studentStatusAsString) ? true : false;
        return new Student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id);
    }
}