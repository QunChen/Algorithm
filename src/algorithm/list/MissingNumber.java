package algorithm.list;

/**
 * Created by qun.chen on 23/5/17.
 * 1. sum the total number
 * 2. get the max sum base on the number of length
 * 3. use the max sum - sum
 * O(n)
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

        }

        int maxSum=0;
        for(int i=0;i<=nums.length;i++){
            maxSum+=i;
        }

        return maxSum-sum;
    }
}
