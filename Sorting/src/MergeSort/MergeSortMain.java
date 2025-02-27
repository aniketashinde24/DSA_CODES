package MergeSort;

import java.util.Arrays;

public class MergeSortMain {
	public static void mergeSort(int [] arr,int left ,int right) {
		//if partition is invalid or have single element , then return 
		if(left >= right)
			return;
		//divide array in two equal partitions
				int mid = (left + right)/2;
				//sort left partition [left to mid]
				mergeSort(arr,left,mid);
				//sort right partition
				mergeSort(arr,mid+1,right);
				//create temp array to accomodate both partitions
				int temp []=new int[right - left + 1];
				//merge two sorted partitions into temp array
				int i = left,j = mid +1 ,k = 0;
				//compare elements from both partitions and copy to smaller one 
				//(until any one partition is done)
				while(i <= mid && j <= right) {
					if(arr[i] < arr[j])
						temp[k++] = arr[i++];
					else
						temp[k++] = arr[j++];
				}
				//copy remaining elements from other partition
				while(i <= mid) 
					temp[k++] = arr[i++];
				while(j <= right)
					temp[k++] = arr[j++];
				//overwrite temp array back to original array
				for(i = 0;i < temp.length ;i++)
					arr[left + i] = temp[i]; 
	}
	
	public static void main(String[] args) {
		
		int arr[] = {8, 3, 9, 1, 5, 7, 2, 6, 4};
		
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr , 0 , arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	

}
 