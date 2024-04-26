// gasto.model.ts
import { Usuario } from "./usuario.model";
import { CategoriaGasto } from "./categoriaGasto.model";
import { Grupo } from "./grupo.model";

export class Gasto {
  public id: string;
  public nombre: string;
  public monto: string;
  public fecha: string;
  public categoria: CategoriaGasto; 
  public usuarioOrigen: Usuario;
 // public grupo: Grupo;
  constructor(
    id:string,
    nombre: string,
    monto: string,
    fecha: string,
    categoria: CategoriaGasto,
    usuarioOrigen: Usuario,
 //   grupo: Grupo
  ) {
    this.id = id;
    this.nombre = nombre;    
    this.monto = monto;
    this.fecha = fecha;
    this.categoria = categoria;
    this.usuarioOrigen = usuarioOrigen;
  //  this.grupo = grupo;
  }
}
