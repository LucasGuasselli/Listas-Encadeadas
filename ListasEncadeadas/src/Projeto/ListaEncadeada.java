/*
 * @author Lucas Guasselli
 * @since 19/11/2016
 * @version 1.0
 */
package Projeto;

public class ListaEncadeada implements Iterable<String> {

	private class ListaIterator implements Iterador {

		private Node current = null;
		private Node previous = null;
		private Node next = null;
		
		public Node devolveHead(){
			return head;
		}
		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}//fecha hasNext

		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				previous = current;
				current = current.getNext();
			}
			return current.dado;
		}//fecha next

		@Override
		public void insert(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			Node node = new Node(dado);
			node.setDado(dado);
			node.setNext(current);
			if (previous == null) {
				head = node;
			} else {
				previous.setNext(node);
			}//fecha if-else
		}//fecha insert
		
		@Override
		public void append(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			
			Node node = new Node(dado);
			Node proximo = current.getNext();
			Node anterior = current.getPrevious();
			
			node.setDado(dado);
			node.setNext(proximo);
			node.setPrevious(anterior);
			current.setNext(node);
			
			if (proximo == null) {
				tail = node;
			}
		}//fecha append
		
		@Override
		public void remove() {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			
			previous.setNext(current.getNext());
			current.next.setPrevious(current.getPrevious());
			//current.setNext(current);
			//current.setPrevious(current);
			
			/*prev = elo.previous
				    next = elo.next
				    prev.next = next
				    next.previous = prev
				    */
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}//fecha remove
		
	}//fecha classe listaIterator
	
	private class Node {
		private String dado;
		private Node next;
		private Node previous;
		
		public Node(String dado) {
			this.dado = dado;
			this.next = null;
			this.previous = null;
		}//fecha construtor
		
		public void setDado(String dado){
			this.dado = dado;
		}//fecha setDado
		
		public void setNext(Node next) {
			this.next = next;
		}//fecha setNext
		
		public void setPrevious(Node previous) {
			this.previous = previous;
		}//fecha setNext
		
		public String getDado(){
			return this.dado;
		}//fecha getDado
		
		public Node getNext() {
			return next;
		}//fecha getNext
		
		public Node getPrevious() {
			return previous;
		}//fecha getNext
	}//fecha classe node
	
	private Node head = null;
	private Node tail = null;
	private Node anterior = null;
	private boolean testaHead = false;

	public Node getHead() {
		return head;
	}//fecha getHead

	public void setHead(Node head) {
		this.head = head;
	}//fecha setHead

	public Node getTail() {
		return tail;
	}//fecha getTail

	public void setTail(Node tail) {
		this.tail = tail;
	}//fecha setTail

	public void append(String dado) {
		Node node = new Node(dado);
		node.setDado(dado);
		if (head == null) {
			head  = node;
		} else {
			if(!testaHead){
				head.setNext(node);
				node.setPrevious(head);
				anterior = node;
			}else{
				node.setPrevious(anterior);
				anterior = node;
			}
			tail.setNext(node);
			testaHead = true;
		}
		tail = node;
	}//fecha append


	public void pushFront(String dado) {
		Node node = new Node(dado);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
	}//fecha pushFront

	public void printBack() {
		Node iter = tail;
		while (iter != null) {
			System.out.println(iter.dado);
			iter = iter.getPrevious();
			System.out.println(iter.getPrevious());
		}
	}//fecha print
	
	public void print() {
		Node iter = head;
		while (iter != null) {
			System.out.println(iter.dado);
			iter = iter.getNext();
		}
	}//fecha print

	
	
	@Override
	public Iterador iterator() {
		return new ListaIterator() ;
	}//fecha iterator

}//fecha classe listaEncadead
