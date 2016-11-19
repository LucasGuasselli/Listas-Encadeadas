/*
 * @author Lucas Guasselli
 * @since 19/11/2016
 * @version 1.0
 */
package Projeto;
import java.util.Scanner;

public class ListaParser implements Parser<Lista> {
		
	public Lista parse(String dados) {		
		Scanner scanner = new Scanner(dados);
		
		scanner.useDelimiter(";");
		int index = scanner.nextInt();
		String nome = scanner.next();
		
		Lista lista = new Lista(index, nome);
		
		scanner.close();
		return lista;
	}//fecha lista	
}//fecha listaParser