import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.StreamPrintService;

public class RottenOranges {
    static class orange {

        int x;
        int y;
        // int time;

        orange(int x, int y
        //  int time
         ) {
            this.x = x;
            this.y = y;
            // this.time = time;

        }
    }

 /*
    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int total_time = 0;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {

                for (int j2 = 0; j2 < visited.length; j2++) {
                    System.out.println(Arrays.toString(grid[j2]));

                }
                System.out.println();
                System.out.println();
                if (visited[i][j] == false && grid[i][j]==2) {
                    int time = bfs(grid, visited, i, j);
                    total_time += time;

                }

            }
        }
        return total_time;
    }
 */

  /*
    private static int bfs(int[][] grid, boolean[][] visited, int i, int j) {

        Queue<orange> q = new LinkedList<orange>();
        q.add(new orange(i, j, 0));

        int time = 0;
        int dx[] = { 0, 1, 0, -1 };
        int dy[] = { 1, 0, -1, 0 };

        while (!q.isEmpty()) {
            orange spreader = q.peek();
            q.poll();
            visited[spreader.x][spreader.y] = true;
            int currentTime = spreader.time;
            time = Math.max(time, currentTime);

            if (grid[spreader.x][spreader.y] == 1) {
                grid[spreader.x][spreader.y] = 2;

            }

            for (int k = 0; k < dy.length; k++) {

                int x = i + dx[i];
                int y = j + dy[j];
                if (isSafe(x, y, grid)) {
                    q.add(new orange(x, y, currentTime + 1));

                }

            }

        }

        return time;

    }

  
  */
    private static boolean isSafe(int x, int y, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (x < m && x >= 0 && y < n && y >= 0 && grid[x][y] == 1) {

            return true;

        }
        return false;
    }

    public static int RottenOrangesUtil(int [] [] grid)
    {
        int m=grid.length;
        int n=grid[0].length;

        int fresh_count=0;
        int count=0;
        int rotten_count=0;

        Queue<orange> q= new LinkedList<>() ;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                
                if(grid[i][j]==1)
                {
                    fresh_count++;

                }
                else if(grid[i][j]==2)
                {
                    q.add(new orange(i, j)) ;
                    
                }
            }
        }
        // System.out.println();

        while(!q.isEmpty())
        {
            count++;

            int size =q.size();

            for(int j=0;j<size;j++)
            {
                orange peek= q.peek();
            q.poll();

            int x =peek.x;
            int y=peek.y;

            int dx[] = { 0, 1, 0, -1 };
            int dy[] = { 1, 0, -1, 0 };
            for (int i = 0; i < dy.length; i++) {
                int rx=x+dx[i];
                int ry=y+dy[i];
                if( isSafe(rx, ry, grid))
                {
                    grid[rx][ry]=2;
                    fresh_count--;
                    q.add(new orange(rx, ry));


                }

               
            }
            }
        }
        return  (fresh_count==0)? count-1 : -1;

    }
    public static void main(String[] args) {
        int grid[][] = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(RottenOrangesUtil(grid));

        /**
         * 
         * xample 1:
         * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
         * Output: 4
         * Example 2:
         * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
         * Output: -1
         * Explanation: The orange in the bottom left corner (row 2, column 0) is
         * never rotten, because rotting only happens 4-directionally.
         * Example 3:
         * Input: grid = [[0,2]]
         * Output: 0
         * Explanation: Since there are already no fresh oranges at minute 0, the
         * answer is just 0.
         * From <https://leetcode.com/problems/rotting-oranges/>
         * Friday, April 22, 2022 8:39 AM
         * New Section 7 Page 1
         */

    }
}
