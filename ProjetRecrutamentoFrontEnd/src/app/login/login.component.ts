import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from './loginService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder, private service: LoginService, private router: Router) {
    this.form = this.fb.group({
      user: ['', Validators.required],
      password: ['', Validators.required]
    });
   }

  ngOnInit() {
  }
login() {
  this.service.login(this.form.value.user, this.form.value.password)
    .subscribe(resp => {
        sessionStorage.setItem('token', resp.body);
        this.router.navigate(['/job']);
    }, error => {
      alert('Senha ou usuario incorreto');
      console.error(error);
    });
  }
}
