public class Q37 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    String Serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();

        return (SerializeCore(root, result).toString());

    }

    StringBuilder SerializeCore(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("$,");
            return result;
        }

        result.append(node.val+",");
        SerializeCore(node.left, result);
        SerializeCore(node.right, result);

        return result;
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        //把各节点数值分开
        String[] strs = str.split(",");

        return DeserializeCore(strs);
    }

    int index = -1;

    TreeNode DeserializeCore(String[] strs) {
        index++;
        if (index >= strs.length)
            return null;
        if (!strs[index].equals("$")) {
            TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
            root.left = DeserializeCore(strs);
            root.right = DeserializeCore(strs);
            return root;
        } else
            return null;
    }

}
