import { Component, OnInit } from '@angular/core';
import { AppService } from '../service/app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  templateUrl: './login.component.html',
})
export class LoginComponent {
  credentials = { username: '', password: '' };
  error: any;

  constructor(
    private app: AppService,
    private http: HttpClient,
    private router: Router
  ) {}

  login() {
    this.app.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/');
    });
    return false;
  }
}
