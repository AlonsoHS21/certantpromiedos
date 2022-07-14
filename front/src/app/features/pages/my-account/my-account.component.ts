import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.scss'],
})
export class MyAccountComponent implements OnInit {
  passwordChange: FormGroup = new FormGroup({});

  changePassword() {
    let var1 = this.passwordChange.get('password')?.value;
    let var2 = this.passwordChange.get('password1')?.value;

    var1 === var2
      ? //PASSWORDS MATCH
        Swal.fire({
          text: '¿Estás seguro de cambiar tu contraseña?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Si, cambiar',
          cancelButtonText: 'No',
          customClass: 'swal-wide',
          backdrop: false,
        }).then((result) => {
          if (result.isConfirmed) {
            Swal.fire({
              text: 'Tu contraseña ha sido cambiada, debes volver a ingresar',
              icon: 'success',
              customClass: 'swal-wide',
            });
            localStorage.clear();
            this.router.navigate(['login']);
          }
        })
      : //PASSWORDS DONT MATCH
        Swal.fire({
          text: 'El password no coincide verificalo e intentalo de nuevo',
          icon: 'error',
          customClass: 'swal-wide',
          backdrop: false,
        });
  }

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.passwordChange = new FormGroup({
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
      password1: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }
}
