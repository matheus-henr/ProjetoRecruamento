import { Injectable } from '@angular/core';
import { CanLoad, CanActivate, Route } from '@angular/router';
import { LoginService } from './login/loginService';

@Injectable()
export class LoggedInGuard implements CanActivate {

     constructor(private service: LoginService) { }

     canActivate(): boolean {
        const loggedIn = this.service.isLoggedIn();

        if (!loggedIn) {
            this.service.handleLogin();
        }
        return loggedIn;
    }

}
