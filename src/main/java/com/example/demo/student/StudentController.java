package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    // has all of the resources for our API
    // Actually , client sends HTTP request to this layer, It means that this layer catches the Http requests which sent by client
    // and it maps that request and handles it. Finally, it calls the service logic if required,

    private final StudentService studentService;
    // reference of service layer to use its all methods and properties

    @Autowired
    // Autowired performs Dependency Injection for constructor of this class , it can take place in setter method too.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        // Injected the "StudentService" class to constructor of StudentController( Dependency Injection )
    }

    @GetMapping // it's used instead of using : @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") // http://localhost:8080/api/v1/student/"studentId"
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}") //localhost:8080/api/v1/student/1?name=tunc&email=new-email@gmail.com
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            /**
             * PathVariable annotation catches variable that given by client from URL (like ActivatedRoute interface in Angular)
             */
            // name and email is not required
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
