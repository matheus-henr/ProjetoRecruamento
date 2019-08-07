import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API } from '../../app/API';


@Injectable()
export class LoginService {

    private token: string;

    constructor(private http: HttpClient) { }

    public login(userLogin: string, passwordLogin: string) {
        return this.http.post<any>(`${API.urlLogin}`,
            { user: userLogin, password: passwordLogin },
            {
                observe: 'response',
                responseType: 'text' as 'json'
            }
        );
    }

    public getToken(): string {
        this.token = sessionStorage.getItem('token');
        return this.token;
    }


    public isLoggedIn(): boolean {
        return this.getToken() !== null;
    }

}
