package Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = {34,23,21,32,45,56,78,90,43};
		
		System.out.println("Before Sort :"+Arrays.toString(arr));
			bubbleSort(arr);
			
			System.out.println("After sort :"+Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}

}
