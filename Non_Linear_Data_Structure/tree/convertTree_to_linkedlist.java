package tree;

public class convertTree_to_linkedlist {

    class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }

    }

    // This function should return head to the DLL

    class Solution {
        Node head;
        Node last;

        // Function to convert binary tree to doubly linked list and return it.
        Node bToDLL(Node root) {
            // Your code here
            dfs(root);
            changeNext(root);


            return head;

        }

        Node prev;

        public void dfs(Node root) {
            if (root == null)
                return;

            dfs(root.left);

            root.left = prev;

            prev = root;

            dfs(root.right);

        }

      

        public void changeNext(Node root) {

            Node temp = root;

            while (temp.right != null) {
                temp = temp.right;
            }
            while (temp != null) {

                Node left = temp.left;
                Node right = temp;
                left.right = temp;
                temp = temp.left;
                if (temp == null)
                    head = right;


            }

        }

    }

}
