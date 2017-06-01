package algorithm.list;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by qun.chen on 6/5/17.
 */
public class KthLargestInTwoSortedArray {

    public static void main(String[] argv){
        int[] a={1,3,5,7,9,12};
        int[] b={2,4,6,8,10,11};

        System.out.print(findKthLargest(a,b,5));
    }

    public static int findKthLargest(int[] a,int[]b, int k) {
        if (a.length + b.length <= k) {
            return -1;
        }
        k=a.length+b.length-k+1;//find smallest

        int a_s=0;
        int b_s=0;
        int a_e = k ;
        int b_e = k ;
        int step = k/2;
        int total=0;

        while(total!=k){
            if(a[(a_e-a_s)/2]>b[(b_e-b_s)/2]){
                a_e-=step;
                b_s+=(b_e-b_s)/2+1;
                total+=a_e-a_s;
            }else if(a[(a_e-a_s)/2]<b[(b_e-b_s)/2]){
                a_s+=(a_e-a_s)/2+1;
                b_e-=step;
                total+=b_e-b_s;
            }else{
                break;
            }
            step/=2;
        }



        return Math.max(a[(a_e-a_s)/2], b[(b_e-b_s)/2]);

    }
}


