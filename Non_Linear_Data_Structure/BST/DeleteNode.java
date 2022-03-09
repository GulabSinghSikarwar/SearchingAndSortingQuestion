package BST;

import java.security.DrbgParameters.Reseed;

public class DeleteNode {


   /* public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        TreeNode prev = null;
        TreeNode temp = root;

        while (temp.val != key) {
            prev = temp;

            if (temp.val > key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            if (temp == null) {
                return root;

            }
        }

        // Now we Assume that value of temp is equal key ;
        if (isLeaf(temp)) {
            if (temp == root) {
                temp = null;
                return null;

            }

            temp = null;
            return root;

        } else if (isSingleChild(temp)) {
            if (temp.val > prev.val) {
                prev.right = (temp.left != null) ? temp.left : temp.right;
                temp = null;

            } else {
                prev.right = (temp.right != null) ? temp.right : temp.left;

            }

        } else {

            int getInorderSuccessor = getInorderSuccessor(temp.right, key);
            temp.val = getInorderSuccessor;

        }

        return root;
    }
 */
    boolean isLeaf(TreeNode root) {

        if (root.left == null && root.right == null)
            return true;
        return false;

    }

  /*  boolean isSingleChild(TreeNode root) {
        if (root.left == null && root.right != null || root.left != null && root.right == null)
            return true;
        return false;

    }
 */
 /*   int getInorderSuccessor(TreeNode root, int key) {

        if (isLeaf(root)) {
            int resultValue = root.val;
            root=null;
            
            return resultValue;

        } else if (isSingleChild(root)) {
            if (root.left == null) {
                int ans = root.val;
                root = root.right;
                return ans;

            }
        }
        TreeNode temp = root;
        TreeNode prev = null;
        while (temp.left != null) {
            prev = temp;
            temp = temp.left;
        }
        int result_value = temp.val;
        if (temp.right != null) {
            prev.right = temp.right;

        }
        temp = null;

        return result_value;

    }
 */

public TreeNode deleteNode(TreeNode root, int key) {
    
    if(root==null)
      return null;

      TreeNode pre=null;
      TreeNode curr=root;

      while(curr!=null && curr.val !=key)
      {
          if (curr.val<key) {
              curr=curr.right;
          }
          else{
              curr=curr.left;

          }
      }
      // mostly  we have got the value
      if(pre==null)
        return null;

        if(pre.left==curr)
        {
            pre.left=deleteRootNode(curr);

        }
        if (pre.right==curr) {
            pre.right=deleteRootNode(curr);
        }
      else{  pre.right=deleteRootNode(curr);}
        return root;




        
}

private TreeNode deleteRootNode(TreeNode curr) {
    if (curr==null) {
        return null;
    }
    if(curr.left==null)
      return curr.right;
    
    if (curr.right==null) 
          return curr.left;

     TreeNode next=findMin(curr.right);
     next.left=curr.left;
     return curr.right;

          


      


}

private TreeNode findMin(TreeNode temp) {
 
    while(temp.left!=null)
      temp=temp.left;

    return temp;
}

}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
