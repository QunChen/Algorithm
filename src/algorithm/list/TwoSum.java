package algorithm.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 8/6/17.
 */
public class TwoSum {

    public static void main(String[] argv){
        TwoSum twoSum=new TwoSum();
        int[] nums={2, 7, 10, 15};
        System.out.print(Arrays.toString(twoSum.twoSum(nums,17)));
    }

    /**
     * create a hash map,
     * if not contain the compliment, add
     * otherwise, return indexes
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[0];
        }

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }

        return new int[0];
    }
}
