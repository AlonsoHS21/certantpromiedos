import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jackpot } from 'src/app/models/Jackpot';

@Injectable({
  providedIn: 'root',
})
export class JackpotService {
  constructor(private http: HttpClient) {}

  getJackpot(): Observable<Jackpot> {
    return this.http.get<Jackpot>('');
  }

  putJackpot(jackpot: Jackpot): Observable<Jackpot> {
    return this.http.put<Jackpot>('', jackpot);
  }

  postJackpot(jackpot: Jackpot): Observable<Jackpot> {
    return this.http.put<Jackpot>('', jackpot);
  }
}
