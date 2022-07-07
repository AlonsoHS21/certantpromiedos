import { Component, OnInit } from '@angular/core';
import { Partido } from 'src/app/models/Partido';

@Component({
  selector: 'app-match-card',
  templateUrl: './match-card.component.html',
  styleUrls: ['./match-card.component.scss'],
})
export class MatchCardComponent implements OnInit {
  partidos: Partido[] = [
    {
      idPartido: 1,
      fasePartido: 'Grupo C',
      equiposPartido: [
        {
          equipo1: {
            idEquipo: 1,
            nombre: 'Argentina',
            direccionImagen:
              'https://i.pinimg.com/736x/84/c9/cb/84c9cb46eb47eb70e09e0f2db5ef67dc--argentina-country-argentina-flag.jpg',
          },
        },
        {
          equipo2: {
            idEquipo: 2,
            nombre: 'Brasil',
            direccionImagen:
              'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png',
          },
        },
      ],
      estadioPartido: 'Ras Abu Aboud',
      fechaPartido: '14/10/2022',
      statusPartido: 'Finalizado',
      resultadoPartido: [{ equipo1Goles: 2 }, { equipo2Goles: 1 }],
    },
    {
      idPartido: 1,
      fasePartido: 'Grupo C',
      equiposPartido: [
        {
          equipo1: {
            idEquipo: 1,
            nombre: 'Argentina',
            direccionImagen:
              'https://i.pinimg.com/736x/84/c9/cb/84c9cb46eb47eb70e09e0f2db5ef67dc--argentina-country-argentina-flag.jpg',
          },
        },
        {
          equipo2: {
            idEquipo: 2,
            nombre: 'Brasil',
            direccionImagen:
              'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png',
          },
        },
      ],
      estadioPartido: 'Ras Abu Aboud',
      fechaPartido: '14/10/2022',
      statusPartido: 'A disputarse',
      resultadoPartido: null,
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
