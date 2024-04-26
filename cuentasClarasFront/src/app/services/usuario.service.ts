import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Usuario } from '../component/usuario-form/usuario';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/ttps-spring';
  
  constructor(private http: HttpClient) { }

  registrarUsuario(usuario: Usuario): Observable<HttpResponse<any>> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('estoy aca?' , headers);

    return this.http.post<any>(`${this.apiUrl}/usuarios`, usuario, { headers, observe: 'response' });
  }
}
