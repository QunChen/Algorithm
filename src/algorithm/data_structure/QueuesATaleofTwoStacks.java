package algorithm.data_structure;

/**
 * Created by qun.chen on 24/4/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueuesATaleofTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        /**
         * push to newest stack
         * O(1)
         * @param value
         */
        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);

        }

        /**
         * before peek, check oldest stack
         * O(1)
         * @return
         */
        public T peek() {
            preOld();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            preOld();
            return stackOldestOnTop.pop();
        }

        /**
         * when the oldest stack is empty
         * push the newest in, so the order is satisfied
         * O(n)
         */
        public void preOld() {
            if (stackOldestOnTop.isEmpty())
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
        }
    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}