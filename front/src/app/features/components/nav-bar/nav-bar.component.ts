import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss'],
})
export class NavBarComponent implements OnInit {
  logout() {
    Swal.fire({
      text: '¿Quieres Salir?',
      showCancelButton: true,
      customClass: 'swal-wide',
      confirmButtonText: 'Salir',
      cancelButtonText: 'Cancelar',
      backdrop: false
    }).then((result) => {
      if (result.isConfirmed) {
        localStorage.clear();
        this.router.navigate(['login'])
        Swal.fire({
          text: 'Hasta Luego!',
          timer: 1500
        })
      }
    });
  }

  constructor(private router: Router) {}

  ngOnInit(): void {}
}
