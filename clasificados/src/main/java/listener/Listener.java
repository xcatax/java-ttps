package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContext;


import clases.SitioClasificado;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
		 String nombre= sce.getServletContext().getInitParameter("nombre_sitio");
		 String email= sce.getServletContext().getInitParameter("email_sitio");
		 int tel= Integer.parseInt(sce.getServletContext().getInitParameter("tel_sitio"));
		 
		 SitioClasificado sitio = new SitioClasificado(nombre, email, tel);
		 ServletContext contexto = sce.getServletContext();
		 contexto.setAttribute("sitio", sitio);
    }
	
}
