
import java.io.*;
import java.util.*;
class Main {
//Function to find minimum number of pages.
  public static boolean isFeasible(int arr [] , int  n , int m,int mid){

		int sum=0;
		int noOfStudent=1;

		for(int i=0;i<n;i++)
		{
		
		if(arr[i]>mid)
		return false;

		

			if(sum+arr[i]>mid){
				noOfStudent++;
				sum=arr[i];

			}
			else
			sum=sum+arr[i];

			if(noOfStudent>m)
			return false;


		}
// 		System.out.println(" m : "+m + " noOfStudent : "+noOfStudent);

		return true ;


	}

	 public static int findPages(int[]arr,int N,int M)
    {
        //Your code here
		int minPages=0;
		int maxPages=0;
		int result =0;

		for(int i=0;i<N;i++)
		{
			maxPages+=arr[i];

		
		}
		int high=maxPages;

		int low=minPages;

		while(low<=high){
			
// 			System.out.println("currentHigh : "+high);
			
			int mid=(low+high)/2;

			if(isFeasible(arr,N,M,mid)){
				result=mid;
				high=mid-1;

			


			}
			else
			low=mid+1;






		}




		 return result ;
    }
public static void main (String[] args)  throws IOException {
		
		int N = 4;
		int arr[] = {12,34,67,90};
		int M = 2;
		System.out.println( findPages(arr,N,M));

	}
}




