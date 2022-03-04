package tree;

public class sumOfLongestPath {
    public int sumOfLongRootToLeafPath(Node root) {
        //
        int maxSum = 0;
        int sum = 0;
        int level = 0;
        int len = 0;
        findSum(root, maxSum, sum, level, len);
        System.out.println(maxSum);

        return 0;

    }

    private void findSum(Node root, int maxSum, int sum, int level, int len) {
        if (root == null)
            return;
        if (level > len) {
            len = level;
            maxSum = sum;

        } else if (len == level && sum > maxSum) {
            len = level;
            maxSum = sum;

        }

        findSum(root.left, maxSum, sum + root.data, level + 1, len);
        findSum(root.right, maxSum, sum + root.data, level + 1, len);

        return;

    }

}
