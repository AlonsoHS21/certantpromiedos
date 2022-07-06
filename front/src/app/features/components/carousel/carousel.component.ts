import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {
  public slides = [
    {
      src: '../../../assets/grupo_a.png'
    },
    {
      src: '../../../assets/grupo_b.png'
    },
    {
      src: '../../../assets/grupo_c.png'
    },
    {
      src: '../../../assets/grupo_d.png'
    },
    {
      src: '../../../assets/grupo_e.png'
    },
    {
      src: '../../../assets/grupo_f.png'
    },
    {
      src: '../../../assets/grupo_g.png'
    },
    {
      src: '../../../assets/grupo_h.png'
    }
];

  constructor() { }

  ngOnInit(): void {
  }

}
