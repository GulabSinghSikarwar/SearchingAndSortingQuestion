package tree;

public class heightBalanceTree {
    
    class Node {
        int data;
        Node left, right;
        
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    
    class ans{
        boolean answer=false;

    }
    boolean isBalanced(Node root) {
        

     
        ans ans=new ans();
        int h=height(root,ans);
        return ans.answer;
        

    }
    boolean notbalance = false;
    
    public int height(Node root ,ans ans) {
        if (root == null)
            return 0;

            int left=height(root.left,ans);
            int right=height(root.right ,ans);
            int diff=left-right;

            int absDiff=Math.abs(diff);
            if (absDiff>1) {
                ans.answer=true
                notbalance=true;

            }

            int height=1+Math.max(left, right);



            return height;

    }

}
