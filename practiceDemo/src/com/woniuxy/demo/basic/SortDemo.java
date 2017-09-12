package com.woniuxy.demo.basic;

import java.util.Arrays;
import java.util.Scanner;

public class SortDemo {
	/**
	 * bubble Sort & Binary Search
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int[] array = new int[10];
//		
//		for(int i= 0;i<array.length;i++){
//			System.out.print("NO."+i+"=");
//			array[i] = sc.nextInt();
//		}
		int[] array = {45,50,30,2,6,2,7,9,16};
		array = new SortDemo().BubbleSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(new SortDemo().BinarySearch(array, 50));
	}
	
	public int[] BubbleSort(int[] array){
		for(int i = 0;i<array.length;i++){
			for(int j = 1;j<array.length-i;j++){
				if(array[j-1]>array[j]){
					int temp;
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		return array;
	}
	
	public int BinarySearch(int[] array,int num){
		int left= 0;
		int right = array.length-1;
		while(left<=right){
			int middle = (right-left)/2 + left;
//			System.out.println(middle);
//			System.out.println(array[middle]);
			if(array[middle] == num){
				return middle;
			}else if(array[middle] > num){
				right = middle-1;
			}else{
				left = middle+1;
			}
		}
		//not found
		return -1;
	}
}
