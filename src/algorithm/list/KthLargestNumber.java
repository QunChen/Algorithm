package algorithm.list;

import static algorithm.list.IntervalArray.swap;

/**
 * Created by qun.chen on 14/5/17.
 * O(lgn)
 */
public class KthLargestNumber {

    public static void main(String[] argv){
        int[] a={7,5,2,4,1,3,6,0};
        int k=1;
        int num=quickSelection(a,0,a.length-1,a.length-k+1 );
        System.out.print(num);
        return;
    }

    /**
     * get a pivotal which separate the list , if the index+1 =k, that means index number
     * of element is smaller than k.
     * if it is smaller than k, so it will be in the right,
     * if it is larger than k, so it will be in the left
     * @param a
     * @param start
     * @param end
     * @param k
     * @return
     */
    public static int quickSelection(int[] a,int start, int end, int k){

            int index=getPivotal(a,start,end);
            if(index+1==k){
                return a[index];
            }
            if(index+1>k){
                return quickSelection(a,start,index-1,k);
            }else{
                return quickSelection(a,index+1,end,k);
            }
    }

    /**
     * 1. choose the first as pivotal
     * 2. head start for first, tail from last+1
     * 3. do while if head larger than pivotal and tail smaller than pivotal
     * 4. swap
     * 5. when head over tail, swap the first one with tail
     * 6. return tail index
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int getPivotal(int[] a, int start, int end){
        int pivotal=a[start];
        if(start==end){
            return start;
        }
        int i=start;
        int j=end+1;
        while(true){
            do{
                i++;
            }
            while(a[i]<pivotal&&i<a.length-1);

            do{
                j--;
            }
            while(a[j]>pivotal&&j>0);
            if(i>=j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,start,j);
        return j;
    }
}
