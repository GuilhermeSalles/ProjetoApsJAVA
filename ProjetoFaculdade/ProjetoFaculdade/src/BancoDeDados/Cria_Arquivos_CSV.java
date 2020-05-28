package BancoDeDados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Cria_Arquivos_CSV {
	public static void Criar_Arquivo(String mensagem) {
		try {

			File f = new File("/Users/guilhermebaltazar/Downloads/01/Cursos csv/" + mensagem + ".csv");

			OutputStream os = (OutputStream) new FileOutputStream(f);
			String encoding = "UTF8";
			OutputStreamWriter osw = new OutputStreamWriter(os, encoding);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
