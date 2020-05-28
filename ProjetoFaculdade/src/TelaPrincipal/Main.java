package TelaPrincipal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import BancoDeDados.Cria_Arquivos_CSV;
import BancoDeDados.Escrever_Arquivo_Csv;
import BancoDeDados.Ler_Arquivos_Csv;
import Entities.Aluno;
import Entities.Curso;
import Entities.Notas_alunos;
import Entities.Rendimento_Graduacao;
import Entities.Rendimento_Pos;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);

		String respDo;
		System.out.println();
		do {
			System.out.println("-------------Bem vindo ao sistema de genreciamento da faculdade-------------");
			System.out.println("  ------------------------------------------------------------------------");
			System.out.println();
			System.out.printf("         1 >> Adicionar um aluno. " + "\n         2 >> Adicionar um curso novo. "
					+ "\n         3 >> Ver o rendimento de determinado aluno." + "\n"
					+ "         4 >> Para ver a lista de Cursos, Aluno etc..."
					+ "\n         5 >> Adcionar notas de um aluno.\n");
			System.out.println();
			System.out.print("Escolha qual operação deseja fazer: ");

			int resposta = sc.nextInt();
			System.out.println();

			if (resposta == 1) {

				List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
				System.out.println("----------------------------------------------");
				System.out.println("Digite os seguintes dados.");
				System.out.println();

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
						System.out.println("-------------------------------------");
					}
				}
			} else if (resposta == 2) {
				List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();
				System.out.println("----------------------------------------------");
				System.out.println("Digite os seguintes dados.");
				System.out.println();

				System.out.print("Digite o nome do curso: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Digite o nivel se é 'graduação ou pós-graduação': ");
				String nivel = sc.nextLine();

				if (nivel.toLowerCase().substring(0, 1).contentEquals("p")) {
					nivel = "POS_GRADUACAO";
				} else if (nivel.toLowerCase().substring(0, 1).contentEquals("g")) {
					nivel = "GRADUACAO";
				}

				System.out.print("Digite o ano que o curso começou: ");
				int ano = sc.nextInt();

				cursos.add(new Curso(nome, nivel, ano));
				Escrever_Arquivo_Csv.save_Curso(cursos);
				Cria_Arquivos_CSV.Criar_Arquivo(nome, nivel, ano);

				List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas(nome, nivel, ano);
				OutputStream os;
				OutputStreamWriter osw;
				PrintWriter pw;
				Notas_alunos not = new Notas_alunos("0", 0.0, 0.0, 0.0, 0.0);
				notas.add(not);

				try {
					os = new FileOutputStream("/Users/guilhermebaltazar/Downloads/01/Cursos csv/" + nome + "-" + nivel
							+ "-" + ano + ".csv");
					osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
					pw = new PrintWriter(osw, true);

					for (Notas_alunos nota : notas) {
						pw.println(nota.getId() + ";" + nota.getNp1() + ";" + nota.getNp2() + ";" + nota.getRep() + ";"
								+ nota.getExam());
					}

					os.close();
					osw.close();
					pw.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Quer que seja mostrada a lista de todos os cursos já adicionados?? [Sim/Não]");
				String resp = sc.next();
				System.out.println("----------------------------------------------------------------------------");

				if (resp.toLowerCase().substring(0, 1).contentEquals("s")) {
					for (Curso curso : cursos) {
						Thread.sleep(1000);
						System.out.println(curso);
						System.out.println(
								"-----------------------------------------------------------------------------");
					}
				}
			} else if (resposta == 3) {
				List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();
				String mensagem = null;
				Rendimento_Graduacao rendimento_gra = new Rendimento_Graduacao();
				Rendimento_Pos rendimento_pos = new Rendimento_Pos();

				System.out.print("Qual o nome do curso que deseja ver a nota de determinado aluno: ");
				sc.nextLine();
				mensagem = sc.nextLine();
				System.out.print("Digite o nivel do curso: ");
				String nivel = sc.nextLine();
				String nivel2 = nivel.substring(0, 1);
				String NivelF = null;
				if (nivel2.toLowerCase().contentEquals("p")) {
					NivelF = "POS_GRADUACAO";
				} else if (nivel2.toLowerCase().contentEquals("g")) {
					NivelF = "GRADUACAO";
				}
				System.out.print("Digite o ano do curso: ");
				int ano = sc.nextInt();

				for (Curso curso : cursos) {
					if (curso.getNome().equals(mensagem) && curso.getNivel().equals(NivelF) && curso.getAno() == ano) {
						@SuppressWarnings("unused") // isso serve apenas para tirar o aviso de ponto de esclamação.

						List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas(mensagem, NivelF, ano);
						System.out.println("----------------------------------------------");
						System.out.println("Digite os seguintes dados.");
						System.out.println();

						System.out.print("Digite o ID do aluno que deseja ver o rendimento: ");
						String ID = sc.next();

						System.out.println("----------------------------------------------");
						List<Curso> cursos1 = Ler_Arquivos_Csv.loadCursos();
						for (Curso curso1 : cursos1) {

							if (curso1.getNome().equals(mensagem) && curso1.getNivel().equals(NivelF)
									&& curso1.getAno() == ano) {

								if (curso1.getNivel().toLowerCase().substring(0, 1).contentEquals("p")) {

									rendimento_gra.RendimentoGraduacao(ID, mensagem, NivelF, ano);
									System.out.println(
											"----------------------------------------------------------------------------");
									break;

								} else if (curso1.getNivel().toLowerCase().substring(0, 1).contentEquals("g")) {
									rendimento_pos.RendimentoPosGraduacao(ID, mensagem, NivelF, ano);
									System.out.println(
											"----------------------------------------------------------------------------");
									break;
								}
							}
						}
					}
				}

			} else if (resposta == 4) {
				System.out.println("----------------------------------------------");
				System.out.println("Quer que seja listado o que especificamente??");
				System.out.println();
				System.out.printf(
						"     1 >> Listas dos alunos já cadastrados. " + "\n     2 >> Listar cursos adicionados. \n"
								+ "     3 >> Listar alunos de determinado curso.\n");
				System.out.println();
				System.out.print("Escolha qual operação deseja fazer: ");
				int resposta2 = sc.nextInt();

				if (resposta2 == 1) {
					System.out.println("----------------------------------------------");
					List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();

					for (Aluno aluno : alunos) {
						Thread.sleep(1000);
						System.out.println(aluno);
						System.out.println("-------------------------------------");
					}
				} else if (resposta2 == 2) {
					System.out.println("----------------------------------------------");
					List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();

					for (Curso curso : cursos) {
						Thread.sleep(1000);
						System.out.println(curso);
						System.out.println(
								"-----------------------------------------------------------------------------");
					}
				} else if (resposta2 == 3) {
					System.out.println("----------------------------------------------");
					String mensagem = null;
					int ano = 0;

					System.out.println();
					List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();
					System.out.print("Qual o curso que deseja Listas os alunos: ");
					sc.nextLine();
					mensagem = sc.nextLine();
					System.out.print("Digite o nivel do curso:");
					String nivel = sc.next();
					String nivel2 = nivel.substring(0, 1);
					String NivelF = null;
					if (nivel2.toLowerCase().substring(0, 1).contentEquals("p")) {
						NivelF = "POS_GRADUACAO";
					} else if (nivel2.toLowerCase().substring(0, 1).contentEquals("g")) {
						NivelF = "GRADUACAO";
					}
					System.out.print("Digite o ano do curso: ");
					ano = sc.nextInt();

					for (Curso curso : cursos) {
						if (curso.getNome().equals(mensagem) && curso.getNivel().equals(NivelF)
								&& curso.getAno() == ano) {
							List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas(mensagem, NivelF, ano);
							List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();

							for (Notas_alunos nota : notas) {
								for (Aluno aluno : alunos) {
									if (nota.getId().equals(aluno.getId())) {
										System.out.println("Id: " + aluno.getId() + ", Nome: " + aluno.getNome());
										break;
									}
								}
							}
						}
					}
					System.out.println("----------------------------------------------");
				}
			} else if (resposta == 5) {
				String reset = null;
				String mensagem = null;
				String id = null;
				int ano = 0;

				List<Curso> cursos = Ler_Arquivos_Csv.loadCursos();
				System.out.print("Qual o curso que deseja adicionar as notas ou alterar: ");
				sc.nextLine();
				mensagem = sc.nextLine();
				System.out.print("Digite o nivel do curso:");
				String nivel = sc.nextLine();
				String nivel2 = nivel.substring(0, 1);
				String NivelF = null;
				if (nivel2.toLowerCase().substring(0, 1).contentEquals("p")) {
					NivelF = "POS_GRADUACAO";
				} else if (nivel2.toLowerCase().substring(0, 1).contentEquals("g")) {
					NivelF = "GRADUACAO";
				}
				System.out.print("Digite o ano do curso: ");
				ano = sc.nextInt();

				do {
					id = null;
					for (Curso curso : cursos) {
						if (curso.getNome().equals(mensagem) && curso.getNivel().equals(NivelF)
								&& curso.getAno() == ano) {
							List<Aluno> alunos = Ler_Arquivos_Csv.loadAlunos();
							List<Notas_alunos> notas = Ler_Arquivos_Csv.loadNotas(mensagem, NivelF, ano);
							System.out.print("Digite o Id do aluno: ");
							id = sc.next();
							for (Aluno aluno : alunos) {
								for (Notas_alunos not : notas) {
									if (id.equals(not.getId())) {

										System.out.println("Este aluno já existe.");
										System.out.print("deseja alterar as notas deste aluno? [Sim/Não]");
										String respos = sc.next();

										if (respos.toLowerCase().substring(0, 1).contentEquals("s")) {

											List<Notas_alunos> notas1 = Ler_Arquivos_Csv.loadNotaMenos(id, mensagem,
													NivelF, ano);
											double np1 = Notas_alunos.myRead("Nota da np1: ");

											double np2 = Notas_alunos.myRead("Nota a np2: ");

											double rep = Notas_alunos.myRead("Nota a rep: ");

											double exam = Notas_alunos.myRead("Nota a exame: ");

											Notas_alunos nota = new Notas_alunos();
											nota = new Notas_alunos(id, np1, np2, rep, exam);
											notas1.add(nota);
											Escrever_Arquivo_Csv.save_Nota_Aluno(notas1, mensagem, NivelF, ano);
											break;

										} else {
											reset = "1";
										}
								if (id.equals(aluno.getId())) {

											List<Notas_alunos> notas1 = Ler_Arquivos_Csv.loadNotaMenos(id, mensagem,
													NivelF, ano);
											double np1 = Notas_alunos.myRead("Nota da np1: ");

											double np2 = Notas_alunos.myRead("Nota a np2: ");

											double rep = Notas_alunos.myRead("Nota a rep: ");

											double exam = Notas_alunos.myRead("Nota a exame: ");

											Notas_alunos nota = new Notas_alunos();
											nota = new Notas_alunos(id, np1, np2, rep, exam);
											notas1.add(nota);
											Escrever_Arquivo_Csv.save_Nota_Aluno(notas1, mensagem, NivelF, ano);
											break;
										}
										break;
									}
								}
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
		System.out.println("O sistema foi encerrado!!");
		System.exit(0);
		sc.close();
	}
}
