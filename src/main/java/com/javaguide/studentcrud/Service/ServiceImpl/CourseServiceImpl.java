package com.javaguide.studentcrud.Service.ServiceImpl;

import com.javaguide.studentcrud.Service.CourseService;
import com.javaguide.studentcrud.model.Course;
import com.javaguide.studentcrud.model.Student;
import com.javaguide.studentcrud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return null;
    }


    public void saveCourse(Course course) {

    }

}
