import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class floodFill {
    static int starting_color;

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public static int[][] floodFill(int[][] image, int row, int col, int newColor) {

        Queue<Pair> q = new LinkedList<>();
        int n = image.length;
        int m=image[0].length;
        boolean [] [] visited =new boolean [n][m];



        Pair p = new Pair(row, col);

        q.add(p);

        while (!q.isEmpty()) {
            for (int i = 0; i < image.length; i++) {
                System.out.println(Arrays.toString(image[i]));
            }
            
            

            System.out.println();
            Pair pc = q.peek();
            image[pc.x][pc.y] = newColor;
            visited[pc.x][pc.y]=true;
            

            q.poll();
            int x[] = { -1, 0, 1, 0 };
            int y[] = { 0, 1, 0, -1 };

            // isChangable
            // isSafe --------------
            // isColorable----------

            for (int k = 0; k < x.length; k++) {
                int dx = pc.x + x[k];
                int dy = pc.y + y[k];
                if (dx < n && dx >= 0 && dy < m && dy >= 0 && 
                image[dx][dy] == starting_color &&
                visited[dx][dy]==false) {
                    q.add(new Pair(dx, dy));

                }

            }

        }
        return image;

    }

    // public static boolean q

    public static void main(String[] args) {
        int image[][] = {
            {0,0,0},
            {0,1,1}
                // { 1, 0, 1 }
             };
        int r = 1;
        int c = 1;
        int co = 1;
        starting_color = image[r][c];
        floodFill(image, r, c, co);
        System.out.println();
        System.out.println("................................");
        System.out.println();
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }

    };

}
/*
t
[
    [0,0,0],
    [0,1,1]
    
    ]
 */
