package task2;

/**
 * Created by Avazbek on 26/12/24.
 */
public class Test {

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.toString());
        stack.push(7);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.peek());
    }
}
