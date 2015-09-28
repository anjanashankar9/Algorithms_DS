/**
 * Created by ashankar1 on 9/28/15.
 */

/**
 * Question: Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum
 * of elements in both subsets is same.
 * Examples
 arr[] = {1, 5, 11, 5}
 Output: true
 The array can be partitioned as {1, 5, 5} and {11}

 arr[] = {1, 5, 3}
 Output: false
 The array cannot be partitioned into equal sum sets.
 * Explanation: If Sum is odd, then the set cannot be partitioned into two equal subsets
 * If sum is even then the problem can be reduced to finding a subset with sum equal to sum/2.
 * For the second step, we can have a recursive relation, that is,
 * 1. isSubsetSum equal to sum/2 without considering the last element.
 * 2. isSubsetSum equal to sum/2 - arr[n-1], reducing the size from n to n-1
 * If any of the above subproblems returns true, then we return true.
 */
//http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
public class PartitionSet {
    public static void main(String args[]){
        int[] a = new int[]{1,5,11,5};
        boolean isPossible = findPartition(a);
    }

    private static boolean findPartition(int[] a) {
        int sum = calculateSum(a);
        System.out.println("sum : "+sum);
        if(sum%2 !=0)
            return false;
        int n = a.length;
        boolean partition[][] = new boolean[sum/2+1][n+1];
        for(int i=0;i<n+1;i++){
            partition[0][i] = true;
        }
        for(int j=0;j<(sum/2+1);j++){
            partition[j][0] = false;
        }

        for(int i=1;i<(sum/2+1);i++){
            for(int j=1;j<n+1;j++){
                partition[i][j]=partition[i][j-1];
                if(i>=a[j-1]){
                    partition[i][j] = partition[i][j] || partition[i - a[j-1]][j-1];
                }
            }
        }
        //Uncomment this to print table
        /*for (int i = 0; i <= sum/2; i++)
        {
            for (int j = 0; j <= n; j++)
                System.out.print(partition[i][j] + " ");
            System.out.println();
        }*/
        return partition[sum/2][n];
    }

    private static int calculateSum(int[] a) {
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
}
