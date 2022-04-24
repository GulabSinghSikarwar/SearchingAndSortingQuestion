public class Islands {

    public static int numIslands(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false
                 && grid[i][j]==1) {
                    int row = i;
                    int col = j;

                    markIsland(visited, row, col, grid);
                    count++;

                }
            }
        }

        return count;

    }

    private static void markIsland(boolean[][] visited, int row, int col, int[][] grid) {

        visited[row][col] = true;

        int dx[] = { 0, 1, 0, -1 };
        int dy[] = { 1, 0, -1, 0 };

        for (int i = 0; i < dy.length; i++) {

            int m = grid.length;
            int n = grid[0].length;
            int x = row + dx[i];
            int y = col + dy[i];

            boolean safe = isSafe(visited, x, y, m, n, grid);

            if (safe) {
                markIsland(visited, x, y, grid);
            }
        }

    }

    private static  boolean isSafe(boolean[][] visited, int x, int y,
            int m, int n, int[][] grid) {
        if (x < m && x >= 0 && y < n &&
         y >= 0 && visited[x][y] == false 
         && grid[x][y] == 1) {
            return true;

        }
        return false;
    }

    public static void main(String[] args) {

        /**
         * 
         * ["1","1","0","0","0"],
         * ["1","1","0","0","0"],
         * ["0","0","1","0","0"],
         * ["0","0","0","1","1"]
         * 
         */
        int grid[][] = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 }
        };
        
        int ans =numIslands(grid);
        System.out.println(ans);




    }
}
