public class Q18 {

    static class ListNode {
        int nodeValue;
        ListNode nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();

        head.nodeValue = 1;
        temp1.nodeValue = 2;
        temp2.nodeValue = 3;
        temp3.nodeValue = 4;
//        head.nextNode = null;
        head.nextNode = temp1;
        temp1.nextNode = temp2;
        temp2.nextNode = temp3;
        temp3.nextNode = null;

        System.out.println("删除前的链表：");
        printList(head);

        if (deleteNode(head, temp3) == true) {
            head = null;
        }
        System.out.println("删除后的链表：");
        printList(head);//执行删除操作

    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.nodeValue + "  ");
            temp = temp.nextNode;
        }
        System.out.println();
    }

    public static boolean deleteNode(ListNode head, ListNode toBeDeleted) {

        boolean toBeDeletedIsStartAndEnd = false;
        //参数校验
        if (head == null || toBeDeleted == null) {
            System.out.println("目标节点或链表为空");
            return toBeDeletedIsStartAndEnd;
        }

        //待删除的是尾节点
        if (toBeDeleted.nextNode == null) {
            //链表中只有一个节点，那么待删除的节点既是头结点，又是尾结点
            if (head == toBeDeleted) {
                System.out.println("删除目标节点后，链表为空");
                toBeDeletedIsStartAndEnd = true;
                return toBeDeletedIsStartAndEnd;
            } else {    //待删除的是尾节点，但不是唯一节点
                ListNode temp = head;
                while (temp.nextNode != null) {
                    if (temp.nextNode == toBeDeleted) {
                        temp.nextNode = null;
                        System.out.println("删除成功");
                        return toBeDeletedIsStartAndEnd;
                    }
                    temp = temp.nextNode;
                }
                System.out.println("链表不存在目标节点");
            }
        } else {
            toBeDeleted.nodeValue = toBeDeleted.nextNode.nodeValue;
            toBeDeleted.nextNode = toBeDeleted.nextNode.nextNode;
        }
        System.out.println("删除成功");
        return toBeDeletedIsStartAndEnd;
    }
}
