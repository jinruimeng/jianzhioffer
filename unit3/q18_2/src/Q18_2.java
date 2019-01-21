public class Q18_2 {

    static class ListNode {
        int nodeValue;
        ListNode nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.nodeValue = 1;
        temp1.nodeValue = 1;
        temp2.nodeValue = 2;
        temp3.nodeValue = 4;
        temp4.nodeValue = 5;
        temp5.nodeValue = 7;
        temp6.nodeValue = 7;
        head.nextNode = temp1;
        temp1.nextNode = temp2;
        temp2.nextNode = temp3;
        temp3.nextNode = temp4;
        temp4.nextNode = temp5;
        temp5.nextNode = temp6;
        temp6.nextNode = null;

        System.out.println("删除前的链表：");
        printList(head);

        System.out.println();
        System.out.println("-----------------------");

        ListNode resultList = deleteDuplication(head); // 执行删除操作
        System.out.println("删除后的链表：");
        printList(resultList);
    }

    public static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = head; //当前节点
        ListNode preNode = new ListNode(); //前一个节点
        preNode.nextNode = currentNode;
        ListNode tmp = preNode;


        while (currentNode != null) {

            //判断是否存在重复节点，是否应该删除
            if (currentNode.nextNode != null && currentNode.nodeValue == currentNode.nextNode.nodeValue) {
                while (currentNode.nextNode != null && currentNode.nodeValue == currentNode.nextNode.nodeValue) {
                    currentNode = currentNode.nextNode;
                }
                //删除相应的重复节点
                preNode.nextNode = currentNode.nextNode;
            } else {      //preNode指针移动
                preNode = currentNode;
            }
            currentNode = currentNode.nextNode;
        }

        return tmp.nextNode;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.nodeValue + "");
            temp = temp.nextNode;
        }
        System.out.println();
    }
}
