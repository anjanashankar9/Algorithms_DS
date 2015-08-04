/**
 * Created by ashankar1 on 8/4/15.
 */
public class QuickSort {

    public static void quickSort(int [] arr){
        quickSort(arr,0,arr.length - 1);
    }
    private static void quickSort(int [] arr, int low, int high){
        if(high <= low)
            return;
        int pivot = low;
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<arr[pivot]){
                i++;
                if(i==high) break;
            }
            while(arr[j]>arr[pivot]){
                j--;
                if(j==low) break;
            }
            if(i<j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        swap(arr,pivot,j);
        if(low<j)
            quickSort(arr,low,j-1);
        if(i<high)
            quickSort(arr,j+1,high);
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
