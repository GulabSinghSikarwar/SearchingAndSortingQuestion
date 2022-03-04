package tree;

public class isoMorphic {

    boolean isIsomorphic(Node root1, Node root2) {
        // code here.

        return checkIso(root1,root2);

    }

    boolean checkIso(Node root, Node current) {
        if (root == null && current == null)
            return true;

        if ((root == null && current != null) || (root != null && current == null))
            return false;

        boolean currentAns = false;

        if (isAlreadySame(root, current)) {
            currentAns = true;

        } else if (isCrossSame(root, current)) {
            currentAns = true;
            Node currentLeftTemp = current.left;
            Node currentRightTemp = current.right;
            current.left = currentRightTemp;
            current.right = currentLeftTemp;

        }

        return currentAns && checkIso(root.left, current.left) && checkIso(root.right, current.right);
    }

    boolean isAlreadySame(Node root, Node current) {

        boolean rootLeft = !(root.left == null);
        boolean rootRight = !(root.right == null);
        boolean currentLeft = !(current.left == null);
        boolean currentRight = !(current.right == null);
        if (rootLeft && rootRight && currentLeft && currentRight)

        {
            if (root.left.data == current.left.data && root.right.data == current.right.data)
                return true;
        }
        // means all are not Null

        // if left side of both is Null or not
        boolean left_side_same = false;
        if (rootLeft == true && currentLeft == true)

        {
            left_side_same = root.left.data == current.left.data;

        } else if (rootLeft == false && currentLeft == false) {
            left_side_same = true;

        }
        boolean right_sideSame = false;
        if (rootRight == true && currentRight == true)

        {
            right_sideSame = root.right.data == current.right.data;

        } else if (rootRight == false && currentRight == false) {
            right_sideSame = true;

        }

        return right_sideSame && left_side_same;

    }

    boolean isCrossSame(Node root, Node current) {

        boolean rootLeft = !(root.left == null);
        boolean rootRight = !(root.right == null);
        boolean currentLeft = !(current.left == null);
        boolean currentRight = !(current.right == null);

        if (rootLeft && rootRight && currentLeft && currentRight)

        {
            if (root.left.data == current.right.data && root.right.data == current.left.data)
                return true;
        }

        boolean left_same = false;

        if (rootLeft == true && currentRight == true) {
            left_same = root.left.data == current.right.data;
        } else if (rootLeft == false && currentRight == false) {
            left_same = true;
        }

        boolean right_Same = false;
        if (currentLeft == true && rootRight == true) {
            right_Same = root.right.data == current.left.data;
        } else if (currentLeft == false && rootRight == false) {
            right_Same = true;
        }

        return left_same && right_Same;
    }
}
class isoMorphicSol{
    boolean isIsomorphic(Node a , Node b) {
        // code here.
        if(a==null && b == null)
        return true ;
        if(a==null || b==null )
        return false ;
        
        if(a.data!=b.data)
        return false ;
        
        return (isIsomorphic(a.left ,b.left)  && isIsomorphic(a.right,b.right))
        || ( isIsomorphic(a.left,b.right) && isIsomorphic (a.right,b.left));
        
        

      

    }
}
