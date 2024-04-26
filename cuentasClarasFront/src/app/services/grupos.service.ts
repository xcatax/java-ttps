import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Grupo } from '../models/grupo.model';
import { Gasto } from '../models/gasto.model';
@Injectable({
  providedIn: 'root'
})
export class GruposService {
  private apiUrl = 'http://localhost:8080/ttps-spring';
  constructor(private http: HttpClient) {}

  listarGrupos(): Observable<Grupo[]> {
    return this.http.get<Grupo[]>(`${this.apiUrl}/grupos/listarTodos`);
  }

  obtenerGastos(idGrupo: string): Observable<Gasto[]> {
    console.log('estoy en service');
    const url = `${this.apiUrl}/grupos/${idGrupo}/gastos`;
    console.log(url);
    return this.http.get<Gasto[]>(url);
  }
}