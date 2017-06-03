package algorithm.list;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by qun.chen on 25/5/17.
 */
public class MinimumForEveryWindowSize {

    public static void main(String[] argv){
        int[] data = {1,-5,3,2,4,3};
        int[] result=findMins(data,3);
        System.out.print(Arrays.toString(result));
    }

    /**
     * 1. if the data size is less than k, sort it using heap and return the first
     * 2. Use a tree set to store all values, when reaching the size of k, remove the first one in the set, which is also the min one
     * 3. add new item into the tree set.
     * 4. finally set the last element in the tree set to the last result
     * @param data
     * @param k
     * @return
     */
    public static int[] findMins(int[] data,int k){
        if(data==null||k<=0){
            return new int[0];
        }

        if(data.length<=k){
            int[] result=new int[1];
            PriorityQueue<Integer> queue=new PriorityQueue<>();
            for(int i:data){
                queue.add(i);
            }
            result[0]=queue.poll();
            return result;
        }

        TreeSet<Integer> set = new TreeSet<>();
        int[] result=new int[data.length-k+1];
        for(int i=0;i<data.length;i++){
            if(i>k-1){
                result[i-k]=set.first();
                set.remove(data[i-k]);
            }
            set.add(data[i]);
        }

        result[data.length-k]=set.first();
        return result;
    }
}
