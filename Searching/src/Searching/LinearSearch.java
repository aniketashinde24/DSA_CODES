package Searching;

import java.util.Scanner;

public class LinearSearch {

	public static int linearSearch(int arr[],int key) {
		
		for(int i=0;i < arr.length;i++)
		{
			if(arr[i]==key) {
	 			return i;
			}
		}
		
		return -1;
	}
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int arr[]= {88,22,44,11,44,55,10};
		
		System.out.println("Enter key to serach in array");
		int key=sc.nextInt();
		int index=linearSearch(arr,key);
		
		if(index != -1) {
			System.out.println(key+" is found at index"+"  "+index);
			
		}else {
			System.out.println(key+"  "+"key is not found");
		}
		
				
	}

}
