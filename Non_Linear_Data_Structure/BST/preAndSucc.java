package BST;

import java.security.Key;

public class preAndSucc {
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;

        }
    }

    class Res {
        Node pre = null;
        Node succ = null;

    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        // add your code here
        Node keyNode = getKeyNode(root, key);
        Node ans =null;
         getKey(root, ans, key);
        if (ans == null){
        System.out.println("ans null ");
            return;
        }
        else {
            Node pre = getPre(ans);
            Node succ = getSuc(ans);
            int preData= (pre!=null)?pre.data:(-1);
            int succData=(succ!=null)?succ.data:(-1);


            System.out.println(" pre : "+preData+ "  succ : "+succData);

        }

    }

    public static Node getKeyNode(Node root, int key) {
        if (root == null) {
            return null;

        }
        Node ans = null;

        if (root.data > key) {
            ans = getKeyNode(root.left, key);
        } else if (root.data < key) {
            ans = getKeyNode(root.right, key);
        } else if (root.data == key) {
            ans = root;
        }
        return ans;

    }
    public static void getKey(Node root ,Node ans ,int key ){
        if(root ==  null  ){
            return ;

        }
        if(root.data==key)
        {
           git status 
           
        }
         else if(root.data>key)
        {
            getKey(root.left, ans, key);
        }
       else if(root.data<key)
        {
            getKey(root.right, ans, key);
        }
        return ;

        
    }

    public static Node getPre(Node root) {
        if (root.left == null)
            return null ;
            Node temp=root.left;

            while(temp.right!=null)
            {
                temp=temp.right;
            }


        return temp;
    }

    public static Node getSuc(Node root) {

        if (root.right == null)
            return null;

        Node temp = root.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;

    }
}
