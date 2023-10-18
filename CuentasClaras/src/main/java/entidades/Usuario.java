package entidades;

//import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import inicio.Factory;
@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombreUsuario; 
	//private String nombre; 
	//private String apellido; 
	//private String email;
	//private String contraseña;
	

//	private List<Usuario> amigos;
	//private List<Grupo> grupos;
	//private List<Saldo> saldos; 

	
	//geters y seters
	public long getId() {
		return id;
	}

	public Usuario() {
	
	}
	
    public Usuario(long id, String nombreUsuario) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		
	}

/*	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
*/
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/*public String getApellido() {
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
	
	public List<Saldo> getSaldos() {
		return saldos;
	}

	public void setSaldos(List<Saldo> saldos) {
		this.saldos = saldos;
	}
	


	// metodos
	
	public void altaUsuario(String nombreUsuario,String nombre, String apellido, String email,String contraseña) {}
		// Da de alta un usuario 
	public void registrarGrupo (String nombre, List<Usuario> usuarios, CategoriaGrupo categoria) {}
		// llama al constructor de grupo y lo guarda en la base
	public void registrarGasto(String nombre, Date fecha,byte imagen, CategoriaGasto categoria, List<Usuario> usuarios,double monto,Division division) {}
		// llama al constructor de gasto con un usuario en particular o con un grupo y lo guarda en la base
	public void registrarPago(Saldo saldo){}
		// llama al metodo de saldo que registra el pago.
	public void invitarUsuarioAGrupo(Grupo grupo,Usuario usuario){}
		// llama al metodo de grupo que agega un usuario a la lista de integrantes
	public List<Grupo> verGrupos(){ 
		return grupos;
	}

	public List<Usuario> verAmigos(){
		return amigos;
	}
	
	public float calcularSaldoTotal() {
		//Calcula el saldo total.
		return 0;
	}
	public void iniciarSesion(String email,String contraseña) {}

	public void agregarAmigo(Usuario amigo) {}// agrega un usuario a la lista de amigos
	public void registrarSaldo(Saldo saldo) {} //agega a la lista de saldos

*/
	
	
	
}
