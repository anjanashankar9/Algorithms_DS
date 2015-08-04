/**
 * Created by ashankar1 on 8/4/15.
 */
public class BinarySearch {
    public static void main(String args[]){
        int [] arr = {2,3,4,5,6,7,8,9};
        int key = 10;
        int ret = binarySearch(arr,key,0,arr.length -1);
        if(ret == -1)
            System.out.println("The element is not found in the array");
        else
            System.out.println("Element is found at index "+ ret);

    }

    private static int binarySearch(int[] arr, int key, int low, int high){
        if (low > high)
            return -1;
        int mid = (low + high)/2;
        if (arr[mid] == key)
            return mid;
        else if (arr[mid] > key)
            return binarySearch(arr,key,low,mid-1);
        else
            return binarySearch(arr,key,mid+1,high);
    }
}

