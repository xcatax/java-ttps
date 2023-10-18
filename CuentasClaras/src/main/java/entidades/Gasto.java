package entidades;

import java.util.Date;
import java.util.List;

public class Gasto {
	private long id;
	private String nombre; 
	private Date fecha;
	private float monto; 
	private byte imagen;
	
	private CategoriaGasto categoria;
	
	private Usuario usuarioOrigen;
	private List<Usuario> integrantes; //lista de usuarios, que puede ser un usuario individuales o miembros de un grupo (todos o menos)

	private Division division;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public CategoriaGasto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaGasto categoria) {
		this.categoria = categoria;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public byte getImagen() {
		return imagen;
	}
	public void setImagen(byte imagen) {
		this.imagen = imagen;
	}
	public List<Usuario> getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(List<Usuario> integrantes) {
		this.integrantes = integrantes;
	}
	public Usuario getUsuarioOrigen() {
		return usuarioOrigen;
	}
	public void setUsuarioOrigen(Usuario usuarioOrigen) {
		this.usuarioOrigen = usuarioOrigen;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}

	// metodos
	public Gasto altaGasto(String nombre, Date fecha, byte imagen, Usuario usuarioOrigen, CategoriaGasto categoria, List<Usuario> integrantes, float monto, Division division) {
	    return null; 
	}
	
	public void editarGasto(Gasto gasto, float nuevoMonto, Date nuevaFecha, byte nuevaImagen, Usuario nuevoIntegrante, Division nuevaFormaDivisión) {
	    // Actualiza los atributos del gasto Gasto con los nuevos valores proporcionados
	}
	
	public void altaSaldos() {
		//calcula los saldos individuales de los integrantes del gasto
		// según la estrategia de división y el monto. 
		// Relaciona los saldos calculados y los integrantes del gasto.
	}
	}
