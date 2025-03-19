// package com.example.payroll_service.controller;

// public class PayrollController {
    
// }


package com.example.payroll.controller;

import com.example.payroll.model.Payroll;
import com.example.payroll.service.PayrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {

    private final PayrollService service;

    public PayrollController(PayrollService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return service.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        return service.getPayrollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payroll createPayroll(@RequestBody Payroll payroll) {
        return service.savePayroll(payroll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        service.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}
