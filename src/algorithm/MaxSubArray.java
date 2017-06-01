package algorithm;

/**
 * Created by qun.chen on 21/5/17.
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
