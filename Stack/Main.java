package Stack;

public class Main {

    public Main() {
        Stack<String> stack = new Stack<>();
        Stack<String> stackClone = new Stack<>();
        Stack<Object> stack2 = new Stack<>();
        Object[] stack3 = new Object[10];
        String teste1 = "A";
        String teste2 = "menina";
        String teste3 = "de cabelo";
        String teste4 = "azul";

        System.out.println(stack.isEmpty());

        stack.push(teste1);
        stack.push(teste2);
        stack.push(teste3);
        stack.push(teste4);

        System.out.println(stack);
        System.out.println(stack.peek());

        stack.pop();
        stack3 = stack2.copyForArray();
        System.out.println(stack3);

        stackClone = stack.clone(stack);

        if(stack.equals(stackClone)){
            System.out.println("São iguais!");
        }else{
            System.out.println("São diferentes!");
        }

        stack2.copyToArray(stack3);
        System.out.println(stack2);

        //System.out.println(stack.search(teste2)); 


    }

    public static void main(String[] args) {
        new Main();
    }
}
