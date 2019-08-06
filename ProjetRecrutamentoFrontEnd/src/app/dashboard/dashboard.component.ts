import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { Job } from '../Job';
import { Task } from '../Task';
import { JobService } from './jobService';
import { LoginService } from '../login/loginService';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  form: FormGroup;
  formHiden: boolean;
  job: Job;
  task: Task[] = [];
  jobs: Job[] = [];
  messagenHidden: boolean;

  constructor(private fb: FormBuilder, private service: JobService,
              private loginService: LoginService) { }

  ngOnInit() {
    this.findAll();
    this.formHiden = true;
    this.form = this.fb.group({
      id: [null],
      name: ['', [Validators.required]],
      parentJob: [null],
      active: [false],
      task: this.fb.group({
        name: [''],
        weight: ['', Validators.min(0)],
        completed: [false],
        createdAt: []
      })
    });
  }

  save() {
    this.newJob();
    if (this.job.id === undefined || this.job.id === null) {
      this.service.save(this.job).subscribe(() => this.messagenHidden = true);
    } else {
      this.service.update(this.job).subscribe(() => this.messagenHidden = true);
    }
    this.reset();
  }

  findAll() {
    this.service.findALL().subscribe(job => this.jobs = job);
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => {
      alert('Removed');
      this.findAll();
    });
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
    this.openForm();
  }

  addTask() {
    this.task.push(this.form.value.task);
    this.form.get('task').reset();
  }

  public openForm() {
    this.formHiden = false;
  }

  public closeForm() {
    this.formHiden = true;
    this.messagenHidden = false;
    this.findAll();
    this.reset();
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

  private reset() {
    this.task = [];
    this.form.reset();
    this.job = null;
  }

  public logout() {
    this.loginService.logout();
  }

}
