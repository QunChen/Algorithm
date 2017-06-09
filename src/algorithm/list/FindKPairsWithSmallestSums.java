package algorithm.list;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by qun.chen on 8/6/17.
 */
public class FindKPairsWithSmallestSums {

    public static void main(String[] argv){
        //Given [1,1,2][1,2,3]10
        int[] nums1={1,7,11};
        int[] nums2={2,4,6};

        FindKPairsWithSmallestSums findKPairsWithSmallestSums=new FindKPairsWithSmallestSums();
        System.out.print(findKPairsWithSmallestSums.kSmallestPairs(nums1,nums2,3));
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0){
            return new ArrayList<>();
        }

        PriorityQueue<int[]> queue=new PriorityQueue<>((l1, l2)->(l1[0]+l1[1])-(l2[0]+l2[1]));

        List<int[]> result=new ArrayList<>();

        for(int i=0;i<Math.min(nums1.length,k);i++){
            for(int j=0;j<Math.min(nums2.length,k);j++){
                queue.offer(new int[]{nums1[i],nums2[j]});
            }
        }

        while(!queue.isEmpty()&&k>0){

            result.add(queue.poll());
            k--;
        }

        return result;
    }
}
