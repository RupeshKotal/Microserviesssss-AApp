import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PayrollService {

  private apiUrl = environment.apiPayroll;

  constructor(private http: HttpClient) { }

  getPayrolls(): Observable<any> {
    return this.http.get(`${this.apiUrl}`);
  }

  createPayroll(payroll: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, payroll);
  }

  deletePayroll(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
