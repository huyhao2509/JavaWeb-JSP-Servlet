package repository;

import model.Student;
import util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolRepositoryImpl implements SchoolRepository {
    private static final String GET_ALL_STUDENT =
            "select class_name, year_name, year_price, count(*) as DaNop from class\n" +
                    "join student on student.student_class_id = class.class_id     \n" +
                    "join `year` on `year`.year_id = student.student_year_id\n" +
                    "where student_status = 1 \n" +
                    "group by class_name, year_name, year_price WITH ROLLUP LIMIT 1";

    private static final String GET_CLASS_BY_ID = "select class_name, student_id, student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id, year_id, year_name from class\n" +
            "join student on student.student_class_id = class.class_id\n" +
            "join `year` on student.student_year_id = `year`.year_id\n" +
            "where student_class_id = '1'";

    @Override
    public List<Student> findAllClass() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_STUDENT);
            while (resultSet.next()) {
//                int student_id = resultSet.getInt("student_id");
//                String student_code = resultSet.getString("student_code");
//                String studentName = resultSet.getString("studentName");
//                java.util.Date student_birthday = new java.util.Date(resultSet.getDate("student_birthday").getTime());
//                boolean student_status = resultSet.getBoolean("student_status");
//                String student_username = resultSet.getString("student_username");
//                int student_year_id = resultSet.getInt("student_year_id");
//                int student_class_id = resultSet.getInt("student_class_id");
//                String year_name = resultSet.getString("year_name");
//                Double year_price = resultSet.getDouble("year_price");
//                String class_name = resultSet.getString("class_name");
//                students.add(new Student(student_id, student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id, year_name, year_price, class_name));
//                students.add(new Student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id, year_name, year_price, class_name));
                String class_name = resultSet.getString("class_name");
//                String studentName = resultSet.getString("studentName");
                String year_name = resultSet.getString("year_name");
                Double year_price = resultSet.getDouble("year_price");
                students.add(new Student(class_name, year_name, year_price));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return students;
    }

    @Override
    public int countStudentName() {
        String sql = "select count(*) from student\n" +
                "join class on student.student_class_id = class.class_id     \n" +
                "join `year` on `year`.year_id = student.student_year_id\n" +
                "where student_status = 1";
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int countStudentNameStatus() {
        String sql = "select count(*) from student\n" +
                "join class on student.student_class_id = class.class_id     \n" +
                "join `year` on `year`.year_id = student.student_year_id";
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


    @Override
    public int price() {
        String sql = "select year.year_price from `year`";
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public String className() {
        String sql = "select class_name from class";
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }

    @Override
    public String yearName() {
        String sql = "select year_name from year";
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }

    @Override
    public List<Student> findAllStudent() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_CLASS_BY_ID);
            while (resultSet.next()) {
//                int student_id = resultSet.getInt("student_id");
                String student_code = resultSet.getString("student_code");
                String studentName = resultSet.getString("studentName");
                java.util.Date student_birthday = new java.util.Date(resultSet.getDate("student_birthday").getTime());
                boolean student_status = resultSet.getBoolean("student_status");
                String student_username = resultSet.getString("student_username");
                int student_year_id = resultSet.getInt("student_year_id");
                int student_class_id = resultSet.getInt("student_class_id");
                String year_name = resultSet.getString("year_name");
//                Double year_price = resultSet.getDouble("year_price");
                String class_name = resultSet.getString("class_name");
                students.add(new Student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id, year_name, class_name));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return students;
    }

//    @Override
//    public List<Student> findAllStudent(int student_class_id) {
//        ResultSet resultSet = null;
//        Student student = null;
//        try (Connection connection = ConnectionDB.getConnection();
//             PreparedStatement statement = connection.prepareStatement(GET_CLASS_BY_ID);)
//        {
//            statement.setInt(1, student_class_id);
//            resultSet = statement.executeQuery();
//            if(resultSet.next()) {
////                int student_id = resultSet.getInt("student_id");
//                String student_code = resultSet.getString("student_code");
//                String studentName = resultSet.getString("studentName");
//                java.util.Date student_birthday = new java.util.Date(resultSet.getDate("student_birthday").getTime());
//                boolean student_status = resultSet.getBoolean("student_status");
//                String student_username = resultSet.getString("student_username");
//                int student_year_id = resultSet.getInt("student_year_id");
//                String year_name = resultSet.getString("year_name");
//                Double year_price = resultSet.getDouble("year_price");
//                String class_name = resultSet.getString("class_name");
//                student = new Student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id, year_name, year_price, class_name);
//            }
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return student;
//    }


}