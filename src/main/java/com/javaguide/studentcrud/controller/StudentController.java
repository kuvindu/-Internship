package com.javaguide.studentcrud.controller;


import com.javaguide.studentcrud.Service.CourseService;
import com.javaguide.studentcrud.Service.StudentService;
import com.javaguide.studentcrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";

    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("courselist", courseService.getAllCourses());
        return "new_student";
    }


    @PostMapping("/saveStudent/")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {

        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
