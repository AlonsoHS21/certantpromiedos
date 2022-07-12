import { Component, OnInit, Input } from '@angular/core';


@Component({
  selector: 'app-team-card',
  templateUrl: './team-card.component.html',
  styleUrls: ['./team-card.component.scss']
})
export class TeamCardComponent implements OnInit {
@Input() imagen:string = ''
@Input() nombre:string = ''

  constructor() { }

  ngOnInit(): void {
  }

}
