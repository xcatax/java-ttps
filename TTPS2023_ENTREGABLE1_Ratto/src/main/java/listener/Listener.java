package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
			 Integer cantidad= Integer.parseInt(sce.getServletContext().getInitParameter("cantidad"));			 
			 ServletContext contexto = sce.getServletContext();
			 contexto.setAttribute("cantidad", cantidad);			 
	    }
	   }
	

