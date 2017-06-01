package algorithm;

/**
 * Created by qun.chen on 23/5/17.
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
