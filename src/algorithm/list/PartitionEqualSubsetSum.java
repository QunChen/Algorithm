package algorithm.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qun.chen on 170615.
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] argv){
        int[] nums={1,2,5};
        PartitionEqualSubsetSum partitionEqualSubsetSum=new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int sum=getSum(nums);
        if(sum%2!=0){
            return false;
        }

        sum/=2;

        boolean[] mem=new boolean[sum+1];

        mem[0]=true;
        for(int i=0;i<nums.length;i++){
            List<Integer> cadidates=new ArrayList<>();
            for(int j=0;j<mem.length;j++){
                if(mem[j]){
                    cadidates.add(j);
                }
            }

            for(int c:cadidates){
                if((c+nums[i])==sum){
                    return true;
                }else if((c+nums[i])<sum){
                    mem[c+nums[i]]=true;
                }
            }

        }

        return false;

    }

    private int getSum(int[] nums){
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return sum;
    }
}
