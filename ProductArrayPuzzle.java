import java.io.*;
import java.util.*;

public class ProductArrayPuzzle {

    public static long[] productExceptSelf(int arr[], int n) {
        // System.out.println("fun call ");
        // code here
        long[] p = new long[n];
        int zeroCount=0;
         boolean firstZeroCheck=false;
        int firstZero=0;
        long totalSum = 1;
        


        // finding zeroCount 
        for (int i = 0; i < p.length; i++) {
            if (arr[i]==0 ) {
                zeroCount++;
            }
            if (arr[i]==0 && firstZeroCheck==false) {
                firstZero=i;
                firstZeroCheck=true;

            }
        }
        // System.out.println(" zero count : "+zeroCount);
        
       
        if (zeroCount>1) {
            // System.out.println("inside 2 ");
            totalSum=0;
            Arrays.fill(p, 0);
            return p;

        }
        else if (zeroCount==1){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==0) {
                    continue;
                    
                }
                totalSum *= arr[i];
    
            }
            Arrays.fill(p, 0);
            p[firstZero]=totalSum;
            return p;

        }
        else {



            for (int i = 0; i < arr.length; i++) {
                totalSum *= arr[i];
    
            }
            // System.out.println(" totalSum : "+totalSum );
    
            for (int i = 0; i < p.length; i++) {
                p[i] = totalSum / arr[i];
            }
            // System.out.println(Arrays.toString(p));
    
            return p;

        }
       

            
       
        
      

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String o2[] = br.readLine().trim().split("\\s");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(o2[i]);
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(productExceptSelf(arr,n)));
    
    }
    

}
