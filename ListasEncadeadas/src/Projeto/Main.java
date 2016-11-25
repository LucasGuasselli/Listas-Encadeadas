/*
 * @author Lucas Guasselli
 * @since 19/11/2016
 * @version 1.0
 */

package Projeto;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try {
			(new Main()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}//fecha try-catch
	}//fecha main
	
	Parser<Lista> parserList = new ListaParser();
	
	private void run() throws FileNotFoundException {
		Menu menu = new Menu();
		ListaEncadeada lista = new ListaEncadeada();
		//importando informacoes dos arquivos csv
		importarArquivo("src/arquivos/nomes.csv", lista, parserList);
		
		Opcao verNomes = new Opcao("Ver Nomes");
		Opcao remove = new Opcao("Remover nome");
		Opcao add = new Opcao("Adicionar nome");
		Opcao sair = new Opcao("Sair");

		menu.addOption(verNomes);
		menu.addOption(remove);
		menu.addOption(add);
		menu.addOption(sair);
	
		
		Iterador iter = lista.iterator();
		
		
		System.out.println("chegou aqui");
		
		try{
			do {
				System.out.println("\nMenu: \n");
				menu.show();
				
			switch (menu.getOption()) {
				case 1:
					lista.print();
					break;
				case 2:
					usaNext(iter,Integer.parseInt(Digita("Digite um indice da lista")));
					
					iter.remove();
					
					break;
				case 3:
					Lista list = new Lista(Integer.parseInt(Digita("Digite um numero:")),
							Digita("Digite um nome:"));
					try{
						usaNext(iter,Integer.parseInt(Digita("Digite um indice da lista")));
					}catch(Exception e){
						System.out.println("ERRO!! Você digitou um numero maior que a quantidade de nos da lista encadeada!!!");
					}//fecha try-catch
					iter.insert(list.getIndex() + "-" + list.getNome());
					break;
				default:
					System.exit(0);
				}//fecha switch
			
				} while (true);
			}catch(Exception e){
				System.out.println("ERRO!!");
		}//fecha try-catch
		
	}//fecha run
	
	private void usaNext(Iterador iter,int num ){
		for(int i = 0;i<=num;i++){
			iter.next();
		}//fecha for
		//iter = iter.append(dado);;
	}//fecha usaNext
	
	public String Digita(String texto){
		Scanner ler = new Scanner(System.in);
		
			System.out.println(texto);
			return ler.next();
	}//fecha digita
	
	private void importarArquivo(String arquivo,ListaEncadeada lista, Parser parser) throws FileNotFoundException {
		//Parser<Object> parse = new ObjectParser();
		CSVReader<Lista> reader = new CSVReader<>(arquivo, parser);
		reader.skipLine(); //se houver cabeçalho cabecalho
		
		while (reader.hasNext()) {
			Lista dados = reader.readObject();
			lista.append(dados.getIndex() + " - " + dados.getNome());
		}//fecha while		
		reader.close();
	}//fecha verArquivo
	
	
}//fecha classe