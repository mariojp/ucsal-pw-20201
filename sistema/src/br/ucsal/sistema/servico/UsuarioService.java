package br.ucsal.sistema.servico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.repository.UsuarioDAO;

public class UsuarioService {

	
	private UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario salvar(Usuario usuario) {
		if(usuario.getId() == null) {
			usuario = dao.save(usuario);
		}else {
			usuario = dao.update(usuario);
		}
		return usuario;
	}
	
	
	public void delete(Usuario usuario) {
		dao.delete(usuario);
	}


	public List<Usuario> list() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			lista =  dao.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	public Usuario obterPorId(Long id) {
		Usuario usuario = null;
		try {
			usuario = dao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	

}
