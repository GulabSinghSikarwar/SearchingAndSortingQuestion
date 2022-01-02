import java.util.*;
import java.lang.*;
import java.io.*;
public class KthELementInSortedARray {
    
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m) {
            return kthElement(arr2, arr1, m, n, k); 
        }
        
        int low = Math.max(0,k-m), high = Math.min(k,n);
        
        while(low <= high) {
            int cut1 = (low + high) >> 1; 
            int cut2 = k - cut1; 
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1]; 
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2]; 
            
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1; 
            }
        }
        return 1; 
    }
}// { Driver Code Starts
 // Initial Template for Java



class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int) (n)];
            int b[] = new int[(int) (m)];

            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.kthElement(a, b, n, m, k));

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int st1 = 0, st2 = 0;
        return (kth(arr1, arr2, n, m, k, st1, st2));

    }

    int kth(int arr1[], int arr2[], int m,
            int n, int k, int st1, int st2) {
        // In case we have reached end of array 1
        if (st1 == m) {
            return arr2[st2 + k - 1];
        }
        // In case we have reached end of array 2
        if (st2 == n) {
            return arr1[st1 + k - 1];
        }
        // k should never reach 0 or exceed sizes
        // of arrays
        if (k == 0 || k > (m - st1) + (n - st2)) {
            return -1;
        }
        // Compare first elements of arrays and return
        if (k == 1) {
            return (arr1[st1] < arr2[st2])
                    ? arr1[st1]
                    : arr2[st2];
        }
        int curr = k / 2;
        // Size of array 1 is less than k / 2
        if (curr - 1 >= m - st1) {
            // Last element of array 1 is not kth
            // We can directly return the (k - m)th
            // element in array 2
            if (arr1[m - 1] < arr2[st2 + curr - 1]) {
                return arr2[st2 + (k - (m - st1) - 1)];
            } else {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
        }
        // Size of array 2 is less than k / 2
        if (curr - 1 >= n - st2) {
            if (arr2[n - 1] < arr1[st1 + curr - 1]) {
                return arr1[st1 + (k - (n - st2) - 1)];
            } else {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            }
        } else
        // Normal comparison, move starting index
        // of one array k / 2 to the right
        if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1]) {
            return kth(arr1, arr2, m, n, k - curr,
                    st1 + curr, st2);
        } else {
            return kth(arr1, arr2, m, n, k - curr,
                    st1, st2 + curr);
        }
    }
}
