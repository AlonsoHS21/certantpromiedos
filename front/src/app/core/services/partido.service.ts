import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partido } from 'src/app/models/Partido';

@Injectable({
  providedIn: 'root',
})
export class PartidoService {
  constructor(private http: HttpClient) {}

  getPartido(): Observable<Partido> {
    return this.http.get<Partido>('');
  }

  putPartido(partido:Partido): Observable<Partido> {
    return this.http.put<Partido>('', partido);
  }

  postPartido(partido:Partido): Observable<Partido> {
    return this.http.post<Partido>('', partido);
  }
}
