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
@WebServlet("/private/usuarios/salvar")
public class UsuarioSaveController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioService service = new UsuarioService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String sid = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String papelID = request.getParameter("papel");
		
		
		Usuario usuario = new Usuario();
		if(sid!=null && !sid.isEmpty()) {
			usuario.setId(Long.parseLong(sid));
		}
		usuario.setLogin(login);
		usuario.setSenha(senha);
		Papel papel = new Papel();
		papel.setId(Long.parseLong(papelID));
		usuario.setPapel(papel);
		
		service.salvar(usuario);
		
		
		response.sendRedirect("/sistema/private/usuarios");

		


	}

}
