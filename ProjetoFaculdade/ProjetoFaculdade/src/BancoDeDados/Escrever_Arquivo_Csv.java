package BancoDeDados;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import Entities.Aluno;
import Entities.Curso;
import Entities.Notas_alunos;

public class Escrever_Arquivo_Csv {

//=========================================================================================================//
	public static void save_Aluno(List<Aluno> alunos) {

		OutputStream os;
		OutputStreamWriter osw;
		PrintWriter pw;

		try {
			os = new FileOutputStream("/Users/guilhermebaltazar/Downloads/01/alunos.csv");
			osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			pw = new PrintWriter(osw, true);

			for (Aluno aluno : alunos) {
				pw.println(aluno.getId() + ";" + aluno.getNome());
			}
			System.out.println("Aluno adcionado com sucesso!!");
			os.close();
			osw.close();
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//=========================================================================================================//	

	public static void save_Curso(List<Curso> cursos) {

		OutputStream os;
		OutputStreamWriter osw;
		PrintWriter pw;

		try {
			os = new FileOutputStream("/Users/guilhermebaltazar/Downloads/01/cursos.csv");
			osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			pw = new PrintWriter(osw, true);

			for (Curso curso : cursos) {
				pw.println(curso.getNome() + ";" + curso.getNivel() + ";" + curso.getAno());
			}
			System.out.println("Curso adicionado com sucesso!!");
			os.close();
			osw.close();
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//=========================================================================================================//	

// =========================================================================================================//

	public static void save_Nota_Aluno(List<Notas_alunos> notas, String mensagem, String nivel, int ano) {

		OutputStream os;
		OutputStreamWriter osw;
		PrintWriter pw;

		try {
			os = new FileOutputStream("/Users/guilhermebaltazar/Downloads/01/Cursos csv/" + mensagem + "-" + nivel + "-" + ano + ".csv");
			osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			pw = new PrintWriter(osw, true);

			for (Notas_alunos nota : notas) {
				pw.println(nota.getId() + ";" + nota.getNp1() + ";" + nota.getNp2() + ";" + nota.getRep() + ";"
						+ nota.getExam());
			}
			System.out.println("Notas adicionadas com sucesso!!");
			os.close();
			osw.close();
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//=========================================================================================================//
}
