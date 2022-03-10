package BST;

import java.util.Arrays;

public class BinaryTreeToBST {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int index;

    Node binaryTreeToBST(Node root) {
        // Your code here
        int n = getLength(root);

        int arr[] = new int[n];

        index = 0;

        getInorder(root, arr);

        index = 0;

        Arrays.sort(arr);

        BT_to_BST(root, arr);

        return root;

    }

    void BT_to_BST(Node root, int arr[]) {

        if (root == null) {

            return;
        }

        BT_to_BST(root.left, arr);

        root.data = arr[index++];

        BT_to_BST(root.right, arr);

    }

    void getInorder(Node root, int[] arr) {

        if (root == null) {

            return;
        }

        getInorder(root.left, arr);


        arr[index++] = root.data;

        getInorder(root.right, arr);

    }

    int getLength(Node root) {

        if (root == null){

            return 0;
        }

        return 1 + getLength(root.left) + getLength(root.right);

        

    }

}
