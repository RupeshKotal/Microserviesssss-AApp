import { Component, OnInit } from '@angular/core';
import { PayrollService } from '../../services/payroll.service';

@Component({
  selector: 'app-payroll',
  templateUrl: './payroll.component.html',
  styleUrls: ['./payroll.component.css']
})
export class PayrollComponent implements OnInit {

  payrolls: any[] = [];

  constructor(private payrollService: PayrollService) { }

  ngOnInit(): void {
    this.getPayrolls();
  }

  getPayrolls(): void {
    this.payrollService.getPayrolls().subscribe(data => {
      this.payrolls = data;
    });
  }
}
