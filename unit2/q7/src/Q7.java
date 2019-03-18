public class Q7 {
    public static void main(String[] args) {
        // 二叉树的先序序列
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        // 二叉树的中序序列
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = reconstructe(preOrder, inOrder);
        printPostOrder(root); // 后序打印二叉树
    }

    static class BinaryTreeNode {
        Object value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(Object value) {
            this.value = value;
        }

        public BinaryTreeNode(Object value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Object getValue() {
            return value;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }



    public static BinaryTreeNode reconstructe(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0) {
            return null;
        }

        // 二叉树的根节点
        BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
        root.setLeft(null);
        root.setRight(null);

        // 左子树节点的个数
        int leftNum = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if ((int) root.getValue() == inOrder[i]) {
                break;
            } else {
                leftNum++;
            }
        }

        // 重建左子树
        if (leftNum > 0) {
            int[] leftPreOrder = new int[leftNum];
            int[] leftInOrder = new int[leftNum];

            for (int i = 0; i < leftNum; i++) {
                leftPreOrder[i] = preOrder[i + 1];
                leftInOrder[i] = inOrder[i];
            }

            BinaryTreeNode leftNode = reconstructe(leftPreOrder, leftInOrder);
            root.setLeft(leftNode);
        }

        // 右子树节点的个数
        int rightNum = preOrder.length - 1 - leftNum;

        // 重构右子树
        if (rightNum > 0) {
            int[] rightPreOrder = new int[rightNum];
            int[] rightInOrder = new int[rightNum];

            for (int i = 0; i < rightNum; i++) {
                rightPreOrder[i] = preOrder[leftNum + 1 + i];
                rightInOrder[i] = inOrder[leftNum + 1 + i];
            }

            BinaryTreeNode rightNode = reconstructe(rightPreOrder, rightInOrder);
            root.setRight(rightNode);
        }

        return root;
    }

    /**
     * 后序遍历二叉树（递归实现）
     */
    public static void printPostOrder(BinaryTreeNode root) {
        if (root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.println(root.getValue());
        }
    }

}
