package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public void addStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.createTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.createStudentTeacherPair(student, teacher);
    }

    public void deleteTeacher(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }

    public Student getStudent(String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name) {
        return studentRepository.getTeacher(name);
    }

    public List<String> getStudentsList(String teacher) {
        return studentRepository.getStudentsList(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
