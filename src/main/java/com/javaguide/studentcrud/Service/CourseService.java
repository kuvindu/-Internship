package com.javaguide.studentcrud.Service;

import com.javaguide.studentcrud.model.Course;
import com.javaguide.studentcrud.model.Student;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Student getStudentById(long id);

    void saveCourse(Course course);

}
