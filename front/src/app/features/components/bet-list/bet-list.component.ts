import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BettingService } from 'src/app/core/services/betting.service';

@Component({
  selector: 'app-bet-list',
  templateUrl: './bet-list.component.html',
  styleUrls: ['./bet-list.component.scss'],
})
export class BetListComponent implements OnInit {
  apuestaForm: FormGroup = new FormGroup({});
  @Input() apuesta:any;

  constructor(private bettingService: BettingService) {}

  ngOnInit(): void {
    if (
      this.apuesta.partido.statusPartido === 'Finalizado' ||
      this.apuesta.partido.statusPartido === 'Apuestas Cerradas'
    ) {
      this.apuestaForm = new FormGroup({
        golesEquipo1: new FormControl({
          value: this.apuesta.golesEquipo1,
          disabled: true,
        }),
        golesEquipo2: new FormControl({
          value: this.apuesta.golesEquipo2,
          disabled: true,
        }),
      });
    } else {
      this.apuestaForm = new FormGroup({
        golesEquipo1: new FormControl(this.apuesta.golesEquipo1, Validators.required),
        golesEquipo2: new FormControl(this.apuesta.golesEquipo2, Validators.required),
      });
    }
  }
}
