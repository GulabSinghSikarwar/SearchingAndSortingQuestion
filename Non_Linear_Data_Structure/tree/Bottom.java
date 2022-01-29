package tree;

import java.util.*;

public class Bottom {

    class Node {
        Node left;
        Node right;
        int data;
        int hd = Integer.MAX_VALUE;

    }

    public void bottomView(Node root) {

        Queue<Node> q = new LinkedList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int hd = 0;

        root.hd = hd;
        q.add(root);

        while (q.isEmpty()) {

            Node temp = q.peek();
            q.poll();
            hd = temp.hd;

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
            if (map.containsKey(hd))
                map.replace(hd, map.get(hd), temp.data);

            else {
                map.put(hd, temp.data);
            }

        }
        System.out.println("Map : "+ map);
        ArrayList <Integer>list=new ArrayList<>();
        for ( int i  : map.keySet()) {
            list.add(map.get(i));
            System.out.println("Key : "+i+" Value : "+map.get(i));
            System.out.print("  List after adding the key-value in list : "+list );
            
        }


    }

}
