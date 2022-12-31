package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentHashMap = new HashMap<>();


    public void createStudent(Student student){
        studentHashMap.put(student.getName(), student);
    }


    public void createTeacher(Teacher teacher) {
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void createStudentTeacherPair(String student, String teacher){
        List<String> studentList = teacherStudentHashMap.getOrDefault(teacher, new ArrayList<String>());
        studentList.add(student);
        teacherStudentHashMap.put(teacher, studentList);
    }

    public void deleteTeacher(String teacher) {
        teacherStudentHashMap.remove(teacher);
        teacherHashMap.remove(teacher);
    }

    public void deleteAllTeachers(){
        teacherStudentHashMap.clear();
        teacherHashMap.clear();
    }

    public Student getStudent(String name) {
        return studentHashMap.get(name);
    }

    public Teacher getTeacher(String name) {
        return teacherHashMap.get(name);
    }

    public List<String> getStudentsList(String teacher) {
        return teacherStudentHashMap.get(teacher);
    }

    public List<String> getAllStudents() {

        return new ArrayList<>(studentHashMap.keySet());
    }
}
