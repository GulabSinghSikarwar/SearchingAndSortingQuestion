package tree;

import java.util.*;

public class boundaryTraversal {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class Solution {
        ArrayList<Integer> boundary(Node root) {
            // TreeSet<Integer> set = new TreeSet<>();
            ArrayList<Integer> list = new ArrayList<>();

            leftBoundaryTraversal(root, list);

           

            bottomBoundaryTraversal(root, list);
         

            righttBoundaryTraversal(root, list);
           
            return list;

        }

        public void leftBoundaryTraversal(Node root, ArrayList<Integer> list) {
            if (root == null)
                return;

            if (root.left != null) {
                list.add(root.data);
                leftBoundaryTraversal(root.left, list);
            } else if (root.right != null) {
                list.add(root.data);
                leftBoundaryTraversal(root.right, list);
            }

        }

        public void bottomBoundaryTraversal(Node root, ArrayList<Integer> list) {

            if (root == null)
                return;

            bottomBoundaryTraversal(root.left, list);
           
            if (root.left == null && root.right == null)
                list.add(root.data);

            bottomBoundaryTraversal(root.right, list);

        }

        public void righttBoundaryTraversal(Node root, ArrayList<Integer> list) {
            if (root == null)
                return;
            if (root.right != null) {
                righttBoundaryTraversal(root.right, list);
                list.add(root.data);
            } else if (root.left != null) {
                righttBoundaryTraversal(root.left, list);
                list.add(root.data);
            }
        }
    }

}
