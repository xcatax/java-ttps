package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMultilenguaje
 */
@WebServlet("/LoginMultilenguaje")
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idioma = (String) request.getAttribute("idioma");
		
	   // Cargar el archivo de propiedades correspondiente al idioma
       Properties propiedades = new Properties();
       
       InputStream input = getClass().getResourceAsStream("/textos_" + idioma + ".properties"); //este metodo lo dieron en la clase
       
       propiedades.load(input); 

       // Obtener los textos desde el archivo de propiedades
       String title = propiedades.getProperty("titulo");
       String usr = propiedades.getProperty("labelusuario");
       String pass = propiedades.getProperty("labelpassword");
       String button = propiedades.getProperty("enviar");

       // Generar la página HTML con los textos
       response.setContentType("text/html; charset=UTF-8");
       
       PrintWriter out = response.getWriter();
       
        out.println("<html><body>");
		out.println("<h2>" + title + "</h2>");
		out.println("<form action='ServletLogin' method='post'>" );
		out.println("<p>" + usr + ": <input type='text' name='usr'></p>");
		out.println("<p>" + pass + ": <input type='password' name='pass'></p>");
		out.println("<p> <input type='submit' value=' " + button + "'> </p>");
		out.println("</form>");
		out.println("<body><html>");
		out.close();
		
	   doGet(request, response);
	}

}
