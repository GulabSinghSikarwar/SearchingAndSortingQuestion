import java.io.BufferedWriter;
import java.io.File;
import java.util.*;

import java.io.*;

class Body {
    int indexI;
    int indexJ;
    int sum;

    public void setValues(int i, int j, int sum) {
        this.indexI = i;
        this.indexJ = j;
        this.sum = sum;

    }

}

public class doubleHelix {

    public static void main(String[] args) {

        try {
            File inputFile = new File("input.txt");
            Scanner fileReader = new Scanner(inputFile);

            while (fileReader.hasNext()) {
                String lineOne[] = fileReader.nextLine().trim().split("\\s");
                int arr1[] = new int[lineOne.length];

                String lineTwo[] = fileReader.nextLine().trim().split("\\s");
                int arr2[] = new int[lineTwo.length];

                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = Integer.parseInt(lineOne[i]);

                }
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = Integer.parseInt(lineTwo[i]);

                }

                outputMaker(arr1, arr2);

            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void outputMaker(int[] arr1, int[] arr2) throws IOException {
        try {
            FileWriter outputFile = new FileWriter("output.txt", true);
            BufferedWriter writer = new BufferedWriter(outputFile);

            DoubleHelixSolution solution = new DoubleHelixSolution();
            int maxSum = solution.maxSum(arr1, arr2);

            writer.write(Integer.toString(maxSum));

            writer.newLine();
            writer.newLine();
            writer.close();
        } catch (IOException e) {

        }

    }
}

class DoubleHelixSolution {

    public int maxSum(int arr1[], int arr2[]) {

        int m = arr1.length;
        int n = arr2.length;
        int dpLength = Math.max(m, n);

        int dp[] = new int[dpLength];

        int i, j;
        i = j = 0;

        int maxSum = 0;
        for (int k = 0; k < dp.length; k++) {
            // System.out.println();
            // System.out.println(" i : " + i + "  j : " + j);
            if (i == m || j == n) {

                break;

            }

            Body body = SumTillNextCommonPoint(arr1, arr2, i, j);
            maxSum += body.sum;
            // System.out.println(" ---- MAX SUM TILL NOW  : " + maxSum + " -----");

            i = body.indexI;
            j = body.indexJ;

            // System.out.println(" i : " + i + "  j : " + j);

        }

       
        // System.out.println("maxSum " + maxSum);

        return maxSum;
    }

    public Body SumTillNextCommonPoint(
            int arr1[], int arr2[], int i, int j) {
        int sumForOne = 0;
        int sumForTwo = 0;

        while (arr1[i] == arr2[j]) {
            // System.out.println(" indide eual checker : ");
            // System.out.println(" i : " + i + " j : " + j + " arr1[i] : " + arr1[i] + "  arr2[j]  :" + arr2[j]);
            sumForOne += arr1[i];
            sumForTwo += arr2[j];
            i++;
            j++;

        }
        // System.out.println("SumForOne :  " + sumForOne + "  Sum For Two : " + sumForTwo);

        while ((arr1[i] != arr2[j])

        ) {
            // System.out
            //         .println("Currently :  arr[i] :" + arr1[i] + "  arr2 [j] : " + arr2[j] + "i : " + i + "  j : " + j);
            if (arr1[i] > arr2[j]) {
                // System.out.print(arr2[j] + " -->");
                sumForTwo += arr2[j];
                j++;

            } else {
                // System.out.print(arr1[i] + " -->");
                sumForOne += arr1[i];
                i++;

            }
            if (i == arr1.length || j == arr2.length) {
                int m = arr1.length;
                int n = arr2.length;

                if (i == m) {
                    // System.out.println("helix two is pending");
                    while (j < n) {
                        // System.out.print("---"+arr2[j] + "--");
                        sumForTwo += arr2[j];
                        j++;

                    }

                } else {
                    // System.out.println("helix one is pending");
                 
                    while (i < m) {
                        // System.out.print( "------"+arr1[i] + "----");

                        sumForOne += arr1[i];
                        i++;
                    }

                }

                break;

            }

            // System.out.println("SumForOne :  " + sumForOne + "  Sum For Two : " + sumForTwo);

        }
        // System.out.println(" outside max loop : ");
        // if (i != arr1.length && j != arr2.length) {
        //     System.out.println(" i = " + i + "  j =" + j + "  arr1[i] = " + arr1[i] + "  arr2 [j]" + arr2[j]);

        // }

        // System.out.println("SumForOne :  " + sumForOne + "  Sum For Two : " + sumForTwo);

        int maxSum = Math.max(sumForOne, sumForTwo);
        // System.out.println(" MaxSum : " + maxSum);
        Body body = new Body();
        body.setValues(i, j, maxSum);

        return body;
    }

}