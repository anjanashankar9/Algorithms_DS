/**
 * Created by ashankar1 on 8/4/15.
 */
public class MergeSort {
    public static void mergeSort(int [] arr){
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[]arr,int low,int high){
        if (high <=low)
            return;
        int  middle = (low+high)/2;
        mergeSort(arr,low,middle);
        mergeSort(arr,middle+1,high);
        merge(arr,low,middle,high);
    }

    private static void merge(int[] arr, int low, int middle, int high){
        int[] helper = new int[arr.length];
        for(int i=low;i<=high;i++){
            helper[i] = arr[i];
        }

        int i=low;
        int j=middle+1;
        int k=low;

        while(i<=middle && j<=high){
            if(helper[i]<=helper[j]){
                arr[k] = helper[i];
                k++;i++;
            }
            else{
                arr[k] = helper[j];
                k++;j++;
            }
        }
        while(i<=middle){
            arr[k] = helper[i];
            i++;k++;
        }
        while(j<=high){
            arr[k]=helper[j];
            k++;
            j++;
        }
    }
}
