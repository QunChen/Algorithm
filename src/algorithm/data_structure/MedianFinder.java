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

    /**
     * min heap for larger half, max heap for smaller half
     */
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((i1, i2) -> i2 - i1);
    }

    /**
     * first add to larger part
     * if the size difference over 1, move to smaller part
     * if the added one is smaller than the largest in the smaller part, swap
     * O(1)
     * @param num
     */
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

    /**
     * if the larger part is more than 1, get it
     * other wise get the average of both heap
     * O(1)
     * @return
     */
    public double findMedian() {
        if (minheap.size() - maxheap.size() == 1) {
            return minheap.peek();
        } else {
            return ((double) minheap.peek() + maxheap.peek()) / 2;
        }
    }
}
