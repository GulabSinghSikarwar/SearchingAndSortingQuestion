package tree;

public class BuildTree {
    public static Node buildTree(int inorder[], int preorder[], int n) {
        // code here
         return buidTreeUitl(inorder, preorder, 0, preorder.length-1);

    }

    static int pre = 0;

    public static Node buidTreeUitl(int[] inorder, int preorder[], int start, int end) {
        if (start > end)
            return null;
            
            Node root = new Node(preorder[pre]);
        if (start == end) {
            return root;
        }
        else{
            int ele=preorder[pre]
            int index=getIndex( inorder ,start,end,root.data );
            buidTreeUitl(inorder, preorder, start, index-1);
            buidTreeUitl(inorder, preorder, start+1, end);
            return root;
            

        }

    }

    private static int getIndex(int[] inorder, int start, int end, int data) {
        for (int i = start; i <=end; i++) 
        {
            if(inorder[i]==data)
            return i;

            
        }
        return 0;
    }

}
