import java.io.*;
import java.util.*;

public class subsetSums {
    public static void main(String[] args) {

        try {
            File inputFile = new File("input.txt");
            Scanner fileReader = new Scanner(inputFile);

            String lineOne[] = fileReader.nextLine().trim().split("\\s");

            int n = Integer.parseInt(lineOne[0]);
            int a = Integer.parseInt(lineOne[1]);
            int b = Integer.parseInt(lineOne[2]);
            int arr[] = new int[n];
            int i = 0;

            while (fileReader.hasNext()) {

                arr[i] = Integer.parseInt(fileReader.nextLine());
                i++;
            }
            answerMaker(a, b, n, arr);

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void answerMaker(int a, int b, int n, int[] arr) {
        try {
            FileWriter outputFile = new FileWriter("output.txt", true);
            BufferedWriter writer = new BufferedWriter(outputFile);
            sumSubsetSolution solution=new sumSubsetSolution();
            int resp=solution.noOfSUbset(arr, a, b, n);
            writer.write( " Your Answer "+Integer.toString(resp+1));
            writer.newLine();
            

            writer.close();
        } catch (IOException e) {

        }
    }
}

class sumSubsetSolution {

    public int sumSubsetSolution(int arr[], int a, int b, int n) {
        if (arr.length==0) {
            return 0;
            
        }
        Positions [] subsets =new Positions[((int)Math.pow(2, n))+1];
        ArrayList <Positions> list=new ArrayList<>();

        int k=0;
       
        int sum=0;

        for (int i = 0; i < arr.length; i++) {
        sum=0;
            
            for (int j = i; j < arr.length; j++) {
                int start=i;
                int end=j;
                sum+=arr[j];
                list.add(new Positions(start, end,sum));
                k++;


            }
        }
        
        System.out.println(" a : "+a+"  "+"  b: "+b);

        ArrayList <Integer> require=new ArrayList<>();

       for (int i = 0; i < list.size(); i++) {
           System.out.println(" start : "+list.get(i).start+ "  end : "+list.get(i).end+" sum : "+list.get(i).sum);
           if((list.get(i).sum)>=a&& list.get(i).sum<=b)
           require.add(list.get(i).sum);


       }
       System.out.println(" Required Subset : "+require);
       

       

        

        return require.size();

    }

    public int noOfSUbset(int arr [] ,int a,int b,int n){
        
        int X []=new int [ (int )Math.pow(2, (n/2))];
        int Y [] =new int [(int )Math.pow(2, ( n- (n/2)))];

        calculateSubset(arr, X, 0,n/2);

        calculateSubset(arr, Y, n/2,arr.length);

        Arrays.sort(X);
        Arrays.sort(Y);

        int count=0;
        for (int eleX : X) {

            int low=0;
            int high=Y.length;
            while(low<high)
            {
                int mid=(low+high)/2;
                boolean result=(Y[mid]+eleX>=a) && (Y[mid]+eleX <=b);
                if(result){
                    count++;
                    low=mid+1;

                }
                else{
                    high=mid-1;

                }


            }

          
        }


        
        
        return count;
    }
     public void  calculateSubset(int arr[],int K[],int low , int high)
     {
        //  int sum=0;
         int index=0;

         for (int i = low; i < high; i++) {
            //  sum=0;

             for (int j = i; j < high; j++) {
                //  sum+=arr[j];
                 K[index]+=arr[j];
                 index++;




             }
         }
     }
}
class Positions{
    int start ;
    int end ;
    int sum;


    Positions(int start,int end,int sum){
        this.start=start;
        this.end=end;
        this.sum=sum;



    }
}
