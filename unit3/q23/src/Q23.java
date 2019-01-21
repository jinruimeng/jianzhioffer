public class Q23 {
    static class ListNode {
        int value;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();

        head.value = 0;
        temp1.value = 1;
        temp2.value = 2;
        temp3.value = 3;
        temp4.value = 4;
        temp5.value = 5;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;

        ListNode resultNode = getEnterNode(head);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("您输入的参数有误！");
        }
    }

    public static ListNode getEnterNode(ListNode head) {
        //参数校验
        if (head == null || head.next == null) {
            return null;
        }

        //如果有环，第一个和第二个指针在环中相遇时的节点
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null || fast.next.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next == slow)
            return slow;

        //确定环中节点数目
        int num = 1;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            num++;
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = head;
        while (num > 0) {
            fast = fast.next;
            num--;
        }

        //找出环的入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
