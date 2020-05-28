package BancoDeDados;

import java.util.List;

public class Rendimento_Pos {
	public static void RendimentoPosGraduacao(String id, String mensagem) {
		List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
		List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas(mensagem);
		String a;
		double avg = 0.0;
		for (Aluno aluno : alunos) {
			a = aluno.getId();
			if (a.equals(id)) {
				for (Notas_alunos not : notas) {
					if (not.getId().equals(aluno.getId())) {

						if (not.getRep() > not.getNp1() || not.getRep() > not.getNp2()) {
							if (not.getNp1() > not.getNp2()) {
								avg = (not.getNp1() + not.getRep()) / 2;
								
							} else if (not.getNp2() > not.getNp1()) {
								avg = (not.getNp2() + not.getRep()) / 2;
							}
						}

						System.out.println("O aluno " + aluno.getNome() + ", teve as seguintes notas." + "\nNP1: "
								+ not.getNp1() + "\nNP2: " + not.getNp2() + "\nReposição: " + not.getRep() + "\nExame: "
								+ not.getExam());
						System.out.println("--------------------------------------------------------");
						System.out.println("A média do aluno " + aluno.getNome() + " é " + avg);
						
						if (avg >= 5.0) {
							System.out.println("Aluno foi aprovado!!");
						} else {
							double avg2 = (avg + not.getExam()) / 2;
							if (avg2 >= 5.0) {
								System.out.println("Aluno foi aprovado!! pos");
							} else {
								System.out.println("Reprovado!");
							}
						}

					}
				}
			}
		}
	}
}
