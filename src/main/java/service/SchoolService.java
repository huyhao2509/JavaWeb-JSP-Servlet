package service;

import model.Student;

import java.util.List;

public interface SchoolService {

    int countStudentName();

    int countStudentNameStatus();

    int price();

    String className();

    String yearName();

    List<Student> findAllClass();

    List<Student> findAllStudent ();
}