package controller;

import model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.SchoolService;
import service.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/school")
public class SchoolServlet extends HttpServlet {
    private SchoolService schoolService = new SchoolServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "list";
        }
        switch (action) {
            case "view":
                viewClass(request, response);
                break;
            case "export":
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename = studentList.xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("students");
                List<Student> students = this.schoolService.findAllStudent();
                int rowNo = 0;
                Row row = sheet.createRow(rowNo++);
                int cellnum = 0;
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue("Ma sinh vien");

                cell = row.createCell(cellnum++);
                cell.setCellValue("Ten sinh vien");

                cell = row.createCell(cellnum++);
                cell.setCellValue("Ngay sinh");

                cell = row.createCell(cellnum++);
                cell.setCellValue("Trang thai");

                for(Student student : students) {
                    cellnum = 0;
                    row = sheet.createRow(rowNo++);

                    cell = row.createCell(cellnum++);
                    cell.setCellValue(student.getStudent_code());


                    cell = row.createCell(cellnum++);
                    cell.setCellValue(student.getStudentName());

                    cell = row.createCell(cellnum++);
                    cell.setCellValue(student.getStudentBirthdayAsString());

                    cell = row.createCell(cellnum++);
                    cell.setCellValue(student.isStudent_status());
                }
                wb.write(response.getOutputStream());
                wb.close();
                return;

            case "list":
            default:
                listStudent(request, response);
        }
    }

    private void viewClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int class_id = Integer.parseInt(request.getParameter("class_id"));
        List<Student> students = this.schoolService.findAllStudent();
        int countStudentName = schoolService.countStudentName();
        int moneyPaid = schoolService.countStudentName();
        int totalMoney = schoolService.countStudentName();
        int price = schoolService.price();
        int countStudentNameStatus = schoolService.countStudentNameStatus();
        String yearName = schoolService.yearName();
        String className = schoolService.className();
        request.setAttribute("countStudentName", countStudentName);
        request.setAttribute("moneyPaid", moneyPaid);
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("price", price);
        request.setAttribute("countStudentNameStatus", countStudentNameStatus);
        request.setAttribute("yearName", yearName);
        request.setAttribute("className", className);
        request.setAttribute("students", students);
        request.getRequestDispatcher("/school/studentList.jsp").forward(request, response);
    }


    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = this.schoolService.findAllClass();
        int countStudentName = schoolService.countStudentName();
        int price = schoolService.price();
        request.setAttribute("price", price);
        request.setAttribute("countStudentName", countStudentName);
        request.setAttribute("students", students);
        request.getRequestDispatcher("/school/classList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}