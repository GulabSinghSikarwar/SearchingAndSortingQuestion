public class InAP {

    public  static  int isInAP(int a,int b ,int c)
    {
        if(b==a)
        return 1;


        System.out.println( a+" "+b+" "+c+" ");
        int d=c;

        //  if d= 0
        
        if (d==0) {
        
            if(a==b)return 1 ;
        
            else return 0;

        }
        System.out.println(  " b-a  : "+(b-a)+"  (b-a)/d : "+ (double)( (b-a)/d) +" ((b-a)/d+1) :"+((b-a)/d+1));

        double n =((b-a)/d)+1;
        System.out.println( " n : " +n);
        // int val=n.intValue();
        
        int num=(int) (a+(n-1)*d);
        if (n<=0) {
            return 0;
        }

        System.out.println(" calculated b : "+num);
        if (num==b) {
            return 1;
        }
        else{
            return 0;
        }

        

    } 
    
    public static int isInt(Float n ){

        int x= n.intValue() ;
        double  diff=n-x;

        if(diff>0)
        return 0;



        return 1;
    }

    public static void main(String[] args) {
        // 4 -12 4 ans =0
        // -1000000000 1000000000 5 ans= 1
        // -2 -9 7 ans =0
        // 1 3 2 ans=1
        // 1 2 3 ans= 0 

        int a = 1;
        int b = 2;

        int c = 3;
        int ans=isInAP(a, b, c);
        
        System.out.println( "ANSWER : " +ans);

       

    }
}
