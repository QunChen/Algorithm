package algorithm.list;

import java.util.Arrays;

/**
 * Created by qun.chen on 8/6/17.
 */
public class MergeSortedArray88 {

    public  static void main(String[] argv){
        int[] nums1={1};
        int[] nums2={};
        MergeSortedArray88 mergeSortedArray88=new MergeSortedArray88();
        mergeSortedArray88.merge(nums1,1,nums2,0);
        System.out.print(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result=new int[m+n];
        int index1=0;
        int index2=0;
        while(index1<m&&index2<n){
            if(nums1[index1]<=nums2[index2]){
                result[index1+index2]=nums1[index1];
                index1++;
            }else{
                result[index1+index2]=nums2[index2];
                index2++;
            }
        }

        while(index2<n){
            result[index1+index2]=nums2[index2];
            index2++;
        }

        while(index1<m){
            result[index1+index2]=nums1[index1];
            index1++;
        }
        System.arraycopy(result,0,nums1,0,m+n);
    }

}
