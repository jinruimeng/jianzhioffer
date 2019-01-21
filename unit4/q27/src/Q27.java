import java.util.LinkedList;
import java.util.Queue;

public class Q27 {
   static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //递归
    public static void Mirror(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null))
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.left);
        Mirror(root.right);
    }

    //非递归
    public static void Mirror2(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null))
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();

            //交换左右节点
            TreeNode tmp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tmp;

            if(curNode.left != null)
                queue.add(curNode.left);

            if(curNode.right != null)
                queue.add(curNode.right);
        }
    }
}
