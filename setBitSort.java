import java.io.*;

import java.util.*;


public class setBitSort {
    public static int  countSetBit(int number){

        int count=0;
        while(number >0)
        {
            // checking the binary form of the numbers  
             
           /*{ System.out.println(" number : "+number+"  number Binary Form : "+
            Integer.toBinaryString(number));

            System.out.println(" 1 : "+(1)+"  number Binary Form : "+
            Integer.toBinaryString(1));
            
            System.out.println( " Now number we get after BITWISE & : "+(number&1)+"  Binary form : "+Integer.toBinaryString((number&1)));
            }*/
            
            if ((number & 1 )>0) {

                
                count ++;

            }
            number=number>>1;
              
           /** System.out.println(" number after dividing by two : "+number+"  number Binary Form : "+
            Integer.toBinaryString(number)); */

          

        }

        // Arrays.sort(arr, (a, b) -> -Integer.compare
        // (Integer.bitCount(a), Integer.bitCount(b)));

        return count;

    }
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
        System.out.println( " Before Sorting "+Arrays.toString( arr));
        
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public  int compare (Integer arg1,Integer arg2){
                int c1=countSetBit(arg1);
                int c2=countSetBit(arg2);

                if (c1<=c2) {
                    return 1;
                }
                else return -1;
                
            }
        });
        System.out.println( " After Sorting "+Arrays.toString( arr));

    } 

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());

        // String o2[] = br.readLine().trim().split("\\s");
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = Integer.parseInt(o2[i]);
        // }
        // System.out.println(Arrays.toString(arr));
        Integer arr[] = { 1, 2, 3, 4, 5, 6 };
        int n=arr.length;
        
     sortBySetBitCount(arr, n);
        
    
    }
    
}
