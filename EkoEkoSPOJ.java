import java.util.*;
import java.io.*;

class EkoEkoSPOJ {
	
	 public static void main(String[] args) throws IOException {
      
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String o1[] = br.readLine().trim().split("\\s");

        
		int n = Integer.parseInt(o1[0]);
		int k=Integer.parseInt(o1[1]);


        String o2[] = br.readLine().trim().split("\\s");
        
		int[] arr = new int[n];
        
		for (int i = 0; i < n; i++) {
        
		    arr[i] = Integer.parseInt(o2[i]);
        }
        System.out.println(Arrays.toString(arr));
		System.out.println( "Maximum Height that you can retain :  "+requiredWood(arr,n,k));
       
    
    }
	public static int requiredWood (int arr [] ,int n ,int k){

		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		int low =arr[0];
		int high=arr[n-1];
		int result =arr[0];


		while(low<=high)
		{
			 int mid=(low+high)/2;
			if(IsSolutionFeasible(arr,mid,k,n))
			{
				result=mid;
				low=mid+1;
			}
			else
			high-=1;


		}


return result;
	}
	public static  boolean IsSolutionFeasible(int arr [] ,int currentHeight, 
	int requiredWood ,int n){
		
		int currentSum=0;
		for(int i=0;i<n;i++){
			if(arr[i]>currentHeight)
			{
				currentSum+=arr[i]-currentHeight;
			}
		}
		if(currentSum>=requiredWood)
		return true;

		else return false ;


	}
    
}