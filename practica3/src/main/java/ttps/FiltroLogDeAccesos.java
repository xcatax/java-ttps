package ttps;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
@WebFilter("/*")
public class FiltroLogDeAccesos implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogDeAccesos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		        // Obtener la dirección IP del cliente
		        String ipAddress = request.getRemoteAddr();
		        
		        // Obtener la fecha y hora actual
		        Date fechaHoraActual = new Date();
		       /* HttpServletResponse httpResponse = (HttpServletResponse) response;
	            String dateHeader = httpResponse.getHeader("Date");*/
		        
		         //Obtener la línea de solicitud (request line)
		        if (request instanceof HttpServletRequest) {
		            HttpServletRequest httpRequest = (HttpServletRequest) request;
		            
		            String metodo = httpRequest.getMethod();
		            String recursoSolicitado = httpRequest.getRequestURI();
		            String versionProtocolo = httpRequest.getProtocol();
		            
		            // Obtener el User-Agent
		            String userAgent = httpRequest.getHeader("User-Agent");
		            //String fechaHoraActual = httpRequest.getHeader("Date");
		            
		            // Crear una cadena de registro
		            String registro= ipAddress + metodo + recursoSolicitado + versionProtocolo + userAgent + "a ver la fecha " + fechaHoraActual;
		            
		            // Imprimir el registro en la consola (puedes guardar en un archivo en lugar de imprimir)
		            System.out.println(registro);
		        }

		        // Continuar con la cadena de filtros
    			
		        chain.doFilter(request, response);
		    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
