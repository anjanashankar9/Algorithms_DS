/**
 * Bubble Sort compares adjacent elements and exchanges the elements if they are in the wrong order.
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}

