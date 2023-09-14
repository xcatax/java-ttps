package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;



/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> users;
	private Usuario u1;
   
    public ServletLogin() {
        super();
        users = new ArrayList<Usuario>();
        u1 = new Usuario("jime","aaa");
        users.add(u1);
        u1 = new Usuario("cami","123");
        users.add(u1);
    }

    private Usuario validateUser(String name, String password) {
		for (Usuario u: users) 
			if(u.getNombre().equals(name) && u.getPass().equals(password))
					return u;
		return null;
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario userFound = this.validateUser(request.getParameter("usr"), request.getParameter("pass"));
		
		 if (userFound != null) {
			 response.sendRedirect("home.html");	
		}else
			response.sendRedirect("error.html");
	}

}
