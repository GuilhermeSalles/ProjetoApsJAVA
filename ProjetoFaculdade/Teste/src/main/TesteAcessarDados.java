package main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteAcessarDados {

	public static void main(String[] args) {
		// A linha abaixo procura o arquivo no micro
		String CsvArquivo = "/Users/guilhermebaltazar/Downloads/01/ALPOO_GRADUACAO_2018.csv";

		BufferedReader conteudoCsv = null;

		String linha = "";
		// Será separado os conteudo quando ouver ";".
		String CsvSeparador = ";";

		System.out.println();

		try {

			conteudoCsv = new BufferedReader(new FileReader(CsvArquivo));
			// Neste while ele irá rodar até que o conteudoCsv não for nulo
			// e já organizando como deve ser a saida do arquivo lido.
			while ((linha = conteudoCsv.readLine()) != null) {

				String[] pos = linha.split(CsvSeparador);
				System.out.println(" Id: " + pos[0] + " Np1: " + pos[1] + " Np2: " + pos[2] + " Nota reposição: "
						+ pos[3] + " Exame: " + pos[4]);
				System.out.println();

			}
			// As linha abaixo fazem as verificações de erro que podem ocorrer
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!!: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice fora dos limites " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO erro: " + e.getMessage());
		} finally {
			// As linhas abaixo verificam que se o conteudo não for nulo, depois de ter
			// passado pelo While,
			// fecha o arquivo para não corromper o arquivo de alguma forma.
			if (conteudoCsv != null) {
				try {
					conteudoCsv.close();
				} catch (Exception e) {
					System.out.println("IO error: " + e.getMessage());
				}
			}
		}

	}

}
