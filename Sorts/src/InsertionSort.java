/**
 * Created by ashankar1 on 8/4/15.
 */
public class InsertionSort {
    private static void insertionSort(int[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            for(int j=i;j>0;j--){
                if(arr[j] < arr[j-1])
                    swap(arr,j,j-1);
                else
                    break;
            }
        }
    }
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
