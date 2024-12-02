package com.project.p6.resource;

import com.project.p6.persistance.Student;
import com.project.p6.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentResource {
    StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "student")
    public List<Student> getAllStudents() {
        return this.studentService.getAll();
    }

    @GetMapping(value = "/student/{id}")
    public Student getById(@PathVariable long id){
        return this.studentService.getById(id);
    }

    @PostMapping(value = "/student/")
    public Student addStudent(Student student) {
        return this.studentService.add(student);
    }

    @PutMapping(value = "/student/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return this.studentService.update(student, id);
    }

    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable long id) {
        this.studentService.delete(id);
    }
}
