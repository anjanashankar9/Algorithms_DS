/**
 * Created by ashankar1 on 8/4/15.
 */
public class CountingSort {

    private static void countingSort(int[] arr) {
        int len = arr.length;
        int [] aux = new int[10];
        for(int i=0;i<len;i++){
            aux[arr[i]]++;
        }
        int k=0;
        for(int i=0;i<aux.length;i++){
            for(int j=0;j<aux[i];j++)
                arr[k++]=i;
        }
    }
}
