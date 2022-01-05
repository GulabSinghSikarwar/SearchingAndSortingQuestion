import java.util.*;

import java.io.*;

public class prataMinTime {

    public static void codeWriter(int ratings[], int noOfCooks, int order, int textCaseNumber) throws IOException {

        try {

            FileWriter output = new FileWriter("output.txt", true);
            BufferedWriter BufferedWriter = new BufferedWriter(output);

            // here we will call the function

            ParathaSolution sol =new ParathaSolution();
             int ans =sol.minTimeForParatha(order, noOfCooks, ratings);
        
            BufferedWriter.write(" ans  : " + ans + "\n");
            BufferedWriter.newLine();
          

            BufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error Occured ");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
         
            File inputFile = new File("input.txt");
            Scanner filScanner = new Scanner(inputFile);

            int t = Integer.parseInt(filScanner.nextLine().trim());

            // filScanner.nextLine();

            while (filScanner.hasNextLine()) {
                int order = Integer.parseInt(filScanner.nextLine().trim());

                String lineTwo[] = filScanner.nextLine().trim().split("\\s");
                int arr[] = new int[lineTwo.length - 1];
                int noOfCooks = Integer.parseInt(lineTwo[0]);
                for (int i = 1; i < lineTwo.length; i++) {
                    arr[i - 1] = Integer.parseInt(lineTwo[i]);

                }

                codeWriter(arr, noOfCooks, order, t);

            }
            filScanner.close();

        } catch (IOException e) {
            
            System.out.println("Error ");
            e.printStackTrace();
        }

    }

}

class ParathaSolution {
    public int  minTimeForParatha(int order, int noOfCook, int ranks[]) {

        int low = 0;
        int high = Integer.MAX_VALUE;

        int result = Integer.MAX_VALUE;
        

        while (low <= high) {
            int mid = (low + high) / 2;

            int givenTime = mid;
            if(isParathaMakingPossible(givenTime, ranks, noOfCook, order))
            {
                result=Math.min(result, mid);
                high=mid-1;

            }
            else{
                low=mid+1;

            }
           
System.out.println(result);
        }
        return result;

    }

    private boolean isParathaMakingPossible(int givenTime,int[] ranks,
     int noOfCook, int order) 
     {
         int taotalCount=0;
         int time =0;

         for (int i = 0; i < ranks.length; i++) {
         int count=2;
          time=ranks[i];


            while(time<=givenTime)
            {
              
               taotalCount++;
               time+=((count)*ranks[i]);
               count++;

               

            }
            
            if (taotalCount>=order) {
                return true;
        
            }


         }
   
     return false;
        }
}