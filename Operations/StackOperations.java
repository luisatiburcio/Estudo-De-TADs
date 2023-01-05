package Operations;
import Stack.Stack;

public class StackOperations {

    Stack<Object> result;

    public StackOperations() {

        Stack<Object> stack1 = new Stack<Object>();
        Stack<Object> stack2 = new Stack<Object>();
      
        result = union(stack1, stack2);
        System.out.println(result);

        result = difference(stack1, stack2);
        System.out.println(result);

        System.out.println(belong(stack1, stack2));

    }

    public Stack<Object> union(Stack<Object> stack1, Stack<Object> stack2) {

        Stack<Object> union = new Stack<Object>();

        for (Object s : stack1) {
            union.push(s);
        }

        for (Object s : stack2) {
            union.push(s);
        }

        return union;
    }

    public boolean belong(Stack<Object> stack1, Stack<Object> stack2) {

        for (Object s : stack1) {
            if (verify(s, stack2)) {
                return true;
            }
        }
        return false;
    }

    private boolean verify(Object arg, Stack<Object> args) {

        for (Object s : args) {
            if (s.equals(arg)) {
                return true;
            }
        }
        return false;
    }

    public c difference(Stack<Object> stack1, Stack<Object> stack2) {

        Stack<Object> difference = new Stack<Object>();

        for (Object s : stack1) {
            if (!verify(s, stack2)) {
                difference.push(s);
            }
        }

        for (Object s : stack2) {
            if (!verify(s, stack1)) {
                difference.push(s);
            }
        }

        return difference;
    }

    public static void main(String[] args) {
        new StackOperations();
    }
}
