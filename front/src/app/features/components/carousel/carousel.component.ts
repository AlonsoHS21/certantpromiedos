import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {
  public slides = [
    {
      src: '../../../assets/carousel.png'
    },
    {
      src: 'https://previews.123rf.com/images/patterndesign/patterndesign1706/patterndesign170600967/80050349-resumen-de-fondo-de-imagen-16-9-relaci%C3%B3n-de-aspecto-en-el-estilo-de-arte-de-p%C3%ADxeles-.jpg'
    },
    {
      src: 'https://previews.123rf.com/images/patterndesign/patterndesign1706/patterndesign170601027/80050303-resumen-de-fondo-de-imagen-16-9-relaci%C3%B3n-de-aspecto-en-el-estilo-de-arte-de-p%C3%ADxeles-.jpg'
    }
];

  constructor() { }

  ngOnInit(): void {
  }

}
