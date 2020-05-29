package Entities;


public class Aluno {

	private String id;
	private String nome;
	
	public Aluno() {

	}

	public Aluno(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return "ID: " + id + " Nome: " + nome;
	}

	
	
}
