package BST;

public class BST_to_Balanced_BST {
    
    List <TreeNode > list =new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
    
        inorder(root);
        // System.out.println( list );
        
        
        return array_to_Balanced_BST(0 ,list.size() -1 );
        
    }
    void inorder(TreeNode root  ){
        if( root == null ) return ;
        
        inorder(root.left);
        
        list .add(root);
        
        inorder(root.right);
        
    }
    TreeNode  array_to_Balanced_BST(int start , int end  )
    {
        if(start > end ) return null ;
          int mid = (start + end )/2;
        
        TreeNode root=list.get( mid );
         
        root.left =array_to_Balanced_BST(start ,mid-1);
        
        root.right  =array_to_Balanced_BST(mid+1 ,end  );
        // System.out.println( root.val );
        
        return root ;
        
        
    }
}

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return null;
        
        List<TreeNode> serialized = serialize(root);
        int l = 0;
        int r = serialized.size() - 1;
        return constructBST(serialized, l, r);
    }
    
    private TreeNode constructBST(List<TreeNode> serialized, int l, int r){
        if(l > r)
            return null;
        
        int mid = l + (r - l) / 2;
        
        TreeNode current = serialized.get(mid);
        current.left = constructBST(serialized, l, mid - 1);
        current.right = constructBST(serialized, mid + 1, r); 
        return current;
    }
    
    private List<TreeNode> serialize(TreeNode node){
        List<TreeNode> current = new ArrayList<>();
        if(node.left != null){
            List<TreeNode> left = serialize(node.left);
            left.addAll(current);
            current = left;
        }
        
        current.add(node);
        
        if(node.right != null){
            List<TreeNode> right = serialize(node.right);
            current.addAll(right);
        }
        return current;
        
    }
}

