package br.ucsal.sistema.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.DatatypeConverter;



/**
 * 
 * 
 * @author mariojp
 *
 * 
 */
public class BancoUtil {

	/**
	 * 
	 * 
	 */
	private static Connection connection; 
	
	
	/**
	 * 
	 * 
	 */
	static {
		
		Statement statement = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			//MEMORIA
			connection = DriverManager.getConnection("jdbc:hsqldb:mem:.", "sa", "");
			
			//FILE STANDALONE
			//connection = DriverManager.getConnection("jdbc:hsqldb:file:/Users/mariojp/eclipse-wp/2020-01-PW/sistema/banco/sistema.db", "sa", "");
			
			//MODO SERVER
			//java -cp ./hsqldb.jar org.hsqldb.server.Server --database.0 file:sistema.db --dbname.0 banco
			//connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/banco", "sa", "");
			
			System.out.println("CONECTOU NO BANCO");
			
			//CRIAR ESTRUTURA DO BANCO
			statement = connection.createStatement();
			statement.execute("CREATE TABLE PAPEIS ( PAPEL_ID INTEGER IDENTITY PRIMARY KEY, NOME varchar(100) NOT NULL , DESCRICAO varchar(500) NOT NULL ) ");
			statement.execute("CREATE TABLE USUARIOS ( USUARIO_ID INTEGER IDENTITY PRIMARY KEY, LOGIN varchar(100) NOT NULL , SENHA varchar(100) NOT NULL, PAPEL_ID_FK INTEGER, FOREIGN KEY (PAPEL_ID_FK) REFERENCES PAPEIS(PAPEL_ID));");
			System.out.println("TABELAS OK");
			
			statement.execute("INSERT INTO PAPEIS ( NOME, DESCRICAO ) VALUES ('ADMINISTRADOR', 'É O ADMIN')");
			statement.execute("INSERT INTO PAPEIS ( NOME, DESCRICAO ) VALUES ('MOTORISTA', 'É O MOTORISTA')");
			statement.execute("INSERT INTO PAPEIS ( NOME, DESCRICAO ) VALUES ('PASSAGEIRO', 'É O PASSAGEIRO')");
			System.out.println("PAPEIS OK");
			
			String pass = "";
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update("1234".getBytes());
				byte[] digest = md.digest();
				pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			System.out.println(pass);

			statement.execute("INSERT INTO USUARIOS ( LOGIN, SENHA, PAPEL_ID_FK ) VALUES ('pedro','"+pass+"',1)");
			statement.execute("INSERT INTO USUARIOS ( LOGIN, SENHA, PAPEL_ID_FK ) VALUES ('maria','"+pass+"',1)");
			System.out.println("USUARIOS OK");
			
			statement.close();
			
			
		} catch (SQLException e) {
			System.out.println("ERRO AO CARREGAR O BANCO= "+e.getMessage());
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}
	

	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	
}
