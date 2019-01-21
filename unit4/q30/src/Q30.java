import java.util.Stack;

public class Q30 {
    //数据栈
    Stack<Integer> dataStack = new Stack<>();
    //辅助栈
    Stack<Integer> minStack = new Stack<>();
    int minValue = 0;

    //进栈
    public void push(int node) {
        dataStack.push(node);

        if (minStack.isEmpty() || node <= minValue) {
            minValue = node;
        }

        minStack.push(minValue);
    }

    //出栈
    public void pop() {
        if (dataStack.isEmpty() || minStack.isEmpty())
            return;
        dataStack.pop();
        minStack.pop();
        if (!minStack.isEmpty())
            minValue = minStack.peek();
        else
            minValue = 0;
    }

    //取栈顶
    public int top() {
        if(!dataStack.isEmpty())
            return dataStack.peek();
        else
            return 0;
    }

    //取最小值
    public int min() {
        return minValue;
    }
}
