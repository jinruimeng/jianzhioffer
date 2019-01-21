public class Q8 {
    static class BinaryTreeNode {
        Object value;
        BinaryTreeNode father;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode getFather() {
            return father;
        }

        public void setFather(BinaryTreeNode father) {
            this.father = father;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }

    public static BinaryTreeNode getNextNode(BinaryTreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        BinaryTreeNode tempNode = null;

        // 如果该节点有右子节点
        if (pNode.getRight() != null) {
            tempNode = pNode.getRight();
            while (tempNode.getLeft() != null) {
                tempNode = tempNode.getLeft();
            }
            return tempNode;
        }

        // 如果该节点没有右子节点，它是其父节点的左子节点
        if (pNode.getFather() == null)
            return null;
        if (pNode.getFather().getLeft() == pNode) {
            return pNode.getFather();
        }

        // 如果该节点没有右子节点，它是其父节点的右子节点
        tempNode = pNode.getFather();
        while (tempNode.getFather() != null) {
            if (tempNode.getFather().getLeft() == tempNode) {
                return tempNode.getFather();
            }
            //继续向上找父节点
            tempNode = tempNode.getFather();
        }
        return null;
    }
}
