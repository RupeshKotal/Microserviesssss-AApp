// package com.example.payroll_service.service;

// public class PayrollService {
    
// }


package com.example.payroll.service;

import com.example.payroll.model.Payroll;
import com.example.payroll.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    private final PayrollRepository repository;

    public PayrollService(PayrollRepository repository) {
        this.repository = repository;
    }

    public List<Payroll> getAllPayrolls() {
        return repository.findAll();
    }

    public Optional<Payroll> getPayrollById(Long id) {
        return repository.findById(id);
    }

    public Payroll savePayroll(Payroll payroll) {
        return repository.save(payroll);
    }

    public void deletePayroll(Long id) {
        repository.deleteById(id);
    }
}
