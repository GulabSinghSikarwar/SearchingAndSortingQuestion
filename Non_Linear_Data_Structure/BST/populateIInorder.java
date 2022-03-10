package BST;

import java.util.HashMap;
import java.util.Map;
import java.util.Map;

public class populateIInorder {
    class Node {
        int data;
        Node left, right, next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void populateNext(Node root) {
        // code here
        Map<Node, Node> map = new HashMap<>();

        Node pre = null;
        // PreNode - key and Node - value
        fillMap(root, map, pre);
        Map<Integer, Integer> map2 = new HashMap<>();
        fillmap2(root, map2);

        for (Node key : map.keySet()) {
            System.out.println(" Key : " + key.data + " Value " + map.get(key).data);

        }

    }

    int pre2 = -1;

    private void fillmap2(Node root, Map<Integer, Integer> map2) {
        if (root == null)
            return;
        fillmap2(root.left, map2);
        if (pre2 != -1) {
            map2.put(pre2, root.data);

        }
        System.out.println(map2);
        pre2 = root.data;
        fillmap2(root.right, map2);

    }

    private void fillMap(Node root, Map<Node, Node> map, Node pre) {
        if (root == null) {

            return;
        }

        fillMap(root.left, map, pre);
        if (pre != null) {
            map.put(pre, root);

        }
        pre = root;
        fillMap(root.right, map, pre);
    }
    
    public void action (Node root ,Node pre){
        if(root==null) return ;

        action(root.left, pre);
        if(pre!=null)
        {
            pre.next=root;
        }
        pre=root;
        action(root.right, pre);
    }

}
