package chapter1;

import java.util.Iterator;

public class LinkedQueue<E> implements Iterable<E>{ //链表实现的先进先出队列

	private Node first;
	private Node last;
	private int size;
	
	private class Node{
		E data;
		Node next;
		Node(E d,Node n){
			data = d;
			next = n;
		}
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void push(E data){
		Node newLast = new Node(data,null);
		if(size == 0){
			first = last = new Node(data,null);
			size++;
			return;
		}
		last.next = newLast;
		last = newLast;
		size++;
	}
	
	public E peek(){
		return first.data;
	}
	
	public E pop(){ 
		E e = first.data;
		Node temp = first;
		first = first.next;
		temp = null; // 防止对象游离
		size--;
		return e;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<E>();
	}
	
	private class MyIterator<E> implements Iterator<E>{
		private Node cur = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur != null ;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E data = (E) cur.data;
			cur = cur.next;
			return data;
		}
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> lq = new LinkedQueue<>();
		lq.push(1);
		lq.push(5);
		lq.push(9);
		lq.push(10);
		System.out.println("---------------Iterator");
		Iterator<Integer> it = lq.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("peek():"+lq.peek());
		
		System.out.println("size:"+lq.size());
		System.out.println("---------------pop()");
		System.out.println(lq.pop());
		System.out.println(lq.pop());
		System.out.println(lq.pop());
		System.out.println(lq.pop()+"-----");
		System.out.println("size:"+lq.size());
		
		
//		lq.push(5);
//		System.out.println("size:"+lq.size());
	}

	
	
}
