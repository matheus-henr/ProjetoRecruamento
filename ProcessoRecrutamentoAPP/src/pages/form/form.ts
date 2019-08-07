import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController } from 'ionic-angular';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { Job } from '../../app/Job';
import { Task } from '../../app/Task';
import { JobService } from '../dashboard/jobService';



@IonicPage()
@Component({
  selector: 'page-form',
  templateUrl: 'form.html',
})
export class FormPage {

  form: FormGroup;
  job: Job;
  task: Task[] = [];
  jobs: Job[] = [];

  constructor(public navCtrl: NavController, public navParams: NavParams,private fb: FormBuilder,
     private service: JobService, public toastCtrl: ToastController) {
      this.form = this.fb.group({
        id: [null],
        name: ['', [Validators.required]],
        parentJob: [null],
        active: [],
        task: this.fb.group({
          name: [''],
          weight: ['', Validators.min(0)],
          completed: [],
          createdAt: []
        })
      }); 
     this.jobs = navParams.get('jobs');
    
     let job = navParams.get('jobValue');
     if(job!== null){
       this.update(job)
     }
     
  }

  ionViewDidLoad() {

  }

  save() {
    this.newJob();
    if (this.job.id === undefined || this.job.id === null) {
      this.service.save(this.job).subscribe(() => {
        this.presentToast("Salvo com sucesso")
      });
    } else {
      this.service.update(this.job).subscribe(() => {
        this.presentToast("Editado")
      });
    }
    this.reset();
  }

  addTask() {
    this.task.push(this.form.value.task);
    this.form.get('task').reset();
  }
  
  private newJob() {
    this.job = new Job();
    this.job.id = this.form.value.id;
    this.job.name = this.form.value.name;
    this.job.active = this.form.value.active;
    this.job.tasks = this.task;

    if (this.form.value.parentJob === null) {
      this.job.parentJob = null;
    } else {
      this.job.parentJob.id = this.form.value.parentJob;
    }
  }

  update(job: Job) {
    this.form.patchValue({
      id: job.id,
      name: job.name,
      parentJob: null,
      active: job.active,
      task: this.form.get('task')
    });

    if (job.parentJob !== null) {
      this.form.get('parentJob').patchValue(job.parentJob.id);
    }
  
  }

  private reset() {
    this.task = [];
    this.form.reset();
    this.job = null;
  }


  presentToast(message: string) {
    const toast = this.toastCtrl.create({
      message: message,
      duration: 4000
    });
    toast.present();
  }

}
