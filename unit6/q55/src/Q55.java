public class Q55 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        else return max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
