import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partido } from 'src/app/models/Partido';
import { CookieService } from 'ngx-cookie';

@Injectable({
  providedIn: 'root',
})

// Set-Cookie: JSESSIONID=3BCA03872D4AFDB758F7AD1C9DDF17FF; Path=/; HttpOnly
export class PartidoService {
  // private httpOptions = {
  //   headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  //   withCredentials: true
  // };

  constructor(private http: HttpClient, private cookieService: CookieService) {}

  cookie!: string;

  headers = new HttpHeaders({
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
    'Access-Control-Allow-Headers':
      'X-Requested-With, content-type, Authorization',
    Accept: 'application/json',
    observe: 'response',
  });

  getPartido(): Observable<any> {
    return this.http.get('http://workstation03:8060/partidos', {headers:this.headers, withCredentials:true});
  }

  putPartido(partido: Partido): Observable<Partido> {
    return this.http.put<Partido>('', partido);
  }

  postPartido(partido: Partido): Observable<Partido> {
    return this.http.post<Partido>('', partido);
  }
}
