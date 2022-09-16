import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { PartidoService } from 'src/app/core/services/partido.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private partidoSer:PartidoService) { }

  ngOnInit(): void {
  }


  test(){
    this.partidoSer.getPartido().subscribe((res)=>{
      console.log(res)
    })
  }

}
