package BancoDeDados;


public class Curso {

	private String nome;
	private String nivel;
	private Integer ano;

	public Curso(String nome, String nivel, Integer ano) {
		this.nome = nome;
		this.nivel = nivel;
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", nivel=" + nivel + ", ano=" + ano + "]";
	}

}
