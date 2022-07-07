import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.scss'],
})
export class RankingComponent implements OnInit {
  displayedColumns = ['nombre', 'apellido', 'puntos'];
  usuarios: Usuario[] = [
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 23,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 25,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 2,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 45,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 78,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 45,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 23,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 12,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 56,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 89,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 78,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 45,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 765,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 13,
    },
    {
      id: 1,
      email: 'yo@certant.com',
      nombre: 'Franco',
      apellido: 'Osores',
      puntos: 45,
    },
  ];

  orderedUsers: Usuario[] = [];

  constructor() {}

  ngOnInit(): void {
    this.orderedUsers = this.usuarios.sort((a, b) => {
      return b.puntos - a.puntos
    });
  }
}
