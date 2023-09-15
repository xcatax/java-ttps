package servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletImprimeCupon
 */
@WebServlet("/ServletImprimeCupon")
public class ServletImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImprimeCupon() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String text = request.getParameter("texto");
		System.out.print(text);
		Integer codigoRetiro = ThreadLocalRandom.current().nextInt(1000000,9999999); 
		
		System.out.print(codigoRetiro);
		response.setHeader("Content-Type", "image/jpeg");
		 
		String path = getServletContext().getRealPath("cupon3.jpg");
	
		BufferedImage bf = ImageIO.read(new File(path));
		Graphics graphics = bf.getGraphics();
		//String texto= "hola manola";
		graphics.setFont(new Font("TimesRoman", Font.BOLD, 14));

		graphics.setColor(Color.WHITE);
		graphics.drawString(text,10,30);
		
		graphics.drawString(codigoRetiro.toString(),300,33);
			
		ImageIO.write(bf, "jpg", response.getOutputStream());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

}
