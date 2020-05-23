package TelaPrincipal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import BancoDeDados.Aluno;
import BancoDeDados.Curso;
import BancoDeDados.Escrever_Arquivo_Csv;
import BancoDeDados.Ler_Arquivos_Csv;
import BancoDeDados.Notas_alunos;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);

		String respDo;
		System.out.println();
		do {
			System.out.println("-------------Bem vindo ao sistema-------------");
			System.out.println("  ------------------------------------------");
			System.out.printf("     1 >> Adicionar um aluno. " + "\n     2 >> Adicionar um curso novo. "
					+ "\n     3 >> Listar o histórico de um determinado aluno." + "\n"
					+ "     4 >> Para ver a lista de Cursos, Aluno etc..." + "\n     5 >> Adcionar novo aluno.\n");

			System.out.print("Escolha qual operação deseja fazer: ");

			int resposta = sc.nextInt();
			System.out.println();

			if (resposta == 1) {
				List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
				System.out.println("----------------------------------------------");
				System.out.println("Digite os seguintes dados.");
				System.out.print("Digite o Id do aluno: ");
				String id = sc.next();
				System.out.print("Digite o nome do Aluno: ");
				sc.nextLine();
				String nome = sc.nextLine();
				alunos.add(new Aluno(id, nome));
				Escrever_Arquivo_Csv.save_Aluno(alunos);

				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Quer que seja mostrada a lista de todos os alunos já adicionados?? [Sim/Não]");
				String resp = sc.next();
				System.out.println("----------------------------------------------------------------------------");
				if (resp.toLowerCase().substring(0, 1).contentEquals("s")) {

					for (Aluno aluno : alunos) {
						Thread.sleep(1000);
						System.out.println(aluno);
					}
				}
			} else if (resposta == 2) {
				List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();
				System.out.println("----------------------------------------------");
				System.out.println("Digite os seguintes dados.");
				System.out.print("Digite o nome do curso: ");
				String nome = sc.next();
				System.out.print("Digite o nivel se é 'graduação ou pós-graduação': ");
				sc.nextLine();
				String nivel = sc.nextLine();
				System.out.print("Digite o ano que o curso começou: ");
				int ano = sc.nextInt();
				cursos.add(new Curso(nome, nivel, ano));
				Escrever_Arquivo_Csv.save_Curso(cursos);

				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Quer que seja mostrada a lista de todos os cursos já adicionados?? [Sim/Não]");

				String resp = sc.next();
				System.out.println("----------------------------------------------------------------------------");
				if (resp.toLowerCase().substring(0, 1).contentEquals("s")) {
					for (Curso curso : cursos) {
						Thread.sleep(1000);
						System.out.println(curso);
					}
				}
			} else if (resposta == 3) {
				List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas();
				Notas_alunos not = new Notas_alunos();
				System.out.println("----------------------------------------------");
				System.out.println("Digite os seguintes dados.");
				System.out.print("Digite o ID do aluno que quer adicionar a nota: ");
				String id = sc.next();
				not.notas_do_Aluno(id);

				System.out.println("----------------------------------------------------------------------------");
				System.out.println(
						"Quer que seja mostrada a lista de todos os alunos e notas já adicionados?? [Sim/Não]");

				String resp = sc.next();
				System.out.println("----------------------------------------------------------------------------");
				if (resp.toLowerCase().substring(0, 1).contentEquals("s")) {
					for (Notas_alunos nota : notas) {
						Thread.sleep(1000);
						System.out.println(nota);
					}
				}
			} else if (resposta == 4) {
				System.out.println("----------------------------------------------");
				System.out.println("Quer que seja listado o que especificamente??");
				System.out.println();
				System.out.printf("     1 >> Listas dos alunos. " + "\n     2 >> Lista dos cursos. "
						+ "\n     3 >> Lista de determinado aluno." + "\n"
						+ "     4 >> Listar relatório de rendimento de cada curso.\n");

				System.out.print("Escolha qual operação deseja fazer: ");
				int resposta2 = sc.nextInt();
				System.out.println();

				if (resposta2 == 1) {
					System.out.println("----------------------------------------------");
					List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();

					for (Aluno aluno : alunos) {
						Thread.sleep(1000);
						System.out.println(aluno);
					}
				} else if (resposta2 == 2) {
					System.out.println("----------------------------------------------");
					List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();

					for (Curso curso : cursos) {
						Thread.sleep(1000);
						System.out.println(curso);
					}
				} else if (resposta2 == 3) {
					System.out.println("Qual o Id :");
					String id = sc.next();
					Notas_alunos notas = new Notas_alunos();
					notas.notas_do_Aluno(id);
				}
			} else if (resposta == 5) {
				String reset = null;
				do {
					System.out.print("Digite o Id Do aluno novo ou aluno quer queira mudar:");
					String id = sc.next();

					List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas();

					for (Notas_alunos not : notas) {
						if (id.equals(not.getId())) {
							System.out.println("Este aluno já existe.");
							System.out.print("deseja alterar as notas deste aluno? [Sim/Não]");
							String respos = sc.next();
							if (respos.toLowerCase().substring(0, 1).contentEquals("s")) {
								List<Notas_alunos> notas1 = Ler_Arquivos_Csv.loadNotaMenos(id);
								System.out.print("Digite a np1:");
								double np1 = sc.nextDouble();
								while(np1 < 0 || np1 > 10) {
									System.out.print("Digite a np1 novamente:");
									np1 = sc.nextDouble();
								}
								System.out.print("Digite a np2:");
								double np2 = sc.nextDouble();
								while(np2 < 0 || np2 > 10) {
									System.out.print("Digite a np2 novamente:");
									np2 = sc.nextDouble();
								}
								System.out.print("Digite a rep:");
								double rep = sc.nextDouble();
								while(rep < 0 || rep > 10) {
									System.out.print("Digite a rep novamente:");
									rep = sc.nextDouble();
								}
								System.out.print("Digite a exame:");
								double exam = sc.nextDouble();
								while(exam < 0 || exam > 10) {
									System.out.print("Digite a np1 novamente:");
									exam = sc.nextDouble();
								}
								Notas_alunos nota = new Notas_alunos();
								nota = new Notas_alunos(id, np1, np2, rep, exam);
								notas1.add(nota);
								Escrever_Arquivo_Csv.save_Alunos(notas1);
							} else {
								reset = "1";
							}
						}
					}
				} while (reset == "1");

			}
			System.out.println();
			System.out.println("Deseja continuar usando o sistema?? [Sim/Não]");
			respDo = sc.next();
			System.out.println();
		} while (respDo.toLowerCase().substring(0, 1).contentEquals("s"));
		System.out.println("byeeee");
		sc.close();
	}
}
