import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Apuesta } from 'src/app/models/Apuesta';

@Injectable({
  providedIn: 'root'
})
export class BettingService {

  constructor(private http:HttpClient) { }

  postBet<Apuesta>(apuesta:Apuesta):Observable<Apuesta>{
    return this.http.post<Apuesta>('https://jsonplaceholder.typicode.com/posts', apuesta)
  }

  getBet<Apuesta>(apuesta:string):Observable<Apuesta>{
    return this.http.get<Apuesta>('https://jsonplaceholder.typicode.com/posts/' + apuesta)
  }

}
