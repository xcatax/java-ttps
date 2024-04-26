// grupo.model.ts
import { CategoriaGrupo } from "./categoriaGrupo.model";

export class Grupo {
  public id: string;
  public nombre: string;
  public fecha: string;
  public categoria: CategoriaGrupo; 

  constructor(
    id: string,
    nombre: string,
    fecha: string,
    categoria: CategoriaGrupo,
  ) {  
    this.id = id;    
    this.nombre = nombre;    
    this.fecha = fecha;
    this.categoria = categoria;
  }
}
