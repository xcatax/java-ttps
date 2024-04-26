import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  nombre = "cata";
  credentials = {
    usuario: '',
    clave: ''
  };
  
  constructor(private authService: AuthService) { }

  onSubmit(): void {
    this.authService.login(this.credentials).subscribe(
      (response) => {
        console.log("hola");
        console.log('Login exitoso', response);

      },
      (error) => {
        // Manejar el error de autenticación
        console.error('Error en el login', error);
      }
    );
  }

}


