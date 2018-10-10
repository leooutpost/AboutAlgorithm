package chapter1;

import java.util.Iterator;
import java.util.Stack;

import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;

public class ResizingArrayStack<E> implements Iterable<E>{

	private E[] e = (E[]) new Object[1]; //ջԪ��
	private int size = 0; //Ԫ������   
	
	public boolean isEmpty(){
		return size == 0; 
	}
	
	public int size(){
		return size;
	}
	
	private void resize(int newSize){
		E[] temp = (E[]) new Object[newSize]; //��ʱ����
		for(int i = 0 ;i <size ; i++)
			temp[i] = e[i];
		e = temp;
	}
	
	public void push(E newElement){
		if(size == e.length)
			resize(e.length*2); //���������������������Ϊԭ����2��
		e[size++] = newElement;
	}
	
	public E pop(){
		E temp = e[--size]; 
		e[size] = null; //�����������
		if(size > 0 && size == (e.length/4))
			resize(e.length/2); //���Ԫ�������������鳤�ȵ�1/4,�԰���С����
		return temp;
	}
	
	@Override
	public java.util.Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	//���������
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
		System.out.println("ջ��С��"+ras.size());
		Iterator<String> it =ras.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+";");
		}
		System.out.println("\n ���Ƴ�Ԫ�أ�"+ras.pop());
		System.out.println("ջ��С��"+ras.size());
		Iterator<String> it2 =ras.iterator();
		while(it2.hasNext()){
			System.out.print(it2.next()+";");
		}
		Stack s = new Stack();
		s.add(null);
	}
	
}
