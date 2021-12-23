import java.util.*;
import java.io.*;

public class adjacentDifferByK {
    
    public static int search (int arr[], int n, int x, int k) {
        //Complete the function
        int firstIndex=-1;
        int i=0;
        int xCount=0;

        while(i<n)
        {
            if(arr[i]==x)
            {
                firstIndex=i;
                xCount++;

                System.out.println(" first Index  : "+firstIndex);
                break;
                
            }
          
        i++;
        }
        if(i==n)
        return-1;
        i++;


        
        while (i<n) {
            if (arr[i]==x) {
                xCount++;

                System.out.println("second index : "+i);
               
               break;
               

            }
            i++;
        }

        System.out.println(" xcount : "+xCount);
        
        if (xCount>1) {
           return firstIndex; 
        }
    
else
    return -1;
}
public static void main(String[] args)throws IOException {
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    String lineOne=br.readLine();
    String  [] lineOneArr=lineOne.trim().split("\\s");
    
    int n=Integer.parseInt(lineOneArr[0]);

    int k=Integer.parseInt(lineOneArr[1]);

    String lineTwoArr [] =br.readLine().trim().split("\\s");
    int arr []=new int [n];

    for (int i = 0; i < arr.length; i++) {
        arr[i]=Integer.parseInt(lineTwoArr[i]);

    }
    
    int x=Integer.parseInt(br.readLine());

    System.out.println( "Your element array"+Arrays.toString(arr));
    System.out.println(search(arr, n, x, k));



    


}    

}
