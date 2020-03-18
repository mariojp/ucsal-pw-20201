package br.ucsal.sistema;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("user");
		String senha = request.getParameter("pass");
		
		if (usuario.equals(senha)){
			
			request.getSession().setAttribute("USUARIO", usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/private/dashboard.jsp");
			dispatcher.forward(request, response);
			
			//response.sendRedirect("/sistema/dashboard.jsp");

		}else{
			response.sendRedirect("/sistema/index.jsp?erro=Erro de Acesso");
		}



	}

}
