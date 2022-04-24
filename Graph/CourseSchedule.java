import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.HTMLDocument.BlockElement;

public class CourseSchedule {
    /**
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you
     * should also have finished course 1. So it is impossible.
     * 
     * .
     */
    public boolean canFinish(int courseNum, int[][] pre) {

        List<Integer>[] adj = new ArrayList[courseNum];

        for (int i = 0; i < courseNum; i++) {
            adj[i] = new ArrayList<Integer>();

        }
        for (int i = 0; i < pre.length; i++) {

            // [ a , b ]
            // to take course --A-- you should complete --B --

            int a = pre[i][0];
            int b = pre[i][1];
            adj[b].add(a);

        }

        // our graph is ready

        // Now we can detect cycle

        return detectCycle(adj);
    }

    public boolean detectCycle(List<Integer>[] adj) {
        int n = adj.length;

        boolean[] recStack = new boolean[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                if (detectCycleUtil(recStack, visited, adj, i)) {
                    return true;

                }
              

            }
        }

        return false;

    }

    private boolean detectCycleUtil(boolean[] recStack, boolean[] visited, List<Integer>[] adj, int i) {

        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        recStack[i] = true;
        visited[i] = true;

        Iterator<Integer> it = adj[i].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (detectCycleUtil(recStack, visited, adj, n)) {
                return true;

            }
        }
        recStack[i] = false;

        return false;
    }

}
