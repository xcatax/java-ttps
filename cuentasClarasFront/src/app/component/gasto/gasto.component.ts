import { Component, OnInit } from '@angular/core';
import { GastoService } from '../../services/gasto.service';
import { Gasto } from '../../models/gasto.model';
import { forkJoin } from 'rxjs';
import { Usuario } from '../../models/usuario.model'; 
import { CategoriaGasto } from '../../models/categoriaGasto.model';
import { CategoriaGrupo } from '../../models/categoriaGrupo.model';
import { Grupo } from '../../models/grupo.model';
import { GrupoService } from '../../services/grupo.service';

@Component({
  selector: 'app-gasto',
  templateUrl: './gasto.component.html',
  styleUrl: './gasto.component.css'
})
export class GastoComponent {
modoEdicion = false;
nuevoGasto: Gasto = new Gasto('','', '','',new CategoriaGasto(''),new Usuario('','','','',''));

categorias: CategoriaGasto[] = [];
usuarios: Usuario[] = [];
grupos: Grupo[] = [];
errorMessage: string = '';
gastoId: string= '';
grupoSeleccionado: Grupo = new Grupo('','','',new CategoriaGrupo(''));
grupoActualizado: Grupo = new Grupo('','','',new CategoriaGrupo(''));

constructor(private gastoService: GastoService,private grupoService: GrupoService) { }

onSubmit(): void {
  if (this.modoEdicion) {
    // Si estamos en modo edición, llamamos al método editarGasto()
    this.editarGasto();
  } else {
    // Si no, estamos en modo creación, llamamos al método crearGasto()
    this.crearGasto();
  }
}
private crearGasto(): void {
  console.log("estoy creando ese gasto",this.nuevoGasto);
  console.log("el grupo es:", this.grupoSeleccionado);
  this.gastoService.crearGasto(this.nuevoGasto).subscribe(
    (response) => {
      this.gastoId = response.id;
      this.agregarGastoAlGrupo(this.grupoSeleccionado);
      this.modoEdicion = true; // Cambiamos al modo de edición después de crear el gasto
    },
    (error) => {
      console.error('Error al registrar gasto:', error);
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
  editarGasto(): void {
    console.log("editando el gasto");
    this.gastoService.actualizarGasto(this.gastoId, this.nuevoGasto).subscribe(
      (response) => {
        if(this.grupoActualizado.nombre !== ''){ //!== ''
          console.log("estoy entrando a actualizar??")
          this.agregarGastoAlGrupo(this.grupoActualizado);
        }else{
          console.log("no entre")
        }
        console.log('Gasto actualizado correctamente', response);
        
      },
      (error) => {
        console.log("sali por el error", this.nuevoGasto)
        console.error('Error al actualizar el gasto:', error);
      }
    );  
  }

  ngOnInit() {
    forkJoin({
      categorias: this.gastoService.listarCategorias(),
      usuarios: this.gastoService.listarUsuarios(),
      grupos: this.gastoService.listarGrupos(),
    }).subscribe({
      next: (result: any) => {
        if (result && result.categorias && Array.isArray(result.categorias)) {
          this.categorias = result.categorias;
        }
        if (result && result.usuarios && Array.isArray(result.usuarios)) {
          this.usuarios = result.usuarios;
        }
        if (result && result.grupos && Array.isArray(result.grupos)) {
          this.grupos = result.grupos;
        }
      },
      error: (error: any) => {
        console.error('Error al cargar usuarios y categorías:', error);
      }
    });
  }

  private agregarGastoAlGrupo(grupo : Grupo): void {
    // Llamada al método agregarGasto del servicio de grupo
    this.grupoService.agregarGasto(grupo.id, this.nuevoGasto).subscribe(
      (grupoResponse) => {
        console.log('Gasto agregado al grupo exitosamente:', grupoResponse);
        
      },
      (grupoError) => {
        console.error('Error al agregar el gasto al grupo:', grupoError);

      }
    );
  }


}
