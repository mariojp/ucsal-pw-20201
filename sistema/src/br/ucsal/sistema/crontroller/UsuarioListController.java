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
import br.ucsal.sistema.servico.UsuarioService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/private/usuarios")
public class UsuarioListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioService service = new UsuarioService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista",service.list());
		request.getRequestDispatcher("./listar.jsp").forward(request, response);

	}

}
