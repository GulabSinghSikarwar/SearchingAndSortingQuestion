import java.lang.Thread.State;
import java.util.Arrays;

public class Knight_Tour {

    public static void tour(int n) {
        int maze[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];

        int moves = 1;
        int row = 0;
        int col = 0;

        printTour(maze, moves, row, col, visited);

    }

    public static void printTour(int[][] maze, int moves, iny row, int col, boolean[][] visited) {
        if (moves == Math.pow(maze.length, 2)) {
            int n = maze.length;
            for (int i = 0; i < visited.length; i++) {
                System.out.println(Arrays.toString(maze[i]));
            }
            return;

        }

        int directions[][] = {
                { row - 2, col + 1 }, { row - 1, col + 2 },
                { row + 1, col - 2 }, { row + 2, col + 1 },

                { row - 2, col - 1 }, { row - 1, col - 2 },
                { row + 1, col - 2 }, { row + 2, col - 1 }

        };
        for (int i = 0; i < directions.length; i++) {
            int dx=directions[i][0];
            
            int dy=directions[i][1];
            

            
        }

    }

}
