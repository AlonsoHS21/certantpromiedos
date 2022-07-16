import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {
  public slides = [
    {
      src: '../../../assets/grupo_1.png'
    },
    {
      src: '../../../assets/grupo_2.png'
    },
    {
      src: '../../../assets/grupo_3.png'
    },
    {
      src: '../../../assets/grupo_4.png'
    },
    {
      src: '../../../assets/grupo_5.png'
    },
    {
      src: '../../../assets/grupo_6.png'
    },
    {
      src: '../../../assets/grupo_7.png'
    },
    {
      src: '../../../assets/grupo_8.png'
    }
];

  constructor() { }

  ngOnInit(): void {
  }

}
