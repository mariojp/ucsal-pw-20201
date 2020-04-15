package br.ucsal.sistema.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.sistema.model.Papel;
import br.ucsal.sistema.util.BancoUtil;

public class PapelDAO {

	public Papel save(Papel papel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Papel update(Papel papel) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Papel papel) {
		// TODO Auto-generated method stub
		
	}

	public List<Papel> list() throws SQLException {
		List<Papel> lista = new ArrayList<>();
		String sql = "SELECT PAPEL_ID, NOME, DESCRICAO FROM PAPEIS;";
		PreparedStatement statement = BancoUtil.getConnection().prepareStatement(sql);
		ResultSet resultSet =  statement.executeQuery();
		while(resultSet.next()) {
			Papel papel = new Papel();
			papel.setId(resultSet.getLong("PAPEL_ID"));
			papel.setNome(resultSet.getString("NOME"));
			papel.setDescricao(resultSet.getString("DESCRICAO"));
			lista.add(papel);
		}
		resultSet.close();
		statement.close();
		return lista;
	}

}
