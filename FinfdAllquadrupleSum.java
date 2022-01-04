import java.util.*;
import java.io.*;

public class FinfdAllquadrupleSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            if( arr[i]>0 && arr[i]>k)
            break ;
            if(i>0 && arr[i]==arr[i-1])
            continue;

            for (int j = i + 1; j < arr.length - 2; j++) {
            
                if(j>i+1 && arr[j]==arr[j-1])
                continue;

                // System.out.println(" i : " + i + "   j " + j);
                // int leftSum=k-(arr[i]+ arr[j]);

                int start = j+1;
                int end = arr.length - 1;

                while (start < end) {
                    int oldStart=start;
                    int oldEnd=end;

                    
                    int currentSum = arr[i] + arr[j] + arr[start] + arr[end];

                    if (currentSum == k) {
                        // System.out.println(
                        //         "1: " + arr[i] + "  2 :" + arr[j] + "  3 :" + arr[start] + "  4 : " + arr[end]);
                        ArrayList<Integer> smallList = new ArrayList<>();
                        smallList.add(arr[i]);
                        smallList.add(arr[j]);
                        smallList.add(arr[start]);
                        smallList.add(arr[end]);
                       list.add(smallList);

                       while(start<end && arr[start]==arr[oldStart])
                       start++;

                       while(start<end && arr[end]==arr[oldEnd])
                       end--;
                       
                        
       

                    }
                    if (currentSum < k)
                        start++;
                    else
                        end--;

                }
            }
        }

        return list;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineOne[] = br.readLine().trim().split("\\s");

        int n = Integer.parseInt(lineOne[0]);
        int k = Integer.parseInt(lineOne[1]);

        String[] lineTwo = br.readLine().trim().split("\\s");

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(lineTwo[i]);

        }
        // System.out.println("Your Array: " + Arrays.toString(arr));

        ArrayList<ArrayList<Integer>> list = fourSum(arr, k);
        System.out.println(" Ans : " + list);

    }
}
