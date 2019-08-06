import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { LoggedInGuard } from './LoggedInGuard';

export const ROUTER: Routes = [
    { path: '', component: LoginComponent},
    { path: 'job', component: DashboardComponent, canActivate: [LoggedInGuard]},
];
