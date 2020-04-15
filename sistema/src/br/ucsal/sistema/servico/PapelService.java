package br.ucsal.sistema.servico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.sistema.model.Papel;
import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.repository.PapelDAO;

public class PapelService {

	
	private PapelDAO dao = new PapelDAO();
	
	public Papel savar(Papel papel) {
		if(papel.getId()!= null) {
			papel = dao.save(papel);
		}else {
			papel = dao.update(papel);
		}
		return papel;
	}
	
	
	public void delete(Papel papel) {
		dao.delete(papel);
	}


	public List<Papel> list() {
		List<Papel> lista = new ArrayList<Papel>();
		try {
			lista =  dao.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	

}
