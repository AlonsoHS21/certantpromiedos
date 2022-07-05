import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
})
export class LoginFormComponent implements OnInit {
  userLogin: FormGroup = new FormGroup({});
  
  constructor() {}

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
