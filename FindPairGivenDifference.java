import  java.util.*;
import java.io.*;


public class FindPairGivenDifference {
    
    public static  boolean findPair(int arr[], int size, int n)
    {
        //code here.
        
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int start =0;
        int end=1;
        while(start<size && end<size)
        {
            int diff=Math.abs(arr[start]-arr[end]);
            // System.out.println(" start : "+start +"  end :: "+end + "  startElement  :  "+arr[start]+"  endElement : "+arr[end]+"  diff : "+diff);
            
            if (diff==n) {
                // System.out.println(" Match Condition :: current diff : "+diff);
                return true;
            }
             else if (diff<n) {
                end++;
            }
            else
            start++;

        }


        return false;

    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String lineOne []=br.readLine().trim().split("\\s");
        
        int size=Integer.parseInt(lineOne[0]);
        int n=Integer.parseInt(lineOne[1]);
        
        String  [] lineTwo=br.readLine().trim().split("\\s");


        int arr []=new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(lineTwo[i]);

        }
        // System.out.println("Your Array: " +Arrays.toString(arr));
         boolean  ans=findPair(arr, size, n);
         System.out.println(ans);



    }
}
