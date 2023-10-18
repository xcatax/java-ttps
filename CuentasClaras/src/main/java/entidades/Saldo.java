package entidades;

public class Saldo {
	private long id;
	private float debe; 
	private boolean pagado ;

	private Usuario usuarioOrigen; 
	private Usuario usuarioDestino;
	
	private Gasto consumo;
	
	
	public float getDebe() {
		return debe;
	}
	public void setDebe(float debe) {
		this.debe = debe;
	}
	public Usuario getUsuarioOrigen() {
		return usuarioOrigen;
	}
	public void setUsuarioOrigen(Usuario usuarioOrigen) {
		this.usuarioOrigen = usuarioOrigen;
	}
	public Usuario getUsuarioDestino() {
		return usuarioDestino;
	}
	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}
	public Gasto getConsumo() {
		return consumo;
	}
	public void setConsumo(Gasto consumo) {
		this.consumo = consumo;
	}  
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	//Metodos
	
	 public void registrarSaldo(float debe, Usuario usuarioOrigen, Usuario usuarioDestino, Gasto consumo) {}
	 
	 public void registrarPago() {} // marca como pagado

}
