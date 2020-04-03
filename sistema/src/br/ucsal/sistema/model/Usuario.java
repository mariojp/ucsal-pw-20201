package br.ucsal.sistema.model;


public class Usuario /* extends Object */ {

	private Long id;

	private String login;

	private String senha;
	
	private String  papel;
	
	
	public Usuario() {
	}


	public Usuario(String login, String senha) {
		this(login, senha, "USUARIO");
	}
	
	
	public Usuario(String login, String senha, String papel) {
		this.login = login;
		this.senha = senha;
		this.papel = papel;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

}
