//angular y externas
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

//models y cosas nuestras
import { GastoService } from '../../services/gasto.service';
import { Gasto } from '../../models/gasto.model';
import { Usuario } from '../../models/usuario.model'; 
import { CategoriaGasto } from '../../models/categoriaGasto.model';
import { CategoriaGrupo } from '../../models/categoriaGrupo.model';
import { Grupo } from '../../models/grupo.model';


@Component({
  selector: 'app-editar-gasto',
  templateUrl: './editar-gasto.component.html',
  styleUrl: './editar-gasto.component.css'
})
export class EditarGastoComponent implements OnInit  {
  gasto: Gasto = new Gasto('','', '','',new CategoriaGasto(''),new Usuario('','','','',''));
  categorias: CategoriaGasto[] = [];
  usuarios: Usuario[] = [];

  constructor(
    private gastoService: GastoService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const gastoId = this.route.snapshot.paramMap.get('id');

    if (gastoId !== null) {
      console.log("me llegó este gasto:", gastoId);
  
      // Llamo al servicio para que me lo busque
      this.gastoService.obtenerGastoPorId(gastoId).subscribe(
        (gasto: any) => {
          this.gasto = gasto;
        },
        (error) => {
          console.error('Error al obtener el gasto', error);
        }
      );
    } else {
      console.error('No se proporcionó un ID de gasto válido.');
    }


    // Cargar categorías y usuarios
    this.gastoService.listarCategorias().subscribe(
      (categorias: CategoriaGasto[]) => {
        this.categorias = categorias;
      },
      (error) => {
        console.error('Error al cargar las categorías:', error);
      }
    );

    this.gastoService.listarUsuarios().subscribe(
      (usuarios: Usuario[]) => {
        this.usuarios = usuarios;
      },
      (error) => {
        console.error('Error al cargar los usuarios:', error);
      }
    );

  }

  editarGasto(): void {
    console.log("editando:::");
    console.log(this.gasto.id , this.gasto);
    

    this.gastoService.actualizarGasto(this.gasto.id, this.gasto).subscribe(
      (response) => {
        console.log('Gasto actualizado correctamente', response);
      },
      (error) => {
        console.log("sali por el error", this.gasto)
        console.error('Error al actualizar el gasto:', error);
      }
    );  
  }

  
}
