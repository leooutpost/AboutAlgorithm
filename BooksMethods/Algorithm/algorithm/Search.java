package algorithm;

import java.util.Arrays;

public class Search {

	public static int rank(int[] arr ,int key){
		
		int lo = 0;
		int hi = arr.length - 1;
		
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			System.out.println(mid);
			if (key < arr[mid]) hi = mid -1;
			else if (key > arr[mid]) lo = mid + 1;
			else return mid;
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,3,4,6,2,5,7};
		Arrays.sort(a);
		for(int i : a){
			System.out.println("!"+ i);
		}
		int b = rank(a,6);
		System.out.println(b);
		
	}
	
	
}
