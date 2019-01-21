import java.util.LinkedList;

public class Q9_2 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    static class MyStack<E> {
        private LinkedList<E> queue1;
        private LinkedList<E> queue2;

        public MyStack() {
            queue1 = new LinkedList<E>();
            queue2 = new LinkedList<E>();
        }

        public void push(E node) {
            if (!queue2.isEmpty()) {
                queue2.add(node);
            } else {
                queue1.add(node);
            }
        }

        public E pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                throw new RuntimeException();
            }
            if (queue2.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.add(queue1.remove());
                }
                return queue1.remove();
            } else {
                while (queue2.size() > 1) {
                    queue1.add(queue2.remove());
                }
                return queue2.remove();
            }
        }
    }
}
