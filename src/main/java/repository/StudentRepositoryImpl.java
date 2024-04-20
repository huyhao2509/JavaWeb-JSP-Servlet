package repository;

import model.Student;
import util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static final String GET_ALL_STUDENT = "SELECT * FROM student";
    private static final String INSERT_STUDENT = "INSERT INTO student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_STUDENT = "UPDATE student SET studentName = ?, student_birthday = ?, student_status = ?, student_username= ?, student_year_id = ?, student_class_id = ?  where student_code = ? ";
    private static final String FIND_BY_ID = "SELECT * FROM student WHERE student_code = ?";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE student_code = ?";

    @Override
    public int create(Student student) {
        Connection connection = null;
        PreparedStatement  statement= null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_STUDENT);
            statement.setString(1, student.getStudent_code());
            statement.setString(2, student.getStudentName());
            statement.setDate(3, new java.sql.Date(student.getStudent_birthday().getTime()));
            statement.setBoolean(4, student.isStudent_status());
            statement.setString(5, student.getStudent_username());
            statement.setInt(6, student.getStudent_year_id());
            statement.setInt(7, student.getStudent_class_id());
            return statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Student student) {
        try (
                Connection connection = ConnectionDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
        ) {
            preparedStatement.setNString(1, student.getStudentName());
            preparedStatement.setDate(2, new java.sql.Date(student.getStudent_birthday().getTime()));
            preparedStatement.setBoolean(3, student.isStudent_status());
            preparedStatement.setNString(4, student.getStudent_username());
            preparedStatement.setInt(5, student.getStudent_year_id());
            preparedStatement.setInt(6, student.getStudent_class_id());
            preparedStatement.setNString(7, student.getStudent_code());
            return preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String student_code) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_STUDENT);
                statement.setString(1, student_code);
                statement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_STUDENT);
            while(resultSet.next()) {
                String student_code = resultSet.getString("student_code");
                String studentName = resultSet.getNString("studentName");
                Date student_birthday = new Date(resultSet.getDate("student_birthday").getTime());
                boolean student_status = resultSet.getBoolean("student_status");
                String student_username = resultSet.getNString("student_username");
                int student_year_id = Integer.parseInt(resultSet.getString("student_year_id"));
                int student_class_id = Integer.parseInt(resultSet.getString("student_class_id"));
                students.add(new Student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(String student_code) {
        ResultSet resultSet = null;
        Student student = null;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement1 = connection.prepareStatement(FIND_BY_ID);
        ) {
            statement1.setString(1, student_code);
            resultSet = statement1.executeQuery();
            if (resultSet.next()) {
                String studentName = resultSet.getNString("studentName");
                Date student_birthday = new Date(resultSet.getDate("student_birthday").getTime());
                boolean student_status = resultSet.getBoolean("student_status");
                String student_username = resultSet.getNString("student_username");
                int student_year_id = Integer.parseInt(resultSet.getString("student_year_id"));
                int student_class_id = Integer.parseInt(resultSet.getString("student_class_id"));
                student = new Student(student_code, studentName, student_birthday, student_status, student_username, student_year_id, student_class_id);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return student;
    }

}