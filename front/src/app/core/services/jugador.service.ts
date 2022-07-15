import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jugador } from 'src/app/models/Jugador';

@Injectable({
  providedIn: 'root',
})
export class JugadorService {
  constructor(private http: HttpClient) {}

  getJugador(): Observable<Jugador> {
    return this.http.get<Jugador>('');
  }

  putJugador(jugador: Jugador): Observable<Jugador> {
    return this.http.put<Jugador>('', jugador);
  }

  postJugador(jugador: Jugador): Observable<Jugador> {
    return this.http.post<Jugador>('', jugador);
  }
}
