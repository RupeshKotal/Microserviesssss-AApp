// package com.example.department_service.repository;

// public class DepartmentRepository {
    
// }


package com.example.department.repository;

import com.example.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
