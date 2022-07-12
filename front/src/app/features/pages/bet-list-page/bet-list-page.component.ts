import { Component, OnInit } from '@angular/core';
import { Apuesta } from 'src/app/models/Apuesta';

@Component({
  selector: 'app-bet-list-page',
  templateUrl: './bet-list-page.component.html',
  styleUrls: ['./bet-list-page.component.scss']
})
export class BetListPageComponent implements OnInit {
  apuestas:Apuesta[] = [
    {
      apuestaId: 1,
      golesEquipo1: 2,
      golesEquipo2: 3,
      partido: {
        idPartido: 3,
        fasePartido: 'Grupo C',
        equiposPartido: [
          {
            equipo1: {
              idEquipo: 1,
              nombre: 'Argentina',
              direccionImagen:
                'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/640px-Flag_of_Argentina.svg.png',
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
        estadioPartido: 'Al-Bayt Stadium',
        fechaPartido: '12/10/2022',
        statusPartido: 'Finalizado',
        resultadoPartido: {
          golesEquipo1: 3,
          golesEquipo2: 2,
          result: 'equipo1',
        },
      },
    },
    {
      apuestaId: 2,
      golesEquipo1: 0,
      golesEquipo2: 3,
      partido: {
        idPartido: 3,
        fasePartido: 'Grupo C',
        equiposPartido: [
          {
            equipo1: {
              idEquipo: 1,
              nombre: 'Paises Bajos',
              direccionImagen:
                'https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Flag_of_the_Netherlands.svg/800px-Flag_of_the_Netherlands.svg.png',
            },
          },
          {
            equipo2: {
              idEquipo: 2,
              nombre: 'Senegal',
              direccionImagen:
                'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Flag_of_Senegal.svg/1280px-Flag_of_Senegal.svg.png',
            },
          },
        ],
        estadioPartido: 'Al-Bayt Stadium',
        fechaPartido: '12/10/2022',
        statusPartido: 'Apuestas Cerradas',
        resultadoPartido: {
          golesEquipo1: 3,
          golesEquipo2: 2,
          result: 'equipo1',
        },
      },
    },
    {
      apuestaId: 3,
      golesEquipo1: 1,
      golesEquipo2: 0,
      partido: {
        idPartido: 3,
        fasePartido: 'Grupo C',
        equiposPartido: [
          {
            equipo1: {
              idEquipo: 1,
              nombre: 'Croacia',
              direccionImagen:
                'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/2560px-Flag_of_Croatia.svg.png',
            },
          },
          {
            equipo2: {
              idEquipo: 2,
              nombre: 'Inglaterra',
              direccionImagen:
                'https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Flag_of_England.svg/1024px-Flag_of_England.svg.png',
            },
          },
        ],
        estadioPartido: 'Abu-Dhabi',
        fechaPartido: '12/10/2022',
        statusPartido: 'Apuestas Abiertas',
        resultadoPartido: {
          golesEquipo1: 3,
          golesEquipo2: 2,
          result: 'equipo1',
        },
      },
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
