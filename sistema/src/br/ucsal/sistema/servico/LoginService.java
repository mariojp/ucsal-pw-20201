package br.ucsal.sistema.servico;

import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.repository.UsuarioDAO;

public class LoginService {
	
	
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	
	//LOGICA DE NEGOCIO
	
	public Usuario login(String login, String senha) {
		Usuario usuario = null;
		if(login != null ) {
			usuario = dao.autenticate(login, senha);
		}		
		return usuario;
	}

}
