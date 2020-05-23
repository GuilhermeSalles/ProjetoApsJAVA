package BancoDeDados;

import java.util.List;

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

	public void notas_do_Aluno(String id) {
		List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
		List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas();
		String a;

		for (Aluno aluno : alunos) {
			a = aluno.getId();
			if (a.equals(id)) {
				for (Notas_alunos not : notas) {
					if (not.getId().equals(aluno.getId())) {

						double avg = (not.getNp1() + not.getNp2() + not.getRep()) / 2;

						System.out.println("NP1: " + not.getNp1() + "\nNP2: " + not.getNp2() + "\nReposição: "
								+ not.getRep() + "\nExame: " + not.getExam());

						System.out.println("A média do aluno " + id + " é " + avg);
						if (avg >= 7.0) {
							System.out.println("Aluno foi aprovado!!");
						} else {
							double avg2 = (avg + not.getExam()) / 2;
							if (avg2 >= 5.0) {
								System.out.println("Aluno foi aprovado!!");
							} else {
								System.out.println("Reprovado!");
							}
						}

					}
				}
			}
		}
	}

	

	@Override
	public String toString() {
		return "Notas_alunos id: " + id + ", np1: " + np1 + ", np2: " + np2 + ", reposição:" + rep + ", exame: " + exam
				+ "]";
	}

}
