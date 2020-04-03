package br.ucsal.sistema.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.util.BancoUtil;

public class UsuarioDAO {
	
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	

	
	public UsuarioDAO() {
		usuarios.add(new Usuario("pedro","1234"));
		usuarios.add(new Usuario("maria","4321"));
	}
	
	
	public Usuario autenticate(String login, String senha) {
		Usuario usuario = null;

	

		
		try {
			
			String sql = "SELECT USUARIO_ID, LOGIN, SENHA FROM USUARIOS WHERE LOGIN='"+login+"' AND SENHA='"+senha+"';";
			String sql2 = "SELECT USUARIO_ID, LOGIN, SENHA FROM USUARIOS WHERE LOGIN=? AND SENHA=?";
			System.out.println(sql);
			System.out.println(sql2);
			PreparedStatement statement = BancoUtil.getConnection().prepareStatement(sql2);
			statement.setString(1, login);
			statement.setString(2, senha);
			System.out.println(statement);
			ResultSet resultSet =  statement.executeQuery();
			if(resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getLong("USUARIO_ID"));
				usuario.setLogin(resultSet.getString("LOGIN"));
				usuario.setSenha(resultSet.getString("SENHA"));
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
		
	}
	
	
	public void delete(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		return null;
	}
	
	public Usuario findById(Long id) {
		return null;
	}
	
	public Usuario save(Usuario usuario) {
		return null;
	}
	
	

}
