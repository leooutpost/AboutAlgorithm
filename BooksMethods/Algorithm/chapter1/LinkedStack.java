package chapter1;

import java.util.Iterator;

/**
 * @author DELL
 *以链表形式实现栈
 */
public class LinkedStack<E> implements Iterable<E>{

	private Node<E> topNode;
	private int size = 0;
	
	private class Node<E>{
		E data;
		Node<E> nextNode;
		
		Node(E data,Node nextNode){
			this.data = data;
			this.nextNode = nextNode;
		}
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void push(E data){
		if(size == 0){
			topNode = new Node(data,null);
			size++;
			return;
		}
		
		Node oldTopNode = topNode;
		topNode = new Node(data,null);
		topNode.nextNode = oldTopNode;
		size++;
	} 
	
	public E pop(){
		E data = (E) topNode.data;
		topNode = topNode.nextNode;
		size--;
		return data;
	}
	
	public E peek(){
		return topNode.data;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<E>{
		int i = size;
		Node cur = topNode; 
		Node next = null; 

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i != 0;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			i--;
			if(i == size){
				next = cur.nextNode;
				return (E)cur.data;
			}
			cur = next;
			next = next.nextNode;
			return (E) cur.data;
		}
	}
	
	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<>();
		System.out.println(ls.size);
		ls.push("ko ");
		ls.push("no ");
		ls.push("dio ");
		ls.push("da! ");
		System.out.println("size after push:"+ls.size);
		Iterator<String> it = ls.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}







