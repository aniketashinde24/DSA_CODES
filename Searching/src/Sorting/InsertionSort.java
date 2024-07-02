package Sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int arr[] ={23,43,21,2,1,6,7,8};
		
		insertionSort(arr);
		
		System.out.println("after sort :"+Arrays.toString(arr));
		
	}

	private static void insertionSort(int[] arr) {
			
	
		for(int i=0;i<arr.length;i++) {
			int j,temp =arr[i];
			for( j=i-1;j>=0 && arr[j] > temp;j--) {
				arr[j+1]=arr[j];
			}
			arr[j+1]= temp;
		}
	}

}
