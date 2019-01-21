public class Q22 {
    public static void main(String[] args) {
//        ListNode head = null;
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        temp6.value = 7;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = null;

        ListNode resultNode = findKthToTail(head, 7);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("您输入的参数有误！");
        }
    }

    static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode findKthToTail(ListNode head, int num) {
        if (head == null || num <= 0)
            return null;

        ListNode rightNode = head;
        ListNode lefttNode = head;

        while (num > 0) {
            if (rightNode == null)
                return null;

            rightNode = rightNode.next;
            num--;
        }

        while (rightNode != null) {
            rightNode = rightNode.next;
            lefttNode = lefttNode.next;
        }

        return lefttNode;
    }
}
