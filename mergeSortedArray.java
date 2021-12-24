import java.util.*;
import java.io.*;

public class mergeSortedArray {
    public static void merge(int arr1[], int arr2[], int n, int m) {
        /*
         * arr1[] = {1, 3, 5, 7}
         * arr2[] = {0, 2, 6, 8, 9}
         * Output: 0 1 2 3 5 6 7 8 9
         */
        int i = n - 1;
        int j = 0;

        while (i >= 0 && j < m) {

            if (arr2[j]<arr1[i]) {
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i--;
                j++;


                
            }
            else
            j++;


        }
        System.out.println(" i: "+i +" j : "+j);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("  --1--- : " + Arrays.toString(arr1) + "--- 2---:  " + Arrays.toString(arr2));
        
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" enter the n1 and n2  ");

        String lineOne[] = br.readLine().trim().split("\\s");

        int n1 = Integer.parseInt(lineOne[0]);
        int n2 = Integer.parseInt(lineOne[1]);

        System.out.println("enter the element for 1st array");

        String[] lineTwo = br.readLine().trim().split("\\s");

        int arr[] = new int[n1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(lineTwo[i]);

        }

        System.out.println("enter the element for 2nd array");

        String[] lineThree = br.readLine().trim().split("\\s");

        int arr2[] = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(lineThree[i]);

        }
        System.out.println(" 1 : " + Arrays.toString(arr) + " 2:  " + Arrays.toString(arr2));
        merge(arr, arr2, n1, n2);

    }
}
