package edu.miu.eregistrar.controller;

import edu.miu.eregistrar.model.Student;
import edu.miu.eregistrar.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ModelAndView getStudentsList() {
        var model = new ModelAndView();
        model.addObject("students", studentService.getAllStudents());
        model.setViewName("/students/list");
        return model;
    }
    @GetMapping("/add")
    public ModelAndView displayAddForm(){
        var model = new ModelAndView();
        model.addObject("student", new Student());
        model.setViewName("/students/add");
        return model;
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView displayEditForm(@PathVariable Long id){
        var model = new ModelAndView();
        model.addObject("student", studentService.getStudentById(id));
        model.setViewName("/students/edit");
        return model;
    }
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student){
        System.out.println(student);
        studentService.updateStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public ModelAndView searchStudents(@RequestParam String search){
        var matchedStudents = studentService.searchStudent(search);
        var model = new ModelAndView();
        model.addObject("search",search);
        model.addObject("students", matchedStudents);
        model.setViewName("/students/list");
        return model;
    }
}
