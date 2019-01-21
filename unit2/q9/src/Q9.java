import java.util.Stack;

public class Q9 {
    public static void main(String[] args) {
        CQueue<Integer> queue = new CQueue<>();

        //进队列
        for (int i = 0; i < 5; i++) {
            queue.appendTail(i);
        }

        //出队列
        for (int i = 0; i < 5; i++) {
            int temp = queue.deleteHead();
            System.out.print(temp + "  ");
        }
    }

    static class CQueue<E> {
        private Stack<E> stack1;
        private Stack<E> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(E node) {
            stack1.push(node);
        }

        public E deleteHead() {
            if (stack1.size() == 0 && stack2.size() == 0) {
                throw new RuntimeException();
            }

            if (stack2.size() == 0) {
                while (stack1.size() != 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
