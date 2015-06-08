package kthElement;

public class kthElement {
	public static void main(String[] args){
		int k=9;
		int [] arr = {1, 5, -3, -1,0,7,4,9};
				//int [] arr = {1,2,3,4,5,6,7};
				//int [] arr = {7,6,5,4,3,2,1};
		int kthElement = kElement(arr,k);
		System.out.println("Kth Element is : "+kthElement);
	}
	private static int kElement(int[] arr, int k){
		int kthElement = kElement(arr,0,arr.length - 1, k);
		return kthElement;
	}
	
	private static int kElement(int [] arr, int low, int high, int k){
		/*System.out.println("Array : ");
		for(int element : arr){
			System.out.print(element+",");
		}
		System.out.println();
		System.out.println("Low : "+low+", High: "+high+", K: "+k);*/
		int pivot = low;
		if(high<low)
			return -1;
		int i=low;
		int j=high;
		while(i<j){
			while(arr[i]<arr[pivot] && i<high){
				i++;
			}
			while(arr[j]>arr[pivot] && j>low){
				j--;
			}
			if(i<j)
				swap(arr,i,j);
		}
		swap(arr,pivot,j);
		if(j==(k-1))
			return arr[j];
		else if(j<(k-1))
			return kElement(arr,j+1,high,k);
		else
			return kElement(arr,low,j-1,k);
	}
	
	private static void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
