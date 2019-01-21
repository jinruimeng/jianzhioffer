public class Q28 {
    //二叉树的定义
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetrical(TreeNode root) {
        return isSymmetricalCore(root, root);
    }

    public static boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;
        else
            return isSymmetricalCore(left.left, right.right) && isSymmetricalCore(left.right, right.left);
    }
}
