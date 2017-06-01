package algorithm.Stack;

import java.util.Stack;

/**
 * Created by qun.chen on 13/5/17.
 */
public class MinStack {
    private Stack<Integer> stack;
    private int min;

    public static void main(String[] argv){
        MinStack minStack=new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(5);
        minStack.push(4);
        minStack.push(1);
        minStack.push(6);

        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
    }

    public MinStack(){
        min=Integer.MAX_VALUE;
        stack=new Stack<>();
        stack.push(min);
    }

    public void push(int i){
        if(i<min){
            stack.push(min);
            min=i;
        }
        stack.push(i);
    }

    public int pop(){
        int i=stack.pop();
        if(i==min){
            min=stack.pop();
        }
        return i;
    }

    public int getMin(){
        return min;
    }
}
