package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 24/5/17.
 */
public class SummaryRanges {

    public static void main(String[] argv){
        System.out.print(summaryRanges(new int[]{0,5,9}));
    }

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
