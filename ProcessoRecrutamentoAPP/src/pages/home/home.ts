import { Component } from '@angular/core';
import { NavController, ToastController } from 'ionic-angular';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { LoginService } from './loginService';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  
  
})
export class HomePage {

  form: FormGroup;

  constructor(public navCtrl: NavController,private fb: FormBuilder, private service: LoginService,
       public toastCtrl: ToastController) {
      this.form = this.fb.group({
      user: ['', Validators.required],
      password: ['', Validators.required]
    });
  }


  sing(){
    this.service.login(this.form.value.user, this.form.value.password)
    .subscribe(resp => {
        sessionStorage.setItem('token', resp.body);
        this.presentToast('Bem vindo');
        this.navCtrl.push('DashboardPage')
    }, error => {
      this.presentToast('Senha ou usuario incorreto');
      console.error(error);
    });
  }

  presentToast(message: string) {
    const toast = this.toastCtrl.create({
      message: message,
      duration: 3000
    });
    toast.present();
  }
}
