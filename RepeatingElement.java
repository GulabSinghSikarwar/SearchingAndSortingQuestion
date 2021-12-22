import java.io.*;
import java.util.*;
public class RepeatingElement {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        String o2[] = br.readLine().trim().split("\\s");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(o2[i]);
        }

        System.out.println(Arrays.toString(findTwoElement(arr, n)));;
        

    }

     public static int[] findTwoElement(int arr[], int n) {
        int rpNo=0;
        int missingNo=0;




        
        for (int i = 0; i < arr.length; i++) {
            
            int absValue= Math.abs(arr[i]);
            if(arr[absValue-1]>0)
            arr[absValue-1]*=-1;
            else{
   
                rpNo=absValue;

                // System.out.println("Repeating element is : "+rpNo);
    }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0)
            {
                missingNo=i+1;

                // System.out.println("Missing no: "+ (i+1));
            }
        }
        
        int [] a={rpNo,missingNo};

        return  a;

    }

}
