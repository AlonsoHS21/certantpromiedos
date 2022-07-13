import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Equipo } from 'src/app/models/Equipo';

@Component({
  selector: 'app-jackpot-form',
  templateUrl: './jackpot-form.component.html',
  styleUrls: ['./jackpot-form.component.scss'],
})
export class JackpotFormComponent implements OnInit {
  equipos: Equipo[] = [
    {
      idEquipo: 1,
      nombre: 'Argentina',
      direccionImagen:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2560px-Flag_of_Argentina.svg.png',
      jugadores: [
        {
          idJugador: 10,
          nombre: 'Paulo',
          apellido: 'Dybala',
          goles: 4,
        },
        {
          idJugador: 9,
          nombre: 'Lionel',
          apellido: 'Messi',
          goles: 10,
        },
      ],
    },
    {
      idEquipo: 2,
      nombre: 'Brasil',
      direccionImagen:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/1060px-Flag_of_Brazil.svg.png',
      jugadores: [
        {
          idJugador: 8,
          nombre: 'Neymar',
          apellido: 'da Silva Santos',
          goles: 4,
        },
        {
          idJugador: 7,
          nombre: 'Vinicius',
          apellido: 'Junior',
          goles: 10,
        },
      ],
    },
    {
      idEquipo: 3,
      nombre: 'Croacia',
      direccionImagen:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/1060px-Flag_of_Brazil.svg.png',
      jugadores: [
        {
          idJugador: 8,
          nombre: 'Luca ',
          apellido: 'Modric',
          goles: 4,
        }
      ],
    },
  ];

  constructor() {}

  jackpotForm: FormGroup = new FormGroup({});
  jugadores: any[] = [];
  playerList(equipo: any) {
    this.jugadores = equipo.jugadores;
  }
  ngOnInit(): void {
    this.jackpotForm = new FormGroup({
      jugador: new FormControl(''),
      equipo: new FormControl(''),
    });
  }
}
