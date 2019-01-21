import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q32 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null)
                return result;
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                result.add(tmp.val);
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
            return result;
        }

        public ArrayList<ArrayList<Integer>> PrintFromTopToBottomByRows(TreeNode root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null)
                return result;

            int curLevel = 1;
            int nextLevel = 0;
            int currow = 0;

            queue.add(root);
            result.add(new ArrayList<>());

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                curLevel--;
                result.get(currow).add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    nextLevel++;
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                    nextLevel++;
                }

                if (curLevel == 0) {
                    currow++;
                    curLevel = nextLevel;
                    nextLevel = 0;
                    result.add(new ArrayList<>());
                }
            }
            result.remove(currow);
            return result;
        }

        public ArrayList<ArrayList<Integer>> PrintFromTopToBottomByRowsAndZhi(TreeNode root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            Stack<Integer> Stack = new Stack<>();
            if (root == null)
                return result;

            int curLevel = 1;
            int nextLevel = 0;
            int currow = 0;
            int zhi = 0;//0-从右到左 1-从左到右

            queue.add(root);
            result.add(new ArrayList<>());

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                curLevel--;
                if ((zhi & 1) == 0)
                    result.get(currow).add(tmp.val);
                else
                    Stack.push(tmp.val);

                if (tmp.left != null) {
                    queue.add(tmp.left);
                    nextLevel++;
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                    nextLevel++;
                }

                if (curLevel == 0) {
                    while (!Stack.isEmpty())
                                result.get(currow).add(Stack.pop());
                    currow++;
                    curLevel = nextLevel;
                    nextLevel = 0;
                    result.add(new ArrayList<>());
                    zhi = 1 - zhi;
                }
            }
            result.remove(currow);
            return result;
        }

        public ArrayList<ArrayList<Integer>> PrintFromTopToBottomByRowsAndZhi2(TreeNode root) {
            ArrayList<ArrayList<Integer>> aList=new ArrayList<>();
            if(root==null)
                return aList;

            Stack<TreeNode> s1=new Stack<TreeNode>();
            s1.add(root);
            Stack<TreeNode> s2=new Stack<TreeNode>();
            while(!s1.isEmpty()||!s2.isEmpty()){
                if(!s1.isEmpty()){
                    ArrayList<Integer> aList2=new ArrayList<Integer>();
                    while(!s1.isEmpty()){
                        TreeNode p=s1.pop();
                        aList2.add(p.val);
                        if(p.left!=null)
                            s2.add(p.left);
                        if(p.right!=null)
                            s2.add(p.right);
                    }
                    aList.add(aList2);
                }
                else {
                    ArrayList<Integer> aList2=new ArrayList<Integer>();
                    while(!s2.isEmpty()){
                        TreeNode p=s2.pop();
                        if(p.right!=null)
                            s1.add(p.right);
                        if(p.left!=null)
                            s1.add(p.left);
                        aList2.add(p.val);
                    }
                    aList.add(aList2);
                }
            }
            return aList;
        }

    }
}
