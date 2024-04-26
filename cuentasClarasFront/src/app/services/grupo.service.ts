import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Grupo } from '../models/grupo.model';
import { CategoriaGrupo } from '../models/categoriaGrupo.model';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {
  private apiUrl = 'http://localhost:8080/ttps-spring/'; 
  categorias: CategoriaGrupo[] = [];

  constructor(private http: HttpClient) { }

  listarCategorias(): Observable<any> {
    const url = `${this.apiUrl}grupos/listarCategorias`;
    return this.http.get<any>(url);
  }

  crearGrupo(grupo: Grupo): Observable<any> {
    console.log(grupo);
    const url = `${this.apiUrl}grupos`;
    return this.http.post<any>(url, grupo);
  } 

  actualizarGrupo(id: string, grupo: Grupo): Observable<any> {
    console.log(grupo,id);
    const url = `${this.apiUrl}grupos/${id}`;
    return this.http.put<any>(url, grupo);
  }
  agregarGasto(idGrupo: string, nuevoGasto: any): Observable<any> {
    const url = `${this.apiUrl}grupos/${idGrupo}`;
    return this.http.post(url, nuevoGasto);
  }

}
