import java.io.*;
import java.util.*;

public class sticklerThief {

    /**
     * static int FindMaxSum(int arr[], int n)
     * {
     * // Your code here
     * 
     * 
     * 
     * return FindMaxSumUtil(arr, n,0,0);}
     * 
     * static int FindMaxSumUtil(int arr[], int n ,int index,int sum)
     * {
     * if(index>=n)
     * return sum;
     * 
     * sum=Math.max(
     * FindMaxSumUtil(arr, n, index+1, sum)
     * ,
     * FindMaxSumUtil(arr, n, index+2, sum+arr[index])
     * 
     * );
     * System.out.println(" current index : "+index+" sum : "+sum);
     * 
     * 
     * return sum;
     * 
     * 
     * // Your code here
     * 
     * 
     * 
     * }
     */

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n=Integer.parseInt(br.readLine());

        // String o2[] = br.readLine().trim().split("\\s");
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = Integer.parseInt(o2[i]);
        // }

        // int arr []={5,5,10,100,10,5};
        int[] arr = { 1, 2, 3 };

        int n = arr.length;

        System.out.println("array : " + Arrays.toString(arr));
        int ans = FindMaxSum(arr, n);
        System.out.println(" Ans : " + ans);

    }

    private static int FindMaxSum(int[] arr, int n) {

        

        return maxLoot(arr, n);
    }

    static int maxLoot(int hval[], int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return hval[0];
        if (n == 2)
            return Math.max(hval[0], hval[1]);
        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];
        // Initialize the dp[0] and dp[1]
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);
        // Fill remaining positions
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(hval[i] + dp[i - 2], dp[i - 1]);
        return dp[n - 1];
    }


}
