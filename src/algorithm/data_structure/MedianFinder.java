package algorithm.data_structure;

import java.util.PriorityQueue;

/**
 * Created by qun.chen on 8/6/17.
 */
public class MedianFinder {
    public static void main(String[] argv) {
        int[] nums = {1,2,3,8,9};
        MedianFinder medianFinder = new MedianFinder();
        for (int i : nums) {
            medianFinder.addNum(i);
            System.out.println(medianFinder.findMedian());
        }
    }


    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((i1, i2) -> i2 - i1);
    }

    public void addNum(int num) {
        minheap.offer(num);

        if(minheap.size()-maxheap.size()>1){
            maxheap.offer(minheap.poll());
        }

        while (!maxheap.isEmpty() && maxheap.peek() > minheap.peek()) {
            minheap.offer(maxheap.poll());
            maxheap.offer(minheap.poll());
        }


    }

    public double findMedian() {
        if (minheap.size() - maxheap.size() == 1) {
            return minheap.peek();
        } else {
            return ((double) minheap.peek() + maxheap.peek()) / 2;
        }
    }
}
