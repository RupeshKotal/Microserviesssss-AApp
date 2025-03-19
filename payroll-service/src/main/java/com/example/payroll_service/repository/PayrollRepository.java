// package com.example.payroll_service.repository;

// public class PayrollRepository {
    
// }


package com.example.payroll.repository;

import com.example.payroll.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
