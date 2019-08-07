import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Form, ToastController } from 'ionic-angular';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { JobService } from './jobService';
import { LoginService } from '../home/loginService';
import { Job } from '../../app/Job';

@IonicPage()
@Component({
  selector: 'page-dashboard',
  templateUrl: 'dashboard.html',
  
})
export class DashboardPage {

  jobs: Job[] = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, private fb: FormBuilder, private service: JobService,
    private loginService: LoginService, public toastCtrl: ToastController) {
      this.presentToast('Arraste para a direita')
  }

  ionViewDidLoad() {
    this.findAll();
  }


  findAll() {
    this.service.findALL().subscribe(job => this.jobs = job);
    
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => { 
      this.presentToast("Apagado")
      this.findAll();
    });
  }

  update(job: Job){
    this.navCtrl.push('FormPage',{
      jobValue: job,
      jobs: this.jobs
    });
  }

  openForm(){
    this.navCtrl.push('FormPage',
    {
      jobValue: null,
      jobs: this.jobs
    });
  }

  presentToast(message: string) {
    const toast = this.toastCtrl.create({
      message: message,
      duration: 4000
    });
    toast.present();
  }

}
