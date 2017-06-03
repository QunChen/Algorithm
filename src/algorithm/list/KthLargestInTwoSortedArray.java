package algorithm.list;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by qun.chen on 6/5/17.
 * need to check corner case, too complicated
 * 1. get step (a.length+b.length-k+1)/2,
 * 2. than compare the number of each at the step position, the large one means all
 * later ones must larger than k, count it
 * 3. update smaller side to large part and larger side to smaller part
 * 4. half the step
 * 5. than do 2,3,4 when remove k-1 larger ones
 * 6. compare the larger between end of each array
 * O(lgn)
 *
 */
public class KthLargestInTwoSortedArray {

    public static void main(String[] argv){
        int[] a={1,3,5,7,9,12};
        int[] b={10,11,13,15,17,19};

        System.out.print(findKthLargest(a,b,5));
    }

    public static int findKthLargest(int[] a,int[]b, int k) {
        if (a.length + b.length <= k) {
            return -1;
        }

        int a_s=0;
        int b_s=0;
        int a_e = a.length-1 ;
        int b_e = b.length-1 ;
        int step = (a.length+b.length-k+1)/2;
        int total=0;



        while(total==k-1){
            if(a[a_s+step-1]>b[b_s+step-1]){
                int temp=a_e;
                a_e-=step-1;
                b_s+=step;
                total+=temp-a_e;

            }else if(a[a_s+step-1]<b[b_s+step-1]){
                int temp=b_e;
                a_s+=step;
                b_e-=step-1;
                total+=temp-b_e;

            }else{
                break;
            }
            step/=2;
        }



        return Math.max(a[(a_e-a_s)/2], b[(b_e-b_s)/2]);

    }
}


