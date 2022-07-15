import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipo } from 'src/app/models/Equipo';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  constructor(private http:HttpClient) { }

  getEquipo():Observable<Equipo>{
    return this.http.get<Equipo>('')
  }

  putEquipo(equipo:Equipo):Observable<Equipo>{
    return this.http.put<Equipo>('', equipo)
  }

  postEquipo(equipo:Equipo):Observable<Equipo>{
    return this.http.put<Equipo>('', equipo)
  }
}
