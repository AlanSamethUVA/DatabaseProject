package com.project.p6.resource;

import com.project.p6.persistance.Enroll;
import com.project.p6.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/database")
public class EnrollResource {
    private final EnrollService enrollService;

    public EnrollResource(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @GetMapping(value = "/enroll")
    public List<Enroll> getAllEnrollments() {
        return this.enrollService.getAll();
    }

    @GetMapping(value = "/enroll/student/{studentId}")
    public List<Enroll> getByStudentId(@PathVariable long studentId) {
        return this.enrollService.getByStudentId(studentId);
    }

    @GetMapping(value = "/enroll/course/{courseId}")
    public List<Enroll> getByCourseId(@PathVariable long courseId) {
        return this.enrollService.getByCourseId(courseId);
    }

    @GetMapping(value = "/enroll/semester/{semester}")
    public List<Enroll> getBySemester(@PathVariable String semester) {
        return this.enrollService.getBySemester(semester);
    }

    @PostMapping(value = "/enroll")
    public Enroll addEnrollment(@RequestBody Enroll enroll) {
        return this.enrollService.add(enroll);
    }

    @DeleteMapping(value = "/enroll/{id}")
    public void deleteEnrollment(@PathVariable long id) {
        this.enrollService.delete(id);
    }
}