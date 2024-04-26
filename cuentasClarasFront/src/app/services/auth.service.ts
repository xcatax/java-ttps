import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/ttps-spring/'; 

  constructor(private http: HttpClient) { }
    
  login(credentials: any): Observable<string> {
    const headers = new HttpHeaders()
      .set('usuario', credentials.usuario)
      .set('clave', credentials.clave);

    return this.http.post<string>(`${this.apiUrl}usuarios/login`, null, { headers });
  }

}
