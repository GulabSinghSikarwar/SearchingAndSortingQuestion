import java.util.*;

public class MultiplyTwoList {
   
   
    public long multiplyTwoLists(Node l1, Node l2) {
        
        long num1=getNum(l1);
        long num2=getNum(l2);
         long N = 1000000007;
        
        long product=((num1%N)*(num2%N))%N;



        return product;

    }

    public long getNum(Node head){

 long N = 1000000007;

long num=0;
Node temp=head;

while(temp!=null)
{
    num=((num*10)%N)+temp.data;
    temp=temp.next;
}
return num;

    }




    public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

        System.out.println(" Enter the T : ");
		int t=sc.nextInt();
		while(t-->0){
			Node head=null;
			Node phead=null;
            System.out.println("Enter the n : i.e length of the l1");
			int n=sc.nextInt();
			while(n-->0){
                System.out.println("enter the value of node n1 ");

				int n1=sc.nextInt();
				if(head==null)
				head=new Node(n1);
			else{
				addHead(head,n1);
			}
			}
            System.out.println("Enter the m : i.e length of the l2");
			int m=sc.nextInt();
			while(m-->0){
                System.out.println("enter the value of node m1 ");
                
				int n1=sc.nextInt();
				if(phead==null)
				phead=new Node(n1);
			else{
				addPhead(phead,n1);
			}
			}
		GfG g=new GfG();

System.out.println(g.multiplyTwoLists(head,phead));
		}
	}
    public static void addHead(Node node,int a) {
          if (node == null)
            return;
		if(node.next==null)
			node.next=new Node(a);
		else
			addHead(node.next,a);
	}
	public static void addPhead(Node node,int a){
		 if (node == null)
            return;
		if(node.next==null)
		node.next=new Node(a);
	else
		addPhead(node.next,a);
	}
}

class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}

class GfG{
    /*You are required to complete this method */
    
      public long multiplyTwoLists(Node l1, Node l2) {
          
          int num1=getNum(l1);
          int num2=getNum(l2);
          long product=num1*num2;
  
  
  
          return product;
  
      }
  
      public int getNum(Node head){
          if (head==null) {
              return 0;
  
          }
          String num="";
          
          Node temp=head;
          while(temp!=null)
          {
              num+=Integer.toString(temp.data);
              temp=temp.next;
  
          }
          // System.out.println("String Num : "+num);
          int number =Integer.parseInt(num);
          
  
          return number;
  
      }
  }