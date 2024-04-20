package service;

import model.Student;
import java.util.List;

public interface StudentService {
    int create(Student student);
    int update(Student student);
    int delete(String student_code);
    List<Student> findAll();
    Student findById(String student_code);
}