package entidades;

import java.util.List;

public class Usuario {
	private long id;
	private String nombre; 
	private String nombreUsuario; 
	private String apellido; 
	private String email;
	private String contraseña;
	
	private List<Usuario> amigos;
	private List<Grupo> grupos;
	private List<Gasto> gastos; 
	
	
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void invitarUsuarioAGrupo(Grupo grupo,Usuario usuario){}
	
	public void cargarGasto(Gasto gasto) {}
	
	public void realizarPago(Pago pago){}
	
	public List<Grupo> verGrupos(){ 
		return grupos;
	}

	public List<Usuario> verAmigos(){
		return amigos;
	}
	
	public double verSaldoTotal() {
		return 0;
	}
	
}
