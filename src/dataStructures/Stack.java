package dataStructures;

import java.util.Arrays;

/**
 * Created by qun.chen on 11/6/17.
 */
public class Stack {
    public static void main(String[] argv){
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int[] elementData;

    public Stack(){
        elementData=new int[DEFAULT_CAPACITY];
    }

    public int peek(){
        return elementData[size-1];
    }

    public int pop(){
        int old = elementData[size-1];
        elementData[size-1]=0;
        size--;
        return old;
    }

    public int push(int val){
        if(size==elementData.length-1){
            grow((size+1)*2);
        }
        elementData[size]=val;
        size++;
        return val;
    }

    private void grow(int minCapacity) {
        elementData= Arrays.copyOf(elementData,minCapacity);
    }
}
