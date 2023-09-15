package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroStockRemeras
 */
@WebFilter("/ServletImprimeCupon")
public class FiltroStockRemeras implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroStockRemeras() {
        super();
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
		
		
		 ServletContext contexto =request.getServletContext();
		  
		 int cantidad = (Integer) contexto.getAttribute("cantidad");
		
		 HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		 if(cantidad > 0) {
			 cantidad --;
			 System.out.print(contexto.getAttribute("cantidad"));
			 contexto.setAttribute("cantidad",cantidad);
			 //deberia tener otro contador en el contexto o manejarlo desde un servlet que inicialice mi contador, luego lo implemento en la clase no llegue 
			 
			 
		 }
		  else {
				 httpResponse.sendRedirect("noHayMas.html");
				 return;
			 }
			 			
			chain.doFilter(request, response);
		 }		
		
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
