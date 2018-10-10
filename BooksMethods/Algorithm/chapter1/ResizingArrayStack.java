package chapter1;

import java.util.Iterator;
import java.util.Stack;

import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;

public class ResizingArrayStack<E> implements Iterable<E>{

	private E[] e = (E[]) new Object[1]; //栈元素
	private int size = 0; //元素数量   
	
	public boolean isEmpty(){
		return size == 0; 
	}
	
	public int size(){
		return size;
	}
	
	private void resize(int newSize){
		E[] temp = (E[]) new Object[newSize]; //零时数组
		for(int i = 0 ;i <size ; i++)
			temp[i] = e[i];
		e = temp;
	}
	
	public void push(E newElement){
		if(size == e.length)
			resize(e.length*2); //如果数组已满，扩大数组为原来的2倍
		e[size++] = newElement;
	}
	
	public E pop(){
		E temp = e[--size]; 
		e[size] = null; //避免对象游离
		if(size > 0 && size == (e.length/4))
			resize(e.length/2); //如果元素数量少于数组长度的1/4,对半缩小数组
		return temp;
	}
	
	@Override
	public java.util.Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	//倒序迭代器
	private class ReverseArrayIterator implements Iterator<E>{

		private int i = size;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return e[--i];
		}
	}

	
	public static void main(String[] args) {
		ResizingArrayStack<String> ras = new ResizingArrayStack<>();
		ras.push("a");
		ras.push("ab");
		ras.push("ac");
		ras.push("ad");
		System.out.println("栈大小："+ras.size());
		Iterator<String> it =ras.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+";");
		}
		System.out.println("\n 被移除元素："+ras.pop());
		System.out.println("栈大小："+ras.size());
		Iterator<String> it2 =ras.iterator();
		while(it2.hasNext()){
			System.out.print(it2.next()+";");
		}
		Stack s = new Stack();
		s.add(null);
	}
	
}
