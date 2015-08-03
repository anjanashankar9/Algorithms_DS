package algorithms.warmup.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class HalloweenParty {
    public static void halloweenParty(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            long k = in.nextLong();
            findMaxPieces(k);

        }
    }
    private static void findMaxPieces(long k){
        if(k%2 == 0){
            //even lines, equal horizontal and vertical lines;
            System.out.println((k/2) * (k/2));
        }
        else{
            //odd lines, horizontal line is 1 > vertical lines
            System.out.println(((k/2) +1) * (k/2));
        }
    }
}

/*
Alex is attending a Halloween party with his girlfriend Silvia. At the party, Silvia spots a giant chocolate bar.
If the chocolate can be served as only 1 x 1 sized pieces and Alex can cut the chocolate bar exactly K times,
what is the maximum number of chocolate pieces Alex can cut and give Silvia?

Input Format
The first line contains an integer T, the number of test cases. T lines follow.
Each line contains an integer K

Output Format
T lines. Each line contains an integer that denotes the maximum number of pieces that can be obtained for each test case.

Constraints
1<=T<=10
2<=K<=107

Note
Chocolate needed to be served in size of 1 x 1 size pieces.
Alex can't relocate any of the pieces, nor can he place any piece on top of other.

Sample Input #00

4
5
6
7
8
Sample Output #00

6
9
12
16
Explanation
The explanation below is for the first two test-cases. The rest of them follow a similar logic.

For the first test-case where K = 5,You need 3 Horizontal and 2 vertical cuts.
halloweenboard For the second test-case where K = 6,You need 3 Horizontal and 3 vertical cuts.
 */

//https://www.hackerrank.com/challenges/halloween-party