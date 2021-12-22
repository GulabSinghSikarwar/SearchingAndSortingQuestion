import java.io.*;
import java.util.*;

public class QuickSort {
    public  static List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> list=new ArrayList<>();
        quickSort(arr);
        int diff=Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
        
            int currDiff=Math.abs(arr[i]-arr[i-1]);
            diff=Math.min(diff, currDiff);
            System.out.print(diff+"  ");


            
            
            
        }
        System.out.println("min diff : "+diff);
        
        // List<Integer>minList=new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int currDiff=Math.abs(arr[i]-arr[i-1]);
            if(currDiff==diff)
            {
                List <Integer> minList=new ArrayList<>();
                minList.add(arr[i-1]);
                minList.add(arr[i]);
                list.add(minList);
                
                // minList.clear();
                // minList.add(arr[i-1],arr[i]);
                System.out.println(" List of elements : "+minList);

            }
            
            
        }
        System.out.println(" List of elements : "+list);



      return list;  
    }

    public static void quickSortUtil(int arr[], int low, int high) {
        if (low < high) {
            int boundary = partition(low, high, arr);
            quickSortUtil(arr, low, boundary - 1);
            quickSortUtil(arr, boundary + 1, high);
        }

    }

    private static int partition(int low, int high, int[] arr) {
        int pivotIndex = high;
        int pivot = arr[pivotIndex];

        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[pivotIndex];
        arr[pivotIndex]=temp;
        return i+1;




    }

    public static void quickSort(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        System.out.println("Array Before sort : " + Arrays.toString(arr));

        quickSortUtil(arr, low, high);

        System.out.println("Array after sort : " + Arrays.toString(arr));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the  n and x ");
        String o[] = br.readLine().trim().split("\\s");
        int n = Integer.parseInt(o[0]);

        System.out.println("Enter  the elements  ");

        String o2[] = br.readLine().trim().split("\\s");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(o2[i]);

        }
       
        
        minimumAbsDifference(arr);

    }
}