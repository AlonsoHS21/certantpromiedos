import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/models/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { }

  getUsuario():Observable<Usuario>{
    return this.http.get<any>('');
  }

  putUsuario(usuario:any):Observable<Usuario>{
    return this.http.put<any>('', usuario);
  }

  postUsuario(usuario:any):Observable<Usuario>{
    return this.http.post<any>('', usuario);
  }
}
