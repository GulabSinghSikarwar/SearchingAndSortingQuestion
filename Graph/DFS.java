import java.util.*;

public class DFS {

    class Solution {
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int prev = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == 0 || j == 0) {
                    continue;

                }

                int temp = grid[i][j];

                grid[i][j] = temp;
                prev = temp;

            }
        }
        for (int i = 0; i < grid.length; i++) {
            Arrays.toString(grid);

        }
        return null;
    }

    public static void dfs(int[][] grid,
            int current_prev, int row, int col, int k) {

        if (col >= grid.length) {
            row++;
            col = 0;

        }
        if (row >=grid.length) {
            return ;

        }
        System.out.print(" -->" + grid[row][col])
        int dx= row+k;
        dx=(dx>=grid.length)?( (grid.length-1 -dx ))

    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 },
                { 5, 6, 7 },
                { 7, 8, 9 } };
        int k = 1;
        shiftGrid(grid, k);

    }
}
