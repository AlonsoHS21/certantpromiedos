import { Component, OnInit } from '@angular/core';
import { Partido } from 'src/app/models/Partido';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Apuesta } from 'src/app/models/Apuesta';

@Component({
  selector: 'app-match-betting',
  templateUrl: './match-betting.component.html',
  styleUrls: ['./match-betting.component.scss'],
})
export class MatchBettingComponent implements OnInit {
  apuesta: FormGroup = new FormGroup({});



  bet() {
    console.log(this.partido)
  }

  constructor() {}

  ngOnInit(): void {
    this.apuesta = new FormGroup({
      golesEquipo1: new FormControl(0, Validators.required),
      golesEquipo2: new FormControl(0, Validators.required),
    });
  }

  partido: Partido = {
    idPartido: 1,
    fasePartido: 'Grupo C',
    equiposPartido: [
      {
        equipo1: {
          idEquipo: 1,
          nombre: 'Argentina',
          direccionImagen:
            'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2560px-Flag_of_Argentina.svg.png',
        },
      },
      {
        equipo2: {
          idEquipo: 2,
          nombre: 'Brasil',
          direccionImagen:
            'https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png',
        },
      },
    ],
    estadioPartido: 'Ras Abu Aboud',
    fechaPartido: '14/10/2022',
    statusPartido: 'Por Jugar',
    resultadoPartido: null,
  };
}
