package exercises;

import java.util.Iterator;
import java.util.Stack;
import chapter1.*;

public class ExChapter1Part1 {

	/**
	 * @param string
	 * @return
	 * 1.3.4 �ж��ַ����������Ƿ��������
	 * �磺[()]{}{[()()]()} ����true  �� {()]����false
	 */
	public static boolean parenthese(String string){
		LinkedStack<Character> ls = new LinkedStack<>();
		
		int len = string.length();
		char c;
		for(int i = 0 ; i < len ; i++){
			c = string.charAt(i);
			ls.push(c);
			if(c == ')' && ls.size() >= 2){
				ls.pop();
				if(ls.pop() != '(')
					return false;
			}
			if(c == ']' && ls.size() >= 2){
				ls.pop();
				if(ls.pop() != '[')
					return false;
			}
			if(c == '}' && ls.size() >= 2){
				ls.pop();
				if(ls.pop() != '{')
					return false;
			}
		}
		return (ls.size() == 0);
	}
	
	/**
	 * @param n
	 * 1.3.5����10����������ӡ����2������ʽ
	 * 10����������2����һ�εõ��������Ȩ�Ķ������������һ�Σ�����0���õ����Ȩ�Ķ�������
	 */
	public static void printBinaryNum(int n){
		Stack<Integer> stack = new Stack<Integer>();
		while(n > 0){
			stack.push(n % 2); ////�������������СȨ
			n = n/2;
		}
		for(int i : stack){
			System.out.print(i); //��������������Ȩ
		}
	}
	
	/**
	 * @param <E>
	 * 1.3.6 ����һ��ջ����ת����
	 */
	public static <E> void reverseQueue(LinkedQueue<E> q){
		LinkedStack<E> s = new LinkedStack();
		while(!q.isEmpty()){
			s.push(q.pop());
		}
		while(!s.isEmpty()){
			q.push(s.pop());
		}
	}
	
	public static void main(String[] args) {
		
//		LinkedQueue<Integer> q = new LinkedQueue<>();
//		q.push(1);
//		q.push(2);
//		q.push(3);
//		Iterator<Integer> it = q.iterator();
//		while(it.hasNext()){
//			System.out.print(it.next()+";");
//		}
//		reverseQueue(q);
//		it = q.iterator();
//		while(it.hasNext()){
//			System.out.print(it.next()+";");
//		}
		
		//System.out.println(parenthese("[]{}{[()()]()}"));
		
		//printBinaryNum(3);
	}
	
}
