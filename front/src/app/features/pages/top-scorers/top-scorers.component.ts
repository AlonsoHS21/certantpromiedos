import { Component, OnInit } from '@angular/core';
import { Jugador } from 'src/app/models/Jugador';

@Component({
  selector: 'app-top-scorers',
  templateUrl: './top-scorers.component.html',
  styleUrls: ['./top-scorers.component.scss'],
})
export class TopScorersComponent implements OnInit {
  displayedColumns = ['posicion', 'equipo','nombre', 'apellido', 'goles'];
  jugadores: Jugador[] = [
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 21,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 11,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 13,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 1,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 3,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 6,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 7,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 14,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 32,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 8,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 4,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
    {
      idJugador: 12,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 10,
      equipo: {
        idEquipo: 1,
        nombre: 'Argentina',
        direccionImagen:
          'https://www.worldatlas.com/r/w768/img/flag/ar-flag.jpg',
      },
    },
  ];
  orderedJugadores: Jugador[] = [];

  constructor() {}

  setData(){
    this.orderedJugadores = this.jugadores.sort((a, b) => {
      return b.goles - a.goles;
    })
  }

  ngOnInit(): void {
    this.setData()
  }
  
}
