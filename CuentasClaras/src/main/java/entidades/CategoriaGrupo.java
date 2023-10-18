package entidades;

public class CategoriaGrupo {
	private long id;
	private String nombre; 
	private byte imagen;
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte getImagen() {
		return imagen;
	}
	public void setImagen(byte imagen) {
		this.imagen = imagen;
	}
		
    public CategoriaGrupo altaCategoriaGrupo(String nombre, byte imagen) {
    	return null;
    }
}
