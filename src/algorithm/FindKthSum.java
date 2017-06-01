package algorithm;

import java.util.*;

/**
 * Created by qun.chen on 25/5/17.
 */
public class FindKthSum {

    private static HashSet<Integer> set;

    public static void main(String[] argv){
        Integer[] data={1,2,3,4,5,6,7,8,9,10};
        System.out.print(findKthSum(data,12,3));
    }


    public static List<List<Integer>> findKthSum(Integer[] data,int target, int k){
        List<List<Integer>> results=new ArrayList<>();
        set=new HashSet<>();
        set.addAll(Arrays.asList(data));
        findKthSum(target,k,results);
        return results;
    }

    public static void findKthSum(int target, int k,List<List<Integer>> results){
        findSum(target,k,new HashSet<>(set),results,new ArrayList<>());
    }

    public static void findSum(int target,int number,Set<Integer> current,
                        List<List<Integer>> results, List<Integer> result){
        if(number==1){
            if(current.contains(target)){
                current.remove(target);
                result.add(target);
                List<Integer> add=new ArrayList<>(result);
                results.add(add);
                result.remove(result.size()-1);
                result.remove(result.size()-1);
                return;
            }
        }


        while(true){
            Iterator<Integer> iterator=current.iterator();
            if(iterator.hasNext()){
                int val=iterator.next();
                if(val<target){
                    result.add(val);
                    current.remove(val);
                    findSum(target-val,number-1,current,results,result);
                }
                current.add(val);
            }else{
                break;
            }

        }

    }


}
