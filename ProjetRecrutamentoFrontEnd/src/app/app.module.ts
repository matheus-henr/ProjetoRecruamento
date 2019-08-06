import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';

import {ROUTER} from './app.router';
import { JobService } from './dashboard/jobService';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/loginService';
import { LoggedInGuard } from './LoggedInGuard';




@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTER),
    HttpClientModule,
  ],
  providers: [LoggedInGuard, JobService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
