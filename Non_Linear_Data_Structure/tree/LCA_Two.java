package tree;

import tree.heightBalanceTree.ans;

public class LCA_Two {

    int d1;
    int d2;
    int lca;

    int findDist(Node root, int a, int b) {
        

        Node lca_node=getLca(root, a, b);
       d1=getLength(root, a);
       d2=getLength(root, b) ;

       int lca_data=getLca(root, a, b).data;
       lca=getLength(root, lca_data);


        // getLeftLca(root, 0, a, d1);
        // getLeftLca(root, 0, b, d2);
        // getLeftLca(root, 0, lca_node.data,lca );
        int ans = d1+d2 - (2*lca);

        return ans ; 

    }
    Node getLca(Node root, int a, int b ){
        if(root == null ) return null ;

        if(root.data == a || root.data== b) return root ;

        Node left = getLca(root.left, a, b)
        Node right  = getLca(root.right, a, b)
        
        if(left !=null &&  right !=null ) return root;
        if(left ==null &&  right ==null ) return null;

        return (left!=null) ? left : right;


    }

    public int getLength(Node root,int a)
    {
        if(root == null ) return 0 ; 
        else {
            int x=0;
            if((root.data==a) ||  ( (x=getLength(root.left, a) ) > 0) || (  ( x=getLength(root.right, a)) > 0  ) )
            return x+1;

        }



        return 0 ;
    }
    
}
