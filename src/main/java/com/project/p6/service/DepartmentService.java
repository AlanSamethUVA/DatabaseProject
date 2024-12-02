package com.project.p6.service;

import com.project.p6.persistance.Department;
import com.project.p6.persistance.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) { this.departmentRepository = departmentRepository; }

    public List<Department> getAllDepartments() { return departmentRepository.findAll(); }
}
