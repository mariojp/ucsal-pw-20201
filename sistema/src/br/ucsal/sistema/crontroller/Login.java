package br.ucsal.sistema.crontroller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.servico.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	private LoginService loginController = new LoginService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("user");
		String senha = request.getParameter("pass");
		
		Usuario usuario = loginController.login(login, senha);
		
		if (usuario != null){
			request.getSession().setAttribute("USUARIO", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/private/dashboard.jsp");
			dispatcher.forward(request, response);

		}else{
			response.sendRedirect("/sistema/index.jsp?erro=Erro de Acesso");
		}


		

	}

}
