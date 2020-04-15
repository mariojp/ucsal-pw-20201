package br.ucsal.sistema.model;

public class Papel {

	private Long id;

	private String nome;
	
	private String descricao;
	
	public Papel(Long id) {
		this.id = id;
	}

	public Papel() {
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
