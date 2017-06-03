package algorithm.list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by qun.chen on 28/5/17.
 * create an array to store current max
 * use a deque to contain sliding window
 * 1. add to sliding window size
 * 2. move the first and add the next
 * 3. in the array store the current max, if one value is larger than previous,
 * pop them, if small, add to array as the next largest one after the larger one.
 * O(n)
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[]{};
        }
        int[] max = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            if (i - k + 1 > 0) {
                deque.remove(i - k);
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.add(i);

            if (i - k + 1 >= 0) {
                max[i - k + 1] = nums[deque.peekFirst()];
            }

        }
        return max;
    }
}
