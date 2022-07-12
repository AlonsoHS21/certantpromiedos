import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Apuesta } from 'src/app/models/Apuesta';

@Component({
  selector: 'app-bet-list',
  templateUrl: './bet-list.component.html',
  styleUrls: ['./bet-list.component.scss'],
})
export class BetListComponent implements OnInit {
  apuesta:any;
  
  

  constructor() {}

  ngOnInit(): void {}
}
