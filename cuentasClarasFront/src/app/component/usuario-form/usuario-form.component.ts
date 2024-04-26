import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService } from '../../services/usuario.service';
import { FormBuilder,  NgForm } from '@angular/forms';


@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrl: './usuario-form.component.css'
  
})
export class UsuarioFormComponent {
  usuario = new Usuario('','', '', '', ''); // inicializo.
  submitted = false;
  errorMessage: string = '';
  
  constructor(private usuarioService: UsuarioService,  private fb: FormBuilder) {}  // Inyección del servicio

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.usuario.nombreUsuario = formulario.value.nombreUsuario;
      this.usuario.nombre = formulario.value.nombre;
      this.usuario.apellido = formulario.value.apellido;
      this.usuario.email = formulario.value.email;
      this.usuario.contrasena = formulario.value.contrasena;
      this.submitted = true;
      
      console.log('Datos del usuario:', this.usuario);
      console.log('contra', this.usuario.contrasena);
      console.log("contra del form" ,formulario.value.contrasena);
      this.usuarioService.registrarUsuario(this.usuario).subscribe(
        response => {
          console.log('Registro exitoso:', response.body);
        },
        error => {
          console.error('Error al registrar usuario:', error);
          if (error.status === 400) {
            this.errorMessage = 'La solicitud es inválida. Verifica los parámetros.';
          } else if (error.status === 409) {
            this.errorMessage = 'Ya existe un usuario con el mismo correo electrónico.';
          } else {
            this.errorMessage = 'Error del servidor. Inténtalo nuevamente.';
          }
          console.log(this.errorMessage);
        }
      );
  }}




}