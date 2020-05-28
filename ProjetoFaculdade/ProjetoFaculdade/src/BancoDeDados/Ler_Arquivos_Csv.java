package BancoDeDados;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Ler_Arquivos_Csv {

//=========================================================================================================//	
	public static List<Aluno> loadAlunos() {

		List<Aluno> alunos = new ArrayList<>();

		InputStream is;
		InputStreamReader isr;
		BufferedReader br;

		try {
			is = new FileInputStream("/Users/guilhermebaltazar/Downloads/01/alunos.csv");
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);

			String linha;
			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split("\\;");
				String id = palavras[0];
				String nome = palavras[1];

				Aluno aluno = new Aluno(id, nome);
				alunos.add(aluno);
			}

			br.close();
			isr.close();
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!!: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice fora dos limites " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO erro: " + e.getMessage());
		}

		return alunos;

	}

//=========================================================================================================//	
	public static List<Curso> loadCursos() {

		List<Curso> cursos = new ArrayList<>();

		InputStream is;
		InputStreamReader isr;
		BufferedReader br;

		try {
			is = new FileInputStream("/Users/guilhermebaltazar/Downloads/01/cursos.csv");
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);

			String linha;
			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split("\\;");
				String nome = palavras[0];
				String nivel = palavras[1];
				String ano = palavras[2];

				Curso curso = new Curso(nome, nivel, Integer.parseInt(ano));
				cursos.add(curso);
			}

			br.close();
			isr.close();
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!!: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice fora dos limites " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO erro: " + e.getMessage());
		}

		return cursos;

	}

//=========================================================================================================//
	public static List<Notas_alunos> loadNotas(String mensagem) {

		List<Notas_alunos> notas = new ArrayList<>();

		InputStream is;
		InputStreamReader isr;
		BufferedReader br;

		try {
			is = new FileInputStream("/Users/guilhermebaltazar/Downloads/01/Cursos csv/"+ mensagem+".csv");
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);

			String linha;
			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split("\\;");
				String id = palavras[0];
				String np1 = palavras[1];
				String np2 = palavras[2];
				String rep = palavras[3];
				String exa = palavras[4];

				Notas_alunos nota = new Notas_alunos(id, Double.parseDouble(np1), Double.parseDouble(np2),
						Double.parseDouble(rep), Double.parseDouble(exa));
				notas.add(nota);
			}

			br.close();
			isr.close();
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!!: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice fora dos limites " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO erro: " + e.getMessage());
		}

		return notas;

	}
// =========================================================================================================//

	public static List<Notas_alunos> loadNotaMenos(String iD,String mensagem) {

		List<Notas_alunos> notas = new ArrayList<>();

		InputStream is;
		InputStreamReader isr;
		BufferedReader br;

		try {
			is = new FileInputStream("/Users/guilhermebaltazar/Downloads/01/Cursos csv/"+  mensagem +".csv");
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);

			String linha;
			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split("\\;");
				String id = palavras[0];
				String np1 = palavras[1];
				String np2 = palavras[2];
				String rep = palavras[3];
				String exa = palavras[4];

				Notas_alunos nota = new Notas_alunos(id, Double.parseDouble(np1), Double.parseDouble(np2),
						Double.parseDouble(rep), Double.parseDouble(exa));
				if (id.equals(iD)) {

				} else {
					notas.add(nota);
				}
			}

			br.close();
			isr.close();
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!!: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice fora dos limites " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO erro: " + e.getMessage());
		}

		return notas;

	}

}
