/**
 * Created by ashankar1 on 8/4/15.
 */
public class HeapSort {

    private static void heapSort(int [] arr){
        int n=arr.length;
        buildHeap(arr,n);

        while(n>1){
            n--;
            swap(arr,0,n);
            heapify(arr,0,n);
        }
    }

    private static void buildHeap(int[] arr, int n){
        for(int v=(n/2)-1;v>=0;v--){
            heapify(arr,v,n);
        }
    }

    private static void heapify(int[] arr, int v, int n){
        int w=2*v +1;
        while((w+1)<n){
            if(arr[w+1]>arr[w])
                w++;
            if(arr[v] < arr[w])
                swap(arr,v,w);
            v=w;
            w=2*v+1;
        }
        if(w<n){
            if(arr[v] < arr[w]){
                swap(arr,v,w);
            }
        }
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
