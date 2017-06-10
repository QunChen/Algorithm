package algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 8/6/17.
 */
public class Subsets {

    public static void main(String[] argv){
        int[] nums ={1,2,3};
        Subsets subsets=new Subsets();
        System.out.print(subsets.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        result.add(new ArrayList<>(temp));

        subsets(nums,0,result,temp);

        return result;
    }

    private void subsets(int[] nums,int start,List<List<Integer>> result,List<Integer> temp){
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            subsets(nums,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }

}
