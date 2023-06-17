package edu.miu.eregistrar.service;

import edu.miu.eregistrar.model.Student;


import java.util.List;

public interface StudentService {

    Student saveStudent(Student newStudent);

    Student updateStudent(Student newStudent);

    void deleteById(Long studentId);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    List<Student> searchStudent(String string);
}
