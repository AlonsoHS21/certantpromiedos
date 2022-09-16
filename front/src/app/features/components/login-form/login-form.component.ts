import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie';
import { AlertsService } from 'src/app/core/services/alerts.service';
import { LoginService } from 'src/app/core/services/login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
})
export class LoginFormComponent implements OnInit {
  userLogin: FormGroup = new FormGroup({});

  constructor(
    private alert: AlertsService,
    private loginService: LoginService,
    private route: Router,
    private cookieServ: CookieService
  ) {}

  submit() {
    this.loginService.login(this.userLogin.value).subscribe((res) => {
      console.log(this.cookieServ.get('Cookie'));
      if (res.respuesta) {
        this.route.navigate(['home']);
      }
    });
  }

  ngOnInit(): void {
    this.userLogin = new FormGroup({
      username: new FormControl('', [Validators.required]),
      contrasenia: new FormControl('', Validators.required),
    });
  }
}
