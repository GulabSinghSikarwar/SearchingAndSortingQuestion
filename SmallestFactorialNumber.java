import java.util.*;

public class SmallestFactorialNumber {
//  T.C :: O(log(N with base 2 ) * log(N with base 5))
// T.C :: O(log(N)*log(n))
//with base 2 and base5 respectively 


    
    public static int findNum(int n) {
        // Complete this function
int low=0;
int high=5*n;

while(low<high)
{
    int mid=(low+high)>>1;

    if(findTrailingZeros(n, mid))
    
    high=mid;
    
    else
    low=mid+1;


}
        

        return low; 

    }

    static boolean findTrailingZeros(int n ,int number) {
        
        // Initialize result
        int count = 0;
        // Keep dividing n by powers
        // of 5 and update count
        int temp=number;
        int i=5;
        while(i<=temp)
        {
            count+=(temp/i);
            i*=5;


        }
    return(count>=n);
}

    public static void main(String args[]) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter t");
            int t = sc.nextInt();

            while (t-- > 0) {
                System.out.println("enter n");

                int n = sc.nextInt();

                long startingTime = System.currentTimeMillis();

                System.out.println(findNum(n));
                long endingTime = System.currentTimeMillis();

                System.out.println("execution time : " + (startingTime - endingTime));

            }
        }
    }

}

//***********BRUTE FORCE APPROACH  */

// { Driver Code Starts
// Initial Template for Java


/*import java.util.*;

public class SmallestFactorialNumber {
    public static int findNum(int n) {
        // Complete this function

        int N = 1;

        boolean condition = true;

        int i = 1;

        while (condition) {
            String num = Integer.toString(N);
            System.out.println("N : " + N);

            if (num.length() > n) {

                String sub = num.substring(num.length() - n);

                int int_sub = Integer.parseInt(sub);

                if (int_sub == 0) {

                    System.out.println("found : " + int_sub);

                    break;

                }
            }
            N = N * (i + 1);
            i++;

        }

        return N;

    }

    static int findTrailingZeros(int n) {
        if (n < 0) // Negative Number Edge Case
            return -1;
        // Initialize result
        int count = 0;
        // Keep dividing n by powers
        // of 5 and update count
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
        return count;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter t");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("enter n");

            int n = sc.nextInt();

            long startingTime = System.currentTimeMillis();

            System.out.println(findNum(n));
            long endingTime = System.currentTimeMillis();

            System.out.println("execution time : " + (startingTime - endingTime));

        }
    }

}
// { Driver Code Starts
// Initial Template for Java
//USING THIS FUMCTION FOR CHECKING THE NUMBERS  IF ZERO COUNT EQUAL 
// TO n OR NOT 
// MAKES IT  TC :: O( N * log(N  with base 5 ))
*/ 
/*
        boolean condition =true;
        
        int number =1;
        while(condition) 
        {
            int zeroCount=findTrailingZeros(number);
            if(zeroCount==n)
            {
                System.out.println("found : "+number);
                break;

            }
            else
            number++;

        }

        if(number>1)
        return number;
         else 
         return -1  ;*/