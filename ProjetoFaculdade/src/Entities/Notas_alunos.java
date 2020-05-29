package Entities;

import java.util.List;
import java.util.Scanner;

import BancoDeDados.Ler_Arquivos_Csv;

public class Notas_alunos {

	private String id;
	private Double np1;
	private Double np2;
	private Double rep;
	private Double exam;

	public Notas_alunos() {
	}

	public Notas_alunos(String id, Double np1, Double np2, Double rep, Double exam) {
		this.id = id;
		this.np1 = np1;
		this.np2 = np2;
		this.rep = rep;
		this.exam = exam;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getNp1() {
		return np1;
	}

	public void setNp1(Double np1) {
		this.np1 = np1;
	}

	public Double getNp2() {
		return np2;
	}

	public void setNp2(Double np2) {
		this.np2 = np2;
	}

	public Double getRep() {
		return rep;
	}

	public void setRep(Double rep) {
		this.rep = rep;
	}

	public Double getExam() {
		return exam;
	}

	public void setExam(Double exam) {
		this.exam = exam;
	}

	public static double myRead(String mensagem) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print(mensagem);
		double nota = sc.nextDouble();
		if (nota > 0 && nota < 10) {
			return nota;
		} else {
			while (nota < 0 || nota > 10) {
				System.out.print("Digite novamente a nota novamente: ");
				nota = sc.nextDouble();
			}
			return nota;
		}
	}

	@Override
	public String toString() {
		List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
		String aux = null;
		for (Aluno aluno : alunos) {
			aux = "--------------------------------------------------------" + "\nNotas dos alunos " + "\nid: " + id
					+ ", Nome: " + aluno.getNome() + ", np1: " + np1 + ", np2: " + np2 + ", reposição:" + rep
					+ ", exame: " + exam + "\n--------------------------------------------------------\n";
		}
		return aux;
	}

}
