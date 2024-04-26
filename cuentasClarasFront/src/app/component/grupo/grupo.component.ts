import { Component, OnInit } from '@angular/core';
import { GrupoService } from '../../services/grupo.service';
import { Grupo } from '../../models/grupo.model';
import { forkJoin } from 'rxjs';
import { CategoriaGrupo } from '../../models/categoriaGrupo.model';
import 'bootstrap';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styleUrl: './grupo.component.css'
})

export class GrupoComponent {

modoEdicion = false;
nuevoGrupo: Grupo = new Grupo('','', '',new CategoriaGrupo(''));
categorias: CategoriaGrupo[] = [];
errorMessage: string = '';
grupoId: string= '';

constructor(private grupoService: GrupoService) { }

onSubmit(): void {
  if (this.modoEdicion) {
    this.editarGrupo();
  } else {
    this.crearGrupo();
  }
}

private crearGrupo(): void {
  this.grupoService.crearGrupo(this.nuevoGrupo).subscribe(
    (response) => {
      console.log(response);
      this.grupoId = response.id;
      this.modoEdicion = true; 
    },
    (error) => {
      console.error('Error al registrar grupo:', error);
      if (error.status === 400) {
        this.errorMessage = 'La solicitud es inválida. Verifica los parámetros.';
        console.log('Respuesta de error:', error?.error);
      } else if (error.status === 500) {
        console.log('Respuesta de error:', error?.error);
        this.errorMessage = 'Error del servidor. Inténtalo nuevamente.';
      }
      console.log(this.errorMessage);
      console.log('Respuesta de error:', error?.error);
    }
  );
}

editarGrupo(): void {
    console.log(this.grupoId);
    this.grupoService.actualizarGrupo(this.grupoId, this.nuevoGrupo).subscribe(
      (response) => {
        console.log('Grupo actualizado correctamente', response);
      },
      (error) => {
        console.error('Error al actualizar el grupo:', error);
      }
    );  
  }

ngOnInit() {
  forkJoin({
    categorias: this.grupoService.listarCategorias()    
  }).subscribe({
    next: (result: any) => {
      if (result && result.categorias && Array.isArray(result.categorias)) {
        this.categorias = result.categorias;
      }
    },
    error: (error: any) => {
      console.error('Error al cargar usuarios y categorías:', error);
    }
  });
}
}
