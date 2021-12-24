import java.util.*;
import java.io.*;

public class countTriplet {

    public static long countTriplets(long arr[], int n, int sum) {
        
        Arrays.sort(arr);

        int count=0;
      System.out.println(Arrays.toString(arr));  
        for (int i = 0; i < arr.length-2; i++) {
            
            System.out.println(" current i: "+i);

            int start =i+1;
            int end=n-1;
            
            
            
            while(start<end)
            {
                long  currentSum=arr[start]+arr[end]+arr[i];

                if (currentSum<sum)
                 {
                    count+=end-start;
                    
                   
                    start++;


                    
                }
                else
                {
                    end--;

                }
            }
           


        }

        
        return count;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineOne[] = br.readLine().trim().split("\\s");

        int n = Integer.parseInt(lineOne[0]);
        int k = Integer.parseInt(lineOne[1]);

        String[] lineTwo = br.readLine().trim().split("\\s");

        long arr[] = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(lineTwo[i]);

        }

        System.out.println("Arr : " + Arrays.toString(arr));
        int sum = k;
        long ans = countTriplets(arr, n, sum);
        System.out.println(" ANs :" + ans);

    }

}
class Test
{
    static int arr[] = new int[]{5, 1, 3, 4, 7};
    
    static int countTriplets(int n, int sum)
    {
        // Initialize result
        int ans = 0;
     
        // Fix the first element as A[i]
        for (int i = 0; i < n-2; i++)
        {
           // Fix the second element as A[j]
           for (int j = i+1; j < n-1; j++)
           {
               // Now look for the third number
               for (int k = j+1; k < n; k++)
                   if (arr[i] + arr[j] + arr[k] < sum)
                       ans++;
           }
        }
     
        return ans;
    }
    
    // Driver method to test the above function
    public static void main(String[] args) 
    {
        int sum = 12; 
        System.out.println(countTriplets(arr.length, sum));
    }
}


