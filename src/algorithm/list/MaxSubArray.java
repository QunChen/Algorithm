package algorithm.list;

/**
 * Created by qun.chen on 21/5/17.
 * loop the element, local max is the max between current or current add previous local max, if not adding the previous local max is
 * even high, means the previous local max is negative, the sub array stopped here, use the current item to start over
 * O(n)
 * max is the max localmax between max
 */
public class MaxSubArray {

    public static int max(int[] nums){
        int localMax=nums[0];
        int max=nums[0];

        for(int i:nums){
            localMax=Math.max(i,i+localMax);
            max=Math.max(localMax,max);
        }
        return max;
    }
}
