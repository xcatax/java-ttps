package ttps.clasificados;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		        
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Encabezado");
		 if (dispatcher != null)
			 dispatcher.include(request, response);
				
	//	String perfil = (String) request.getAttribute("perfil");
		
	/*	if(perfil != null) {
			if(perfil.equals("publicador")) {
					 response.sendRedirect("publicador.html");
			}else {
				if(perfil.equals("admin"))
					response.sendRedirect("administrador.html");	
				}				
		}else {
				response.sendRedirect("error.html");			 
		}*/

}
}
