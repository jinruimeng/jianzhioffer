public class Q52 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        int length1 = 0;
        int length2 = 0;

        ListNode cur = pHead1;
        while (cur != null) {
            length1++;
            cur = cur.next;
        }

        cur = pHead2;
        while (cur != null) {
            length2++;
            cur = cur.next;
        }

        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        if (length1 > length2) {
            for (int i = 1; i <= length1 - length2; i++)
                cur1 = cur1.next;
        } else {
            for (int i = 1; i <= length2 - length1; i++)
                cur2 = cur2.next;
        }

        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }
}
