package edu.miu.eregistrar.service.impl;

import edu.miu.eregistrar.model.Student;
import edu.miu.eregistrar.repository.StudentRepository;
import edu.miu.eregistrar.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(Student newStudent) {
        getStudentById(newStudent.getStudentId());
        return studentRepository.save(newStudent);
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchStudent(String string) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContaining
                (string,string,string);
    }
}
