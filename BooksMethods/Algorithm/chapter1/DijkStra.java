package chapter1;

import java.util.Stack;

import com.sun.org.apache.xml.internal.utils.SuballocatedIntVector;

/**
 * @author DELL
 *˫ջ�������ʽ��ֵ�㷨
 */
public class DijkStra {

	public static void method(String string){
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		int len = string.length();
		for(int i=0;i<len;i++){
			String temp = String.valueOf(string.charAt(i));
			if("(".equals(temp)) ;
			else if("+".equals(temp)) ops.push(temp);
			else if("-".equals(temp)) ops.push(temp);
			else if("*".equals(temp)) ops.push(temp);
			else if("/".equals(temp)) ops.push(temp);
			else if(")".equals(temp)){
				String op = ops.pop();
				System.out.print("ִ�в�����"+op+";");
				
				double v = vals.pop();
				if("+".equals(op)) v=vals.pop()+v;
				else if("-".equals(op)) v=vals.pop()-v;
				else if("*".equals(op)) v=vals.pop()*v;
				else if("/".equals(op)) v=vals.pop()/v;
				System.out.println("�õ����:"+v);
				vals.push(v);
			}
			else{
				System.out.println(temp);
				vals.push(Double.parseDouble(temp));
			};
		}
	}
	
	public static void main(String[] args) {
		method("(1+((2+3)*(4*5)))");
	}
	
	
}
