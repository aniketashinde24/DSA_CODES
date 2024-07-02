package Searching;

import java.util.Scanner;

public class BinarySearch {

	public static int binary(int arr[], int key, int mid, int left, int right) {

		while (left<=right) {
			if (key == arr[mid]) {
				return mid;
			} else if (key > arr[mid]) {

				left = mid + 1;
				mid = (left + right) / 2;

			}else {
				right = mid - 1;
				mid = (left + right)/2;
			}
			
			if(mid == right && mid == left) {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arr[] = { 11, 33, 44, 55, 66, 77, 99 };
		System.out.println("enter the key");
		int key = sc.nextInt();

		int left = 0;
		int right = arr.length - 1;

		int mid = (left + right) / 2;
		
		int index=binary( arr,  key, mid,left,right);
		if(index != -1) {
			
			System.out.println(key+"  "+"found at "+" "+index);
		}else {
			System.out.println(key+"  Not found ");

		}

	}

}
