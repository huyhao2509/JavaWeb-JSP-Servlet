package repository;

import model.Student;

import java.util.List;

public interface SchoolRepository {
    List<Student> findAllClass();

    int countStudentName();

    int countStudentNameStatus();

    int price();

    String className();

    String yearName();

    //    List<Student> findAllStudent (int student_clas_id);
    List<Student> findAllStudent ();
}