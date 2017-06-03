package algorithm.list;

import java.util.*;

/**
 * Created by qun.chen on 26/5/17.
 */
public class ThreeSum {

    public static void main(String[] argv){
        int[] sums={-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum=new ThreeSum();
        System.out.print(threeSum.threeSum(sums));
    }

    /**
     * 1. sort the array
     * 2. if the current value is same with previous, no need to calculate
     * 3. use the current value and find the sum is target - current
     * 4. set 2 pointers, one at next, one at end,
     * a. if sum of values at pointers equal to required, add to result, and then move to next different value from both start and end
     * b. if less than target, move start forward start
     * c. if larger than target, move end backward
     * O(n^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<nums.length-1;i++){

            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }

            int start=i+1;

            int end=nums.length-1;

            int target=0-nums[i];

            while(start<end){
                int sum=nums[start]+nums[end];
                if(sum==target){
                    List<Integer> temp=new ArrayList<>(3);
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    do{
                        start++;
                    }
                    while(start<end&&nums[start]==nums[start-1]);

                    do{
                        end--;
                    }
                    while(start<end&&nums[end]==nums[end+1]);
                }else if(sum<target){
                    do{
                        start++;
                    }
                    while(start<end&&nums[start]==nums[start-1]);
                }else if(sum>target){
                    do{
                        end--;
                    }
                    while(start<end&&nums[end]==nums[end+1]);
                }
            }
        }
        return result;
    }

}
