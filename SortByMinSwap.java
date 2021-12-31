import java.util.*;




import java.io.*;

public class SortByMinSwap {
    public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String o2[] = br.readLine().trim().split("\\s");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(o2[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(minSwaps(arr));


    }
    public  static int minSwaps(int arr [])
    {
       ArrayList<Pair<Integer,Integer>>list=new ArrayList<>();
       for (int i = 0; i < arr.length; i++) {
           list.add(new Pair<>(arr[i], i));

       }
       list.sort(new Comparator<Pair<Integer,Integer>>() {
           @Override
           public int compare(Pair<Integer,Integer>arg1,Pair<Integer,Integer>arg2){
               if(arg1.getKey()>arg2.getKey())
               return -1;
               if (arg1.getKey()==arg2.getKey()) {
                   return 0;
               }
               else return 1;


           }
       });
       boolean vis [] =new boolean [arr.length];
       Arrays.fill(vis, false); 
       
       int ans=0;

       for (int i = 0; i < vis.length; i++) {
       int cycleSize=0;
       
       if (!vis[i] || list.get(i).getValue()==i) {
           continue;

       }
       int j=i;
       while (!vis[i]) {

           vis[j]=true;
           j=list.get(j).getValue();
           cycleSize++;
       }
       if (cycleSize>0) {
           ans+=(cycleSize-1);

       }
       }
      
        

        return ans;
    }
}
