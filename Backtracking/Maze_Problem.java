// package Backtracking;

import java.util.Arrays;

public class Maze_Problem {
    
    static  int x,y;
    static boolean visited [][];
    static int distance ;
    

    
    public  static int nearestExit(char[][] board, int[] cord) {
      

        int n=board.length;

        int m=board[0].length;
        visited=new boolean[n][m];
        distance=Integer.MAX_VALUE;

        // Arrays.fill(visited, false);

        x=cord[0];
        y=cord[1];
        
        int row=x;
        int col =y;
        
        print_path(board, row, col,n,m,0);
        return distance ;
        
    }
    public static  void print_path(char [][] board , int row , int col ,int n,int m,int local_distance ) {
        
        
         boolean is_visited=visited[row][col];
         if(is_visited)
         {
            return;

         }
         visited[row][col]=true;
//      isSafe 
        boolean notSafe=  ( row==n|| col ==m|| row<0 || col <0 );
        if(notSafe)
        {
            return ;
            
        }
        
        
        
//          Reached destination 
         boolean onBoundary=(row==0 || row==n-1 || col==0 || col==m-1 ) ;
        
        if( !( row==x && col==y ) &&  board[ row] [col]=='.'  && onBoundary)
        {
            distance=Math.min(distance, local_distance);
            System.out.println(  " Reached ans  :--:  " +"row "+row +"  col : "+col  );
            System.out.println("local dist:  "+local_distance+ " min distance : "+distance);

            
            return ;
        }
        
//       check is Bolcked    
        boolean isBlocked=board[ row  ] [ col  ]=='+';
        
        if(isBlocked)
        {
            return ;
            
        }
//         traverse all possible direction 


System.out.println(" current cordinate :: "+"( "+row+" "+col +")");
//         Left direction 

        print_path(board, row ,col-1,n,m,local_distance+1);
//         Right direction 
        print_path(board, row ,col+1 ,n,m,local_distance+1);
//         Top Direction 
        print_path(board, row-1,col ,n,m,local_distance+1);
//         Bottom 
        print_path(board, row+1,col,n,m,local_distance+1);
        
        
        
        
    }
    public static void main(String[] args) {
        char [][] board={
            {'+','+','.','+'},
            {'.','.','.','+'},
            {'+','+','+','.'},
    };
    int cord[]=  {1,2};

    System.out.println(nearestExit(board,cord));



    }
    
}
