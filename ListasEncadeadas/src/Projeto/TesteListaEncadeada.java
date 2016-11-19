/*
 * @author Lucas Guasselli
 * @since 19/11/2016
 * @version 1.0
 */

package Projeto;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TesteListaEncadeada {

	public static void main(String[] args) {
		try {
			(new TesteListaEncadeada()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}//fecha try-catch
	}//fecha main
	
	Parser<Lista> parserList = new ListaParser();
	
	private void run() throws FileNotFoundException {
		ListaEncadeada lista = new ListaEncadeada();
		//importando informacoes dos arquivos csv
		importarArquivo("src/arquivos/nomes.csv", lista, parserList);
	
		
		
		
	}//fecha run
		
	private void importarArquivo(String arquivo,ListaEncadeada lista, Parser parser) throws FileNotFoundException {
		//Parser<Object> parse = new ObjectParser();
		CSVReader<Lista> reader = new CSVReader<>(arquivo, parser);
		reader.skipLine(); //se houver cabeçalho cabecalho
		
		while (reader.hasNext()) {
			Lista dados = reader.readObject();
			lista.append(dados.getIndex() + " - " + dados.getNome());
		}//fecha while
		lista.print();
		reader.close();
	}//fecha verArquivo
	
	
	
	/*public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.append("Rafael");
		lista.append("Antonio");
		lista.append("Guilherme");
		lista.append("Ivonei");
		lista.pushFront("Aline");
		
		Iterador iter = lista.iterator();
		iter.next();
		iter.next();
		iter.append("Quarto");
		iter.insert("Segundo");

		for (String s : lista) {
			System.out.println(s);
		}//fecha foreach
		
	}//fecha main
*/
}//fecha classe
