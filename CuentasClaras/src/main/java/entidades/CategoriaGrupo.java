package entidades;

public class CategoriaGrupo {
	private long id;
	private String nombre; 
	private Imagen imagen;
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Imagen getImagen() {
		return imagen;
	}
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
		
	
}
