import java.io.*;
import java.util.*;

public class mojorityElements {
    static int majorityElement(int a[], int size)
    {
        int count=0;
        int element=0;

        for (int i = 0; i < a.length; i++) {
            if(count==0)
            {
                element=a[i];
                count+=1;


            }

            else{
                if(a[i]!=element)
                count-=1;
                
                else count++;

            }
        }
        int newCount=0;

        for (int i = 0; i < a.length; i++) {
            if(a[i]==element)
            newCount++;

        }

        if(newCount>size/2)
        
        return element;


        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        String o2[] = br.readLine().trim().split("\\s");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(o2[i]);
        }

        System.out.println( (majorityElement(arr, n)));;
        

    }

    
}
