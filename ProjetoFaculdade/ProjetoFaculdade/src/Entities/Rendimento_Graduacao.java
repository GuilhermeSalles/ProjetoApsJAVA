package Entities;

import java.util.List;

import BancoDeDados.Ler_Arquivos_Csv;

public class Rendimento_Graduacao {

	public void RendimentoGraduacao(String id, String mensagem, String nivel, int ano) {
		List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
		List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas(mensagem, nivel, ano);
		String a;

		for (Aluno aluno : alunos) {
			double avg = 0;
			a = aluno.getId();
			if (a.equals(id)) {
				for (Notas_alunos nota : notas) {
					if (nota.getId().equals(aluno.getId())) {

						if (nota.getRep() > nota.getNp1() || nota.getRep() > nota.getNp2()) {
							if (nota.getNp1() > nota.getNp2()) {
								avg = (nota.getNp1() + nota.getRep()) / 2;

							} else if (nota.getNp2() > nota.getNp1()) {
								avg = (nota.getNp2() + nota.getRep()) / 2;

							} else if (nota.getNp1() == nota.getNp2()) {
								avg = (nota.getNp1() + nota.getNp2()) / 2;

							}
						}

						System.out.println("O aluno " + aluno.getNome() + ", teve as seguintes notas." + "\nNP1: "
								+ nota.getNp1() + "\nNP2: " + nota.getNp2() + "\nReposição: " + nota.getRep()
								+ "\nExame: " + nota.getExam());
						System.out.println("--------------------------------------------------------");

						if (avg >= 7.0) {
							System.out.println("A média do aluno " + aluno.getNome() + " é " + avg);
							System.out.println("Aluno foi aprovado!!");
						} else {
							double avg2 = (avg + nota.getExam()) / 2;
							if (avg2 >= 5.0) {
								System.out.println("A média do aluno " + aluno.getNome() + " é " + avg2);
								System.out.println("Aluno foi aprovado!!");
							} else {
								System.out.println("A média do aluno " + aluno.getNome() + " é " + avg2);
								System.out.println("Reprovado!");
							}
						}

					}
				}
			}
		}
	}

}
