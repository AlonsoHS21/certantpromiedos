import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import {
  FormControl,
  FormGroup,
  Validators,
  FormBuilder,
} from '@angular/forms';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.scss'],
})
export class MyAccountComponent implements OnInit {
  passwordChange: FormGroup = new FormGroup({});

  changePassword() {
    Swal.fire({
      text: '¿Estás seguro de cambiar tu contraseña?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, cambiar',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire('Cambio Realizado', 'Tu contraseña ha sido cambiada', 'success');
      }
    });
  }

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.passwordChange = new FormGroup({
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }
}
