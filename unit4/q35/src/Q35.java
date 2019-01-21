import java.util.HashMap;
import java.util.Map;

public class Q35 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //方法一：
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        Map<RandomListNode, RandomListNode> randomMap = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode pHead2 = new RandomListNode(pHead.label);
        cloneLabelAndNext(pHead, pHead2, randomMap);
        cloneRandom(pHead, pHead2, randomMap);

        return pHead2;
    }

    public void cloneLabelAndNext(RandomListNode node, RandomListNode node2, Map<RandomListNode, RandomListNode> randomMap) {
        randomMap.put(node, node2);
        if (node.next != null) {
            RandomListNode next2 = new RandomListNode(node.next.label);
            node2.next = next2;
            cloneLabelAndNext(node.next, next2, randomMap);
        } else
            node2.next = null;
    }

    public void cloneRandom(RandomListNode node, RandomListNode node2, Map<RandomListNode, RandomListNode> randomMap) {
        if (node.random != null) {
            node2.random = randomMap.get(node.random);
        } else
            node2.random = null;
        if (node.next != null) {
            cloneRandom(node.next, node2.next, randomMap);
        }
    }

    //方法二：
    public RandomListNode clone2(RandomListNode pHead) {
        if (pHead == null)
            return null;

        cloneLabelAndConnect(pHead);
        cloneRandom2(pHead);
        return reconnect(pHead);
    }

    public void cloneLabelAndConnect(RandomListNode node) {
        RandomListNode node2 = new RandomListNode(node.label);
        if (node.next != null) {
            RandomListNode next = node.next;
            node.next = node2;
            node2.next = next;
            cloneLabelAndConnect(next);
        } else {
            node.next = node2;
            node2.next = null;
        }
    }

    public void cloneRandom2(RandomListNode node) {
        if (node.random != null)
            node.next.random = node.random.next;
        if (node.next.next != null)
            cloneRandom2(node.next.next);
    }

    public RandomListNode reconnect(RandomListNode node) {
        RandomListNode cur = node;
        RandomListNode result = node.next;
        while (cur.next.next != null) {
            RandomListNode node2 = cur.next;
            cur.next = node2.next;
            node2.next = node2.next.next;
            cur = cur.next;
        }
        cur.next = null;

        return result;
    }
}
