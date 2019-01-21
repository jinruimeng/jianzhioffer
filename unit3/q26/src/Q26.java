import javax.swing.tree.TreeNode;

class Q26 {
    // 二叉树节点的定义
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //判断Tree1中是否含有Tree2
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val == root2.val)
            result = DoesTree1HaveTree2(root1, root2);

        if (result == false)
            result = (HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));

        return result;
    }

    //在两个二叉树根节点相等情况下，Tree1中是否含有Tree2
    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 == null || root2 == null) {
            if (root2 == null)
                return true;
            else
                return false;
        }

        if (root1.val == root2.val) {
            result = DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
        }

        return result;
    }
}
