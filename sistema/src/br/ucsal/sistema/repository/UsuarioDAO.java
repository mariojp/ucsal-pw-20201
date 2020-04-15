package br.ucsal.sistema.repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import br.ucsal.sistema.model.Papel;
import br.ucsal.sistema.model.Usuario;
import br.ucsal.sistema.util.BancoUtil;


/**
 * 
 * 
 * Data Access Object - DAO
 * 
 * View
 * ________________
 * 
 * Negocio
 * ________________
 * 
 * Dados - DAO
 * ________________
 * 
 * Banco de Dados (SGBD)
 * 
 * 
 * @author mariojp
 *
 */
public class UsuarioDAO {
	

	
	public UsuarioDAO() {
	}
	
	
	public Usuario autenticate(String login, String senha) {
		Usuario usuario = null;
		try {
			String sql = "SELECT USUARIO_ID, LOGIN, SENHA FROM USUARIOS WHERE LOGIN=? AND SENHA=?";
			PreparedStatement statement = BancoUtil.getConnection().prepareStatement(sql);
			statement.setString(1, login);
			String pass = "";
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(senha.getBytes());
				byte[] digest = md.digest();
				pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			statement.setString(2, pass);
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
		String sql = "DELETE FROM USUARIOS WHERE USUARIO_ID=?";
		PreparedStatement statement;
		try {
			statement = BancoUtil.getConnection().prepareStatement(sql);
			statement.setLong(1, usuario.getId());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario update(Usuario usuario) {
		String sql = "UPDATE USUARIOS SET LOGIN=?, SENHA=? WHERE USUARIO_ID=?";
		PreparedStatement statement;
		try {
			statement = BancoUtil.getConnection().prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			String pass = "";
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(usuario.getSenha().getBytes());
				byte[] digest = md.digest();
				pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			statement.setString(2, pass);
			statement.setLong(3, usuario.getId());
			statement.execute();
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;	}
	
	public Usuario findById(Long id) throws SQLException {
		String sql = "SELECT USUARIO_ID, LOGIN, PAPEL_ID_FK, NOME, DESCRICAO FROM USUARIOS, PAPEIS WHERE USUARIO_ID=? AND USUARIOS.PAPEL_ID_FK = PAPEIS.PAPEL_ID;";
		PreparedStatement statement = BancoUtil.getConnection().prepareStatement(sql);
		statement.setLong(1, id);
		ResultSet resultSet =  statement.executeQuery();
		Usuario usuario = null;
		if(resultSet.next()) {
			usuario = new Usuario();
			usuario.setId(resultSet.getLong("USUARIO_ID"));
			usuario.setLogin(resultSet.getString("LOGIN"));
			Long idpapel = resultSet.getLong("PAPEL_ID_FK");
			Papel papel = new Papel();
			papel.setId(idpapel);
			papel.setNome(resultSet.getString("NOME"));
			papel.setDescricao(resultSet.getString("DESCRICAO"));
			usuario.setPapel(papel);
		}
		resultSet.close();
		statement.close();
		return usuario;
	}
	
	public Usuario save(Usuario usuario) {
		String sql = "INSERT INTO USUARIOS (LOGIN, SENHA, PAPEL_ID_FK) VALUES (?,?,?)";
		PreparedStatement statement;
		try {
			statement = BancoUtil.getConnection().prepareStatement(sql,new String[] { "USUARIO_ID" });
			statement.setString(1, usuario.getLogin());
			String pass = "";
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(usuario.getSenha().getBytes());
				byte[] digest = md.digest();
				pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			statement.setString(2, pass);
			statement.setLong(3, usuario.getPapel().getId());
			statement.execute();
			
		    try (ResultSet rs = statement.getGeneratedKeys()) {
		        if (rs.next()) {
		        	System.out.println("****");
		            System.out.println(rs.getLong(1));
		        }
		    }catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}


	public List<Usuario> list() throws SQLException {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT USUARIO_ID, LOGIN, PAPEL_ID_FK, NOME, DESCRICAO FROM USUARIOS, PAPEIS WHERE USUARIOS.PAPEL_ID_FK = PAPEIS.PAPEL_ID;";
		PreparedStatement statement = BancoUtil.getConnection().prepareStatement(sql);
		ResultSet resultSet =  statement.executeQuery();
		while(resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getLong("USUARIO_ID"));
			usuario.setLogin(resultSet.getString("LOGIN"));
			Long idpapel = resultSet.getLong("PAPEL_ID_FK");
			Papel papel = new Papel();
			papel.setId(idpapel);
			papel.setNome(resultSet.getString("NOME"));
			papel.setDescricao(resultSet.getString("DESCRICAO"));
			usuario.setPapel(papel);
			lista.add(usuario);
		}
		resultSet.close();
		statement.close();
		return lista;
	}

	
	

}
