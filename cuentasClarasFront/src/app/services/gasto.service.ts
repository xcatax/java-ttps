// gasto.service.ts

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Gasto } from '../models/gasto.model';
import { Usuario } from '../models/usuario.model';
import { Grupo } from '../models/grupo.model';
import { CategoriaGasto } from '../models/categoriaGasto.model';

@Injectable({
  providedIn: 'root'
})
export class GastoService {
  private apiUrl = 'http://localhost:8080/ttps-spring/'; // Ruta base de la API de gastos
  categorias: CategoriaGasto[] = [];
  usuarios: Usuario[] = [];
  grupos: Grupo[] = [];
  constructor(private http: HttpClient) { }

  listarCategorias(): Observable<any> {
    const url = `${this.apiUrl}gastos/listarCategorias`;
    return this.http.get<any>(url);
  }
  listarUsuarios(): Observable<any> {
    const url = `${this.apiUrl}usuarios/listarTodos`;
    return this.http.get<any>(url);
  }
  listarGrupos(): Observable<any> {
    const url = `${this.apiUrl}grupos/listarTodos`;
    return this.http.get<any>(url);
  }
  
  crearGasto(gasto: Gasto): Observable<any> {
    console.log(gasto);
    console.log("en el service");
    const url = `${this.apiUrl}gastos`;
    return this.http.post<any>(url, gasto);
  } 

  actualizarGasto(id: string, gasto: Gasto): Observable<any> {
    console.log(gasto,id);
    const url = `${this.apiUrl}gastos/${id}`;
    return this.http.put<any>(url, gasto);
  }

  obtenerGastoPorId(id: string): Observable<Gasto> {
    console.log("estoy por buscar ese gasto");
    const url = `${this.apiUrl}gastos/${id}`;
    return this.http.get<Gasto>(url);
  }
}


