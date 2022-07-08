import { Component, OnInit } from '@angular/core';
import { Equipo } from 'src/app/models/Equipo';

@Component({
  selector: 'app-team-card',
  templateUrl: './team-card.component.html',
  styleUrls: ['./team-card.component.scss']
})
export class TeamCardComponent implements OnInit {

  equipo:Equipo = {
    idEquipo: 1,
    nombre: 'Argentina',
    direccionImagen: 'https://upload.wikimedia.org/wikipedia/commons/e/ed/Flag_of_Argentina_%282-3%29.png'
  } 

  constructor() { }

  ngOnInit(): void {
  }

}
