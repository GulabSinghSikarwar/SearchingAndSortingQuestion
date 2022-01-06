import java.io.*;
import java.util.*;

public class countInversion {

    public static void main(String[] args) throws IOException {
        try {

            File inputFile = new File("input.txt");
            Scanner fileReader = new Scanner(inputFile);

            int n = Integer.parseInt(fileReader.nextLine().trim());

            int arr[] = new int[n];
            String lineOne[] = fileReader.nextLine().trim().split("\\s");
            for (int i = 0; i < lineOne.length; i++) {
                arr[i] = Integer.parseInt(lineOne[i]);

            }
            System.out.println(Arrays.toString(arr));
            outputMaker(arr, n);

            fileReader.close();

        } catch (IOException e) {

        }

    }

    public static void outputMaker(int arr[], int n) {
        try {
            FileWriter outputFile = new FileWriter("output.txt", true);
            BufferedWriter writer = new BufferedWriter(outputFile);
            countInversionSolution solution = new countInversionSolution();
            int ans = solution.countInversionPartTwo(arr, n);
            writer.write(Integer.toString(ans));
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class countInversionSolution {
    public int countInversion(int arr[], int n) {

        int temp[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);

        System.out.println(Arrays.toString(temp));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], i);

        }
        int count = 0;

        for (int i = 0; i < temp.length; i++) {
            if (arr[i] == temp[i]) {
                continue;
            } else {
                int index = map.get(temp[i]);
                // now swap the element ;
                int element = arr[i];

                int ele = arr[i];
                arr[i] = arr[index];
                arr[index] = ele;
                map.replace(element, i, index);
                map.replace(temp[i], index, i);
                count++;

            }

        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println(" count : " + count);

        return count;

    }

    public int countInversionPartTwo(int arr[], int n) {

        int low = 0;
        int high = arr.length - 1;

        System.out.println("Array before sort : " + Arrays.toString(arr));

        int count = mergeSort(arr, low, high);
        System.out.println("Array After sort : " + Arrays.toString(arr));
        System.out.println(" count : " + count);

        return count;

    }

    public int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;

            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);

            count += merge(arr, low, mid, high);
        }
        return count;

    }

    public int merge(int arr[], int low, int mid, int high) {

        // int left[] = Arrays.copyOfRange(arr, low , mid + 1);
        // int m = left.length;
        int n1=(mid+1)-low;
        int n2=(high)-mid;

        int left [] =new int [n1];


        // int right[] = Arrays.copyOfRange(arr, mid + 1, high + 1);
        // int n = right.length;
        int [] right =new int [n2];
        int m=n1;
        int n=n2;
        for (int i = 0; i < left.length; i++) {
            left[i]=arr[low+i];

        }
        for (int i = 0; i < right.length; i++) {
            right[i]=arr[mid+1+i];
            
        }

        int i, j;
        i = j = 0;
        int k = low;

        int swaps = 0;
        while (i < m && j < n) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];

            } else {
                arr[k++] = right[j++];
                swaps += (mid + 1) - (low + i);

            }
        }
        while (i < m) {
            arr[k++] = left[i++];

        }
        while (j < n) {
            arr[k++] = right[j++];

        }
        System.out.println(" k : " + k);
        return swaps;

    }
}