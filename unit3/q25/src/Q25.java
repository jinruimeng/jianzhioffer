public class Q25 {
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

        ListNode head2 = new ListNode();
        ListNode temp11 = new ListNode();
        ListNode temp22 = new ListNode();
        ListNode temp33 = new ListNode();
        ListNode temp44 = new ListNode();
        ListNode temp55 = new ListNode();

        head2.value = 0;
        temp11.value = 1;
        temp22.value = 3;
        temp33.value = 5;
        temp44.value = 7;
        temp55.value = 9;
        head2.next = temp11;
        temp11.next = temp22;
        temp22.next = temp33;
        temp33.next = temp44;
        temp44.next = temp55;
        temp55.next = null;

        System.out.println("合并前：");
        printList(head);
        printList(head2);
        //执行反转操作
        ListNode mergeHead = merge(head, head2);
        printList(mergeHead);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode merge(ListNode head, ListNode head2) {
        if (head == null) {
            return head2;
        }
        if (head2 == null) {
            return head;
        }
        ListNode cur = head;
        ListNode cur2 = head2;
        ListNode next;
        ListNode next2;

        while (cur != null && cur2 != null) {
            next = cur.next;
            next2 = cur2.next;
            if (cur.value >= cur2.value) {
                cur2.next = cur;
                cur2 = next2;
            } else {
                cur.next = cur2;
                cur = next;
            }
        }

        return head.next == head2 ? head : head2;
    }
}
