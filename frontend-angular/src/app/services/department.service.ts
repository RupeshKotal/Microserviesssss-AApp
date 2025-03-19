import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private apiUrl = environment.apiDepartment;

  constructor(private http: HttpClient) { }

  getDepartments(): Observable<any> {
    return this.http.get(`${this.apiUrl}`);
  }

  createDepartment(department: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, department);
  }

  deleteDepartment(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
