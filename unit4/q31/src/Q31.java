import java.util.Stack;

public class Q31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int numA = 0;
        int numB = 0;
        if ((pushA == null && popA == null) || (pushA.length == 0 && popA.length == 0))
            return true;
        else if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0)
            return false;

        while (numA < pushA.length) {
            if (stack.isEmpty() || stack.peek() != popA[numB]) {
                stack.push(pushA[numA]);
                numA++;
            } else {
                stack.pop();
                numB++;
            }
        }
        while (!stack.isEmpty()) {
            if (popA[numB] != stack.pop())
                return false;
            numB++;
        }
        return true;
    }
}
