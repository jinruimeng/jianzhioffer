public class Q36 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Q36 test = new Q36();
        test.Convert(node1);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;

        ConvertCore(pRootOfTree);

        TreeNode head = pRootOfTree;
        while (head.left != null)
            head = head.left;

        return head;
    }

    public void ConvertCore(TreeNode pRootOfTree) {
        TreeNode left = pRootOfTree.left;
        TreeNode right = pRootOfTree.right;

        if (left != null) {
            TreeNode maxLeft = left;
            while (maxLeft.right != null)
                maxLeft = maxLeft.right;
            ConvertCore(left);
            pRootOfTree.left = maxLeft;
            maxLeft.right = pRootOfTree;
        }


        if (right != null) {
            TreeNode minRight = right;
            while (minRight.left != null)
                minRight = minRight.left;
            ConvertCore(right);
            pRootOfTree.right = minRight;
            minRight.left = pRootOfTree;
        }
    }

    //改进版
    //解题思路：
    //思路与方法二中的递归版一致，仅对第2点中的定位作了修改，新增一个全局变量记录左子树的最后一个节点。
    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
    protected TreeNode leftLast = null;

    public TreeNode Convert2(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            leftLast = root;// 最后的一个节点可能为最右侧的叶节点
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert2(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }
}
