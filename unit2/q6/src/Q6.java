import java.util.Stack;

public class Q6 {
    public static void main(String[] args) {
/*        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;*/

        ListNode node1 = null;

        printListReverseByStack(node1); // 调用栈方法
        printListReverseByRecursion(node1); // 调用递归方法
    }

    static class ListNode {
        Object value;
        ListNode next;
    }

    // 用栈的思想来实现链表的倒序输出
    public static void printListReverseByStack(ListNode headNode) {
        Stack<ListNode> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }

    public static void printListReverseByRecursion(ListNode headNode) {
        if (headNode == null) {
            return;
        }
        printListReverseByRecursion(headNode.next);
        System.out.println(headNode.value);

    }
}
