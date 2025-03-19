// package com.example.department_service.service;

// public class DepartmentService {
    
// }


package com.example.department.service;

import com.example.department.model.Department;
import com.example.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return repository.findById(id);
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
}
