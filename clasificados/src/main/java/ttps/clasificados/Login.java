package ttps.clasificados;
import entidades.Usuario;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> listaUsuarios; 
 
    
    public Login() {
        // TODO Auto-generated constructor stub
    	listaUsuarios = new ArrayList<Usuario>();
    	
    	Usuario cata = new  Usuario("cata","1234", "admin");
    	Usuario eli = new  Usuario("eli","4321","publicador");
    	
    	listaUsuarios.add(cata);
    	listaUsuarios.add(eli);

    } 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String perfil=null;
		for (Usuario usuario:listaUsuarios) {
			 if(usuario.getNombre().equals(request.getParameter("nombre")) && (usuario.getPass().equals(request.getParameter("pass")) ) )  {
				 perfil = usuario.getPerfil() ; 
			}			 
		}	
		 
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menu"); 
		 if (dispatcher != null) {
			 request.setAttribute("perfil", perfil);
			 dispatcher.forward(request, response);
		 }		
	}
}
	
