package algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 24/5/17.
 */
public class SummaryRanges {

    public static void main(String[] argv){
        System.out.print(summaryRanges(new int[]{0,2,3,5,6,7,9}));
    }

    /**
     * 1. create a list for current range, initial with first element in the array
     * 2. loop the array,
     * a. if the difference between current and next is 1, add to the current list
     * b. otherwise add to result and clear the current and initial with this unsatisfied value
     * 3. add the last current range
     * 4. loop to print,
     * a. if the list size is over 1, print start to end
     * b. otherwise, print the single value
     * O(n)
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result=new ArrayList<>();

        List<Integer> current=new ArrayList<>();
        current.add(nums[0]);

        for(int i =1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                current.add(nums[i]);
            }else{
                List<Integer> add=new ArrayList<>();
                add.addAll(current);
                result.add(add);
                current.clear();
                current.add(nums[i]);
            }
        }

        List<Integer> add=new ArrayList<>();
        add.addAll(current);
        result.add(add);

        List<String> output=new ArrayList<>();

        for(List<Integer> ints:result){
            if(ints.size()==1){
                output.add(ints.get(0).toString());
            }else{
                output.add(ints.get(0)+"->"+ints.get(ints.size()-1));
            }
        }

        return output;
    }
}
