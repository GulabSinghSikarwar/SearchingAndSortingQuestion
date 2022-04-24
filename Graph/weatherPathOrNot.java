import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class weatherPathOrNot {
    static class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        int[][] adj = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            adj[x][y] = 1;
            adj[y][x] = 1;

        }
        for (int i = 0; i < adj.length; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }

        if (adj[source][destination] == 1) {
            return true;

        }

        boolean[][] visited = new boolean[n][n];

        return bfs(adj, visited, source, destination);
    }

    static private boolean bfs(int[][] adj, boolean[][] visited, int source, int destination) {
        Queue<pair> q = new LinkedList<pair>();

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        q.add(new pair(source, source));

        while (!q.isEmpty()) {
            pair peek = q.peek();
            q.poll();

            if (peek.x == destination || peek.y == destination) {
                return true;
            }

            visited[peek.x][peek.y] = true;
            System.out.println("X : " + peek.x + "  " + "  Y :" + peek.y);

            for (int i = 0; i < dy.length; i++) {

                int x = dx[i] + peek.x;
                int y = dy[i] + peek.y;

                if (isSafe(x, y, adj, visited)) {

                    q.add(new pair(x, y));

                }
            }

        }

        return false;
    }

    static private boolean isSafe(int x, int y, int[][] adj, boolean[][] visited) {
        int n = adj.length;
        if (x < n && x >= 0 && y < n && y >= 0 && adj[x][y] == 1 && visited[x][y] == false) {
            return true;

        }

        return false;
    }

    public static void main(String[] args) {
        /*
         * 
         * 
         * int [][] edges ={ {0,1} ,{1,2} , {2,0} };
         * int source =0;
         * int destination=2;
         * 
         * int n=3;
         * 
         * 
         * 
         * 
         * 
         * 10
         * [[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]]
         * 5
         * 9
         * 
         * 
         */

        /*
         * int[][] edges = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
         * int source = 0;
         * int destination = 5;
         * 
         * int n = 6;
         * 
         */

        /*
         * 10
         * [[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]]
         * 5
         * 9
         */
        int n = 10;
        int edges[][] = {
                { 4, 3 }, { 1, 4 },
                { 4, 8 }, { 1, 7 },
                { 6, 4 }, { 4, 2 },
                { 7, 4 }, { 4, 0 },
                { 0, 9 }, { 5, 4 }
        };

        PathFinder pf = new PathFinder();
        int source=5;
        int destination=9;

       boolean ans =  pf.validPath(n, edges, source, destination);

       System.out.println(   " ANSWER :  " +ans);

    }

}

class PathFinder {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());

        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);

        }

        System.out.println("[");

        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " --: ");
            System.out.println(adj.get(i));
        }
        System.out.println("]");

        boolean[] visited = new boolean[n];

        boolean ans = dfs(adj, visited, source, destination);

        return ans;
    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int source, int destination) {

        System.out.println(source + "  -->");
        if (source == destination) {
            return true;

        }
        visited[source] = true;

        Iterator<Integer> it = adj.get(source).listIterator();

        boolean ans = false;

        while (it.hasNext()) {
            int n = it.next();

            if (visited[n] == false) {

                ans = ans || dfs(adj, visited, n, destination);
            }

        }

        return ans;
    }

}

class Solution {
    class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int[][] adj = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            adj[x][y] = 1;
            adj[y][x] = 1;

        }
        for (int i = 0; i < adj.length; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }

        if (adj[source][destination] == 1) {
            return true;

        }

        boolean[][] visited = new boolean[n][n];

        return bfs(adj, visited, source, destination);
    }

    private boolean bfs(int[][] adj, boolean[][] visited, int source, int destination) {
        Queue<pair> q = new LinkedList<pair>();

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        q.add(new pair(source, source));

        while (!q.isEmpty()) {
            pair peek = q.peek();
            q.poll();

            if (peek.x == destination || peek.y == destination) {
                return true;
            }

            visited[peek.x][peek.y] = true;
            System.out.println("X : " + peek.x + "  " + "  Y :" + peek.y);

            for (int i = 0; i < dy.length; i++) {

                int x = dx[i] + peek.x;
                int y = dy[i] + peek.y;

                if (isSafe(x, y, adj, visited)) {

                    q.add(new pair(x, y));

                }
            }

        }

        return false;
    }

    private boolean isSafe(int x, int y, int[][] adj, boolean[][] visited) {
        int n = adj.length;
        if (x < n && x >= 0 && y < n && y >= 0 && adj[x][y] == 1 && visited[x][y] == false) {
            return true;

        }

        return false;
    }
}