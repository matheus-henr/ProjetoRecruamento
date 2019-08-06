import { Injectable } from '@angular/core';
import {HttpClient, HttpXsrfTokenExtractor, HttpHeaders} from '@angular/common/http';
import { Job } from '../Job';
import { Observable } from 'rxjs';
import {API} from '../API';
import { LoginService } from '../login/loginService';


@Injectable()
export class JobService {

    constructor(private http: HttpClient, private service: LoginService) {}

     httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': this.service.getToken()
      })
    };

    public save(job: Job): Observable<Job> {
      return  this.http.post<Job>(API.urlJob, job, this.httpOptions);
    }
    public update(job: Job): Observable<Job> {
        return  this.http.put<Job>(API.urlJob, job, this.httpOptions);
      }
    public delete(id: number) {
       return  this.http.delete(`${API.urlJob}/${id}`, this.httpOptions);
    }

    public findALL(): Observable<Job[]> {
        return this.http.get<Job[]>(API.urlJob, this.httpOptions);
    }
}