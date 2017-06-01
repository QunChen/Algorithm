package algorithm;

import java.util.Arrays;

/**
 * Created by qun.chen on 20/5/17.
 */
public class MergeSortedArray {

    public static void main(String[] argv){
        int[] a={1,2,3};
        int[] b={4,5,6};
        int[] c={2,4,6};
        mergeSortedArray(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        mergeSortedArray(a,c);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(c));
    }

    public static void mergeSortedArray(int[] a,int[]b){
        if(a==null||b==null||a.length==0||b.length==0){
            return;
        }
        int a_index=a.length-1;
        int b_index=0;
        while(a_index>=0&&b_index<b.length){
            if(a[a_index]>b[b_index]){
                swap(a,b,a_index,b_index);
            }else{
                break;
            }
            a_index--;
            b_index++;
        }
        return;
    }
    private static void swap(int[] a,int[] b, int a_index, int b_index){
        int temp=a[a_index];
        a[a_index]=b[b_index];
        b[b_index]=temp;
    }
}
