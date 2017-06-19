package algorithm.list;

import java.util.*;

/**
 * Created by qun.chen on 6/6/17.
 */
public class ThirdMaximumNumber {

    public static void main(String[] argv){
        int[] nums={-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        ThirdMaximumNumber thirdMaximumNumber=new ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(nums));
    }

    /**
     * create a minheap
     * add unique number to min heap
     * if the size is over 3, poll the smallest one
     * return the first element in min heap, which is the the third largest
     * T:O(n)
     * S:O(1)
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for(int i:nums){
            if(!set.contains(i)){
                set.add(i);
                queue.offer(i);
                if(queue.size()>3){
                    queue.poll();
                }
            }
        }

        if(queue.size()==2){
            queue.poll();
        }

        return queue.poll();

    }
}
