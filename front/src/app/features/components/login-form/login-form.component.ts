import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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
    private route: Router
  ) {}

  submit() {
    this.loginService.login(this.userLogin.value).subscribe({
      error: () => this.alert.errorAlert('Hubo un error en el Logueo'),
      complete: () => {
        this.alert.confirmAlert('Bienvenido!');
        localStorage.setItem('token', this.userLogin.get('email')?.value)
        this.route.navigate(['home']);
      },
    });
  }

  ngOnInit(): void {
    this.userLogin = new FormGroup({
      email: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z]+@certant\.com$/),
      ]),
      password: new FormControl('', Validators.required),
    });
  }
}
