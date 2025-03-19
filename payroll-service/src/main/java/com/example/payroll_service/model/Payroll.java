// package com.example.payroll_service.model;

// public class Payroll {
    
// }


package com.example.payroll.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Double salary;
    private String payPeriod;
}
