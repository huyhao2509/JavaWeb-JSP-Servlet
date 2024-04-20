package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    int create(Student student);
    int update(Student student);
    int delete(String student_code);
    List<Student> findAll();
    Student findById(String student_code);
}