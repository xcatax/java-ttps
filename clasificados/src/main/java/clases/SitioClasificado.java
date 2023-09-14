package clases;

public class SitioClasificado {
	private String nombreSitio;
	private String mailSitio;
	private int telSitio;
	
	public SitioClasificado(String nombreSitio, String mailSitio, int telSitio) {
		this.nombreSitio = nombreSitio;
		this.mailSitio = mailSitio;
		this.telSitio = telSitio;
	}

	public String getNombreSitio() {
		return nombreSitio;
	}

	public String getMailSitio() {
		return mailSitio;
	}

	public int getTelSitio() {
		return telSitio;
	}	
}
