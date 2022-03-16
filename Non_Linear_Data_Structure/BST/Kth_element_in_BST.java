package BST;

public class Kth_element_in_BST {
    


class Solution {
    class Ans{
    int x=-1;
  
    
    
}
    // Return the Kth smallest element in the given BST
    
    // int ans=0;
 int index ;
 
    
   public int KthSmallestElement(Node root, int K) {
        
        Ans ele=new Ans () ;
        
        getElement(root,K , ele);
        
        return ele.x  ;
        
    }
    public void getElement(Node root,int key , Ans  ele ){
        if(root==null)
        {
            return ;
        }
        getElement(root.left , key ,ele  );
        if((index+1)==key && ele.x == -1){
          
            ele.x=root.data ; 
            
            return ;
             
        }
        ++index;
        
       
        
        getElement(root.right , key , ele  );
        
        
    }
}


class Solution {
    public int KthSmallestElement(Node root, int k) {
        Node temp = MorrisInorderTraversal(root, k);
        if (temp != null)
            return temp.data;
        else
            return -1;
    }

    public Node MorrisInorderTraversal(Node root, int k) {
        if (root == null) return null;

        Node prev = null;
        Node curr = root;

        while (curr != null) {
            // check for presence of left subtree
            if (curr.left == null) {
                // If kth smallest is found
                if (k == 1) {
                    // Return the current node
                    return curr;
                }

                k--;
                // Traverse right subtree otherwise
                curr = curr.right;
            } else {
                // Find the inorder predecessor of current
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    // Make current as the right child of
                    // its inorder predecessor
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // Revert the changes to right child
                    // of predecessor
                    prev.right = null;
                    k--;
                    if (k == 0) return curr;

                    // Traverse right subtree
                    curr = curr.right;
                }
            }
        }

        return null;
    }
}
