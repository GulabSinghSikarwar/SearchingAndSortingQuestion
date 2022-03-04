package tree;

import tree.diagnolTraversal.Tree.node;

public class LCA {

	// * Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Node lca(Node root, int n1, int n2) {
		// Your code here
		if (root == null)
			return null;

		return null;

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;

		return (left!=null )? left : right;
		
	}
}
