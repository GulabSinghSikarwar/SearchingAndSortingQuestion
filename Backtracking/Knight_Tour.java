import java.lang.Thread.State;
import java.util.Arrays;

public class Knight_Tour {

    public static void tour(int n) {
        int maze[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];

        int moves = 1;
        int row = 0;
        int col = 0;
        count = 0;

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(maze[i], 0);
        }

        printTour(maze, moves, row, col, visited);
        System.out.println(count);

    }

    public static final int[] rows = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    public static final int[] cols = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
    public static int count;

    private static boolean isValid(int x, int y, int N) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }

        return true;
    }

    public static void printTour(int[][] maze, int moves, int row, int col, boolean[][] visited) {

        // System.out.println("row : "+row +" col : "+col + " Moves : "+moves);

        maze[row][col] = moves;

        if (moves >= maze.length * maze.length) {
            int n = maze.length;
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(maze[i]));
            }
            count++;

            maze[row][col] = 0;
            System.out.println();
            return;

        }

        // maze[row][col]=moves;
        for (int i = 0; i < rows.length; i++) {
            int dx = rows[i] + row;
            int dy = cols[i] + col;
            int n = maze.length;

            if (isValid(dx, dy, n) && maze[dx][dy] == 0) {
                printTour(maze, moves + 1, dx, dy, visited);
            }

        }

        maze[row][col] = 0;

        return;

    }

    public static void main(String[] args) {
        int n = 8;
        tour(n);
    }

}
