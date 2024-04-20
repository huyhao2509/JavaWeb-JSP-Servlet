package service;

import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository = new StudentRepositoryImpl();


    @Override
    public int create(Student student) {
        return studentRepository.create(student);
    }

    @Override
    public int update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public int delete(String student_code) {
        return studentRepository.delete(student_code);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String student_code) {
        return studentRepository.findById(student_code);
    }

}