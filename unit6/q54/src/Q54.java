import java.util.Stack;

public class Q54 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //递归
/*    static int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0)
            return null;

        count = k;

        TreeNode result = KthNodeCore(pRoot);
        return result;
    }

    TreeNode KthNodeCore(TreeNode curNode) {
        TreeNode result = null;
        if (curNode == null)
            return result;

        if (curNode.left != null) {
            result = KthNodeCore(curNode.left);
        }

        if (result == null) {
            if (count-- == 1) {
                result = curNode;
            } else
                result = KthNodeCore(curNode.right);
        }

        return result;
    }*/

    //非递归
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        do {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (k-- == 1)
                    return node;
                node = node.right;
            }
        } while (node != null || !stack.isEmpty());
        return null;
    }
}
