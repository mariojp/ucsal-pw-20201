package br.ucsal.sistema.servico;

import javax.servlet.RequestDispatcher;

import br.ucsal.sistema.model.Usuario;

public class LoginService {
	
	
	//LOGICA DE NEGOCIO
	
	public Usuario login(String login, String senha) {
		Usuario usuario = null;
		
		if (login != null && login.equals(senha)){
		
			usuario = new Usuario(login, senha);

		}
		
		
		return usuario;
	}

}
