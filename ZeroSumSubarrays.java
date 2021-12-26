import java.io.*;
import java.util.*;
public class ZeroSumSubarrays {

    class Pair{
        int start;
        int end;
         Pair(int start ,int end ){
             this.start=start;
             this.end=end;

         }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        String o2[] = br.readLine().trim().split("\\s");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(o2[i]);
        }
        System.out.println(" ANs : "+findSubarray(arr, n));

  
        

    }
    public static long findSubarray(long[] arr ,int n) 
    {
        long currentSum=0;
        Map <Long,ArrayList<Integer>>map=new HashMap<>();

        int count=0;
        for (int i = 0; i < arr.length; i++) {
            
            
            currentSum+=arr[i];

            if(currentSum==0)
            count++;

            ArrayList <Integer> list =new ArrayList<>();


            
            if(map.containsKey(currentSum))
            {
            
                list=map.get(currentSum);

                int s=list.size();

                for (int j = 0; j <s; j++) {
                    count++;
                }
            }

           list.add(i);
           map.put(currentSum, list);

        }



       
        return  count;
        

    }

    
}
    
