package entidades;

import java.util.List;

public class Gasto {
	private long id;
	private String nombre; 
	private CategoriaGasto categoria;
	private double monto; 
	private String fecha;
	private Imagen imagen;
	private List<Saldo> saldos;
	private List<Usuario> usuarios;
	
	
}
