/**
 * Created by ashankar1 on 8/3/15.
 */
public class SelectionSort {
    private static void selectionSort(int[] arr){
        int len= arr.length;
        for(int i=0;i<len;i++){
            int min = i;
            for(int j=i+1;j<len;j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            swap(arr,i,min);
        }
    }
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
