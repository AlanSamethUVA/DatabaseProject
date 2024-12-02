package com.project.p6.resource;


import com.project.p6.persistance.Department;
import com.project.p6.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/database")
public class DepartmentResource {

    DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) { this.departmentService = departmentService; }

    @GetMapping(value= "/department")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(value = "/department/{name}")
    public Department getDepartment(@PathVariable String name) {
        return departmentService.getByName(name);
    }
}
