package br.ucsal.sistema.crontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.sistema.model.Papel;
import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.servico.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	private LoginService service = new LoginService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("user");
		String senha = request.getParameter("pass");
		
		
		
		Usuario usuario = service.login(login, senha);
		
		if (usuario != null){
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("./private/dashboard.jsp");
		}else{
			throw new ServletException("Usuario Invalido");
//			request.setAttribute("erro", "Login ou Senha Invalidos!");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
//			dispatcher.forward(request, response);
		}


		

	}

}
