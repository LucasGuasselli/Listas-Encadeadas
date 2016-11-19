/*
 * @author Lucas Guasselli
 * @since 19/11/2016
 * @version 1.0
 */
package Projeto;

public class Lista {
	private int index;
	private String nome;
	
	public Lista(int index, String nome) {
		this.index = index;
		this.nome = nome;		
	}//fecha construtor
	
	public int getIndex() {
		return index;
	}//fecha getIndex

	public String getNome() {
		return nome;
	}//getNome

	@Override
	public String toString() {
		return	"[" + index + "]" +	" " + nome + "\n";
	}//fecha toString
}//fecha classe