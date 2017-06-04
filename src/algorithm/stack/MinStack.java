package algorithm.stack;

import java.util.Stack;

/**
 * Created by qun.chen on 13/5/17.
 */
public class MinStack {
    private Stack<Integer> stack;
    private int min;


    //["MinStack","push","push","push","getMin","pop","getMin"]
    //        [[],[0],[1],[0],[],[],[]]
    public static void main(String[] argv){
        MinStack minStack=new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    public MinStack(){
        min=Integer.MAX_VALUE;
        stack=new Stack<>();
        stack.push(min);
    }

    /**
     * 1. if new element is less than current min,push the current min, which is the min
     * before current item. update the min
     * 2. then push the item
     * O(1)
     * @param i
     */
    public void push(int i){
        if(i<=min){
            stack.push(min);
            min=i;
        }
        stack.push(i);
    }

    /**
     * 1. pop the element
     * 2. if the popped element is equal to current the min
     * pop the next element to update min because it will be the min without popped
     * element
     * O(1)
     * @return
     */
    public void pop(){
        int i=stack.pop();
        if(i==min){
            min=stack.pop();
        }
    }

    public int top(){

        return stack.peek();
    }
    /**
     * O(1)
     * @return
     */
    public int getMin(){
        return min;
    }
}
