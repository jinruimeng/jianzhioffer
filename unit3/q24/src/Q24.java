import java.util.Currency;

public class Q24 {
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
        temp1.next = null;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;

        System.out.println("反转前：");
        printList(head);
        System.out.println();
        //执行反转操作
        ListNode reverseHead = reverse(head);
        printList(reverseHead);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "");
            head = head.next;
        }
    }

    static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode beforeNode = null;
        ListNode curNode = head;
        ListNode afterNode;

        while (curNode != null) {
            afterNode = curNode.next;
            curNode.next = beforeNode;
            beforeNode = curNode;
            curNode = afterNode;
        }

        return beforeNode;
    }
}
