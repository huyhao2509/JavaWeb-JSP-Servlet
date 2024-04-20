package service;

import model.Student;
import repository.SchoolRepository;
import repository.SchoolRepositoryImpl;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {
    private SchoolRepository schoolRepository = new SchoolRepositoryImpl();


    @Override
    public List<Student> findAllClass() {
        return schoolRepository.findAllClass();
    }

    @Override
    public int countStudentName() {
        return schoolRepository.countStudentName();
    }

    @Override
    public int countStudentNameStatus() {
        return schoolRepository.countStudentNameStatus();
    }

    @Override
    public int price() {
        return schoolRepository.price();
    }

    @Override
    public String className() {
        return schoolRepository.className();
    }

    @Override
    public String yearName() {
        return schoolRepository.yearName();
    }

    @Override
    public List<Student> findAllStudent() {
        return schoolRepository.findAllStudent();
    }

//    @Override
//    public List<Student> findAllStudent(int student_class_id) {
//        return schoolRepository.findAllStudent(student_class_id);
//    }
}
