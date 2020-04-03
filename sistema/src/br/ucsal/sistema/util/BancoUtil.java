package br.ucsal.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


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
			statement.execute("CREATE TABLE USUARIOS ( USUARIO_ID INTEGER IDENTITY, LOGIN varchar(100) NOT NULL , SENHA varchar(100) NOT NULL ) ");
			statement.execute("INSERT INTO USUARIOS ( LOGIN, SENHA ) VALUES ('pedro', '1234')");
			statement.execute("INSERT INTO USUARIOS ( LOGIN, SENHA ) VALUES ('maria', '1234')");
			statement.close();
			
			
		} catch (SQLException e) {
			System.out.println("ERRO AO CARREGAR O BANCO= "+e.getMessage());
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
