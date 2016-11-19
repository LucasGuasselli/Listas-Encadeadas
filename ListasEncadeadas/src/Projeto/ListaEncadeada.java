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
			node.setNext(proximo);
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
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}//fecha remove
		
	}//fecha classe listaIterator
	
	private class Node {
		public final String dado;
		private Node next;
		private Node previous;
		
		public Node(String dado) {
			this.dado = dado;
			this.next = null;
			this.previous = null;
		}//fecha construtor
		
		public void setNext(Node next) {
			this.next = next;
		}//fecha setNext
		
		public Node getNext() {
			return next;
		}//fecha getNext
	}//fecha classe node
	
	private Node head = null;
	private Node tail = null;

	public void append(String dado) {
		Node node = new Node(dado);
		if (tail == null) {
			head  = node;
		} else {
			tail.setNext(node);
		}
		tail  = node;
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
