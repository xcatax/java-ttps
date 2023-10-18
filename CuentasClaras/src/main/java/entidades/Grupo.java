package entidades;

import java.util.List;

public class Grupo {
	private long id;
	private String nombre;
	private byte imagen;
	
	private CategoriaGrupo categoria; 
	
	private List<Gasto> gastos; 
	private List<Usuario> integrantes;
		
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaGrupo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGrupo categoria) {
		this.categoria = categoria;
	}
	public byte getImagen() {
		return imagen;
	}

	public void setImagen(byte imagen) {
		this.imagen = imagen;
	}
	
	
	
	//metodos
	public Grupo  altaGrupo (String nombre, List<Usuario> integrantes, CategoriaGrupo categoria) {
		return null;
	}
	
	public void agregarIntegrante(Usuario usuario) {
		
	}
	
	public Gasto cargarGasto(Gasto gasto) {
		return null;
	}
	public List<Usuario> verIntegrantes() {
		return integrantes;
	}
	public List<Gasto> verGastos() {
		return gastos;
	}


}
