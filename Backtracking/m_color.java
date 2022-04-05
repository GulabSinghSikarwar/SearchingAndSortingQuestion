import java.util.*;

public class m_color {

    {
        /*
         * Example 1:
         * 
         * Input:
         * N = 4
         * M = 3
         * E = 5
         * Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
         * Output: 1
         * Explanation: It is possible to colour the
         * given graph using 3 colours.
         * Example 2:
         * 
         * Input:
         * N = 3
         * M = 2
         * E = 3
         * Edges[] = {(0,1),(1,2),(0,2)}
         * Output: 0
         */}

    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) {
        // Your code here

        int n = color.length;

        if (i == n) {
            return true;

        }
        for (int c = 1; c <= m; c++) {

            if (isSafe(G, color, i, c)) {
                color[i] = c;
                if (graphColoring(G, color, i + 1, m))
                    return true;
                color[i] = 0;

            }
        }

        return false;
    }

    private static boolean isSafe(List<Integer>[] g, int[] color, int i, int c) {
        int n = color.length;

        for (int j = 0; j < color.length; j++)
            if (g[i].get(j) == 1 && color[i] == color[i + 1])
                return false;
        return true;

    }

}
