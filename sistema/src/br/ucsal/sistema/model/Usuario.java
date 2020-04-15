package br.ucsal.sistema.model;

/**
 * 
 *  - - - - - Dependnecia
 *  - - - - -> Dependnecia + Navegação
 *  
 * ---------- Associação
 * ---------- Associação + Navegação
 *
 * 
 * Modelo
 * -------------------      
 * |     Usuario     |       -----------------------
 * -------------------       |         Papel       |
 * |- id : Long      |       -----------------------
 * |- login : String |------>| - nome: String      |
 * |- senha : String |       | - descricao: String |
 * |- papel : Papel  |       -----------------------
 * -------------------
 * 
 * 
 * @author mariojp
 *
 */
public class Usuario /* extends Object */ {

	private Long id;

	private String login;
	
	private String senha;
	
	private Papel  papel;
	
	
	public Usuario() {
	}


	public Usuario(String login, String senha) {
		this(login, senha, new Papel(1l));
	}
	
	public Usuario(String login, String senha, Papel papel) {
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

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}








}
