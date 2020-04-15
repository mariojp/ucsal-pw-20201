package br.ucsal.sistema.crontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.servico.PapelService;
import br.ucsal.sistema.servico.UsuarioService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/private/usuarios/form")
public class UsuarioFormController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private UsuarioService usuarioService = new UsuarioService();
	private PapelService papelService = new PapelService();

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista",papelService.list());
		String id = request.getParameter("id");
		Usuario usuario = null;
		if(id != null && !id.isEmpty()) {
			usuario = usuarioService.obterPorId(Long.parseLong(id));
			request.setAttribute("cadastro",usuario);
		}
		System.out.println("aqui");
		request.getRequestDispatcher("../cadastro.jsp").forward(request, response);
	}
	

}
