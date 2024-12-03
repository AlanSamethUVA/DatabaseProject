package com.project.p6.resource;

import com.project.p6.persistance.Course;
import com.project.p6.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/database")
public class CourseResource {

    CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "/courses")
    public List<Course> getAllCourses() {
        return this.courseService.getAll();
    }

    @GetMapping(value = "/courses/{semester}")
    public List<Course> getCoursesBySemester(@PathVariable String semester) { return this.courseService.getBySemester(semester);}

    @GetMapping(value = "/courses/{id}")
    public Course getById(@PathVariable long id){
        return this.courseService.getById(id);
    }

    @PostMapping(value = "/courses")
    public Course addStudent(Course course) {
        return this.courseService.add(course);
    }

    @PostMapping(value = "/courses/{semester}")
    public Course addCourse(@PathVariable String semester) {
        Course course = new Course();
        course.setSemester(semester);
        return this.courseService.add(course);
    }

    @PutMapping(value = "/courses/{id}")
    public Course updateCourse(@PathVariable long id, @RequestBody Course course) {
        return this.courseService.update(course, id);
    }

    @DeleteMapping(value = "/courses/{course_id}")
    public void deleteCourse(@PathVariable long id) {
        this.courseService.delete(id);
    }

}
