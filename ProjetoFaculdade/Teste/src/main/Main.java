package main;

import java.util.*;
import java.io.*;
import java.text.*;
import entities.DadosAlunos;

public class Main {

	public static void main(String[] args) {

		// Declaração dos separadores e cabeçalho
		String Separador = ";";
		String Separador_Nova_Linha = "\n";

		try {
			// SimpleDateFormat é usado para mostrar como quer que a data seja printada
			SimpleDateFormat sdf = new SimpleDateFormat("DD-mm-yyyy");

			// A linha abaixo cria uma lista que armazenaram dados tipo DadosAlunos
			List<DadosAlunos> listAlunos = new ArrayList<DadosAlunos>();

			// A linha abaixo adiciona os dados na lista
			listAlunos.add(new DadosAlunos("D8904H-8", "João Pedro", 10.00, sdf.parse("12-12-2012")));
			listAlunos.add(new DadosAlunos("D89022-2", "João Pedro", 10.00, sdf.parse("12-12-2012")));
			listAlunos.add(new DadosAlunos("D8932H-3", "João Pedro", 10.00, sdf.parse("12-12-2012")));
			listAlunos.add(new DadosAlunos("D245F6-5", "João Pedro", 10.00, sdf.parse("12-12-2012")));
			listAlunos.add(new DadosAlunos("F8932G-7", "João Pedro", 10.00, sdf.parse("12-12-2012")));
			listAlunos.add(new DadosAlunos("D89123-9", "João Pedro", 10.00, sdf.parse("12-11-2012")));

			// A linha abaixo 'mostra' ao java aonde está o arquivo que quer escrever ou
			// mudar
			FileWriter fw = new FileWriter("/Users/guilhermebaltazar/Downloads/01/ALPOO_GRADUACAO_2018.csv", true);
			// true colocado para não sobre escrever o arquivo todo, apenas adicionarq

			// As linhas abaixo pegam cada dado do aluno ( da ), e com o ( fw ) fileWriter
			// vai adicioa o separador para uma nova linha
			// e vai pegando cada dado usando o get.
			
			for (DadosAlunos da : listAlunos) {
				fw.append(Separador_Nova_Linha);
				fw.append(da.getRa());
				fw.append(Separador);
				fw.append(da.getName());
				fw.append(Separador);
				fw.append(String.valueOf(da.getNota()));
				fw.append(Separador);
				fw.append(String.valueOf(sdf.format(da.getCreantionDate())));
				fw.append(Separador);
			}
			// O flush é usado para 'falar' que quero enviar esses dados para o arquivo
			// Já o close fecha tudo para não ter problema de corromper o arquivo
			fw.flush();
			fw.close();

		} catch (Exception e) {
			// Aqui é apenas para mostrar o erro se n achar o arquivo no seu computador
			System.out.println(e.getMessage());
		}
		
		

	}

}
