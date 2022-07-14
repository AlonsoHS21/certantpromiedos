import { Component, OnInit } from '@angular/core';
import { Jackpot } from 'src/app/models/Jackpot';

@Component({
  selector: 'app-jackpot-bet',
  templateUrl: './jackpot-bet.component.html',
  styleUrls: ['./jackpot-bet.component.scss'],
})
export class JackpotBetComponent implements OnInit {
  jackpot: Jackpot = {
    idJackpot: 123,
    idGoleador: 3,
    idCampeon: 5,
  };
  team: any;
  player: any;

  equipos = [
    {
      idEquipo: 5,
      nombre: 'Croacia',
      direccionImagen:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/1280px-Flag_of_Croatia.svg.png',
    },
    {
      idEquipo: 6,
      nombre: 'Argentina',
      direccionImagen:
        'https://static.vecteezy.com/system/resources/thumbnails/002/036/771/small/argentina-national-flag-in-exact-proportions-illustration-vector.jpg',
    },
  ];

  jugadores = [
    {
      idJugador: 3,
      nombre: 'Lionel',
      apellido: 'Messi',
      goles: 8,
    },
    {
      idJugador: 5,
      nombre: 'Neymar',
      apellido: 'Da Silva',
      goles: 4,
    },
    {
      idJugador: 9,
      nombre: 'Harry',
      apellido: 'Kane',
      goles: 3,
    },
  ];

  constructor() {}

  checkBet() {
    this.equipos.map((item) => {
      item.idEquipo === this.jackpot.idCampeon ? (this.team = item) : null;
    });
    this.jugadores.map((item) => {
      item.idJugador === this.jackpot.idGoleador ? (this.player = item) : null;
    });
  }

  ngOnInit(): void {
    this.checkBet();
  }
}
