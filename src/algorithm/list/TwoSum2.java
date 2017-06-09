package algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 9/6/17.
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null||numbers.length<2){
            return null;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(i>1&&numbers[i]==numbers[i-2]){
                continue;
            }
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i+1};
            }else{
                map.put(numbers[i],i+1);
            }
        }

        return null;
    }
}
