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
                    
                    System.out.println(" index :  "+i+"  start : "+start +"  end : "+end );
                    System.out.println("elements are start end and i resp : "+arr[start]+arr[end]+arr[i]);

                    System.out.println("elements are start end and i resp : "+arr[start]+arr[end]+arr[i]);
                    System.out.println(" current sum : "+currentSum);
                    System.out.println("current count : "+count);
                   
                    start++;


                    
                }
                else
                {
                    end--;

                }
            }
            // System.out.println("arr : "+Arrays.toString(arr));

            // System.out.println(" index :  "+i+"  start : "+start +"  end : "+end );
            
           
            // System.out.println("..");
            // while (start<end) {
            //     long currentSum=arr[start]+arr[end]+arr[i];
            //     if (currentSum>=sum) {
            //         end--;
            //         continue;


                    
            //     }
            //     {
                    
            //     ++count;
               
                // System.out.println("elements are start end and i resp : "+arr[start]+arr[end]+arr[i]);
                // System.out.println(" current sum : "+currentSum);
                // System.out.println("current count : "+count);

               
                
            //     }


                
            // }


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
