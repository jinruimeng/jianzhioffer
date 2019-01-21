import java.util.ArrayList;
import java.util.Stack;

public class Q34 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两种方法
        Stack<TreeNode> path = new Stack<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        if (root == null || target < root.val)
            return result;
        else {
            //两种方法
            FindPathCore(result, path, root, target);
            FindPathCore2(result, path2, root, target);
        }

        return result;

    }

    //方法一：用栈存路径
    public ArrayList<ArrayList<Integer>> FindPathCore(ArrayList<ArrayList<Integer>> result, Stack<TreeNode> path, TreeNode root, int target) {
        Stack<Integer> tmp = new Stack<>();
        ArrayList<Integer> thisPath = new ArrayList<>();

        if (root == null) {
            return result;
        }
        if (root.val == target && root.left == null && root.right == null) {
            tmp.push(root.val);

            Stack<TreeNode> thisPathNode = (Stack<TreeNode>) path.clone();
            while (!thisPathNode.isEmpty())
                tmp.push(thisPathNode.pop().val);
            while (!tmp.isEmpty())
                thisPath.add(tmp.pop());
            result.add(thisPath);
        }
        if (root.val > target)
            return result;

        path.push(root);
        target = target - root.val;
        FindPathCore(result, path, root.left, target);
        FindPathCore(result, path, root.right, target);

        //遍历完要弹出
        path.pop();
        return result;
    }

    //方法二：用队列存路径
    public ArrayList<ArrayList<Integer>> FindPathCore2(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, TreeNode root, int target) {

        if (root == null) {
        } else if (root.val > target) {

        } else if (root.val == target && root.left == null && root.right == null) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        } else {
            path.add(root.val);
            target = target - root.val;
            FindPathCore2(result, path, root.left, target);
            FindPathCore2(result, path, root.right, target);

            //遍历完该节点的左右节点后，要弹出该节点
            path.remove(path.size() - 1);
        }
        return result;
    }
}
