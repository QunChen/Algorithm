package algorithm.list;

import static algorithm.list.IntervalArray.swap;

/**
 * Created by qun.chen on 14/5/17.
 */
public class KthLargestNumber {

    public static void main(String[] argv){
        int[] a={7,5,2,4,1,3,6,0};
        int k=8;
        int num=quickSelection(a,0,a.length-1,a.length-k+1 );
        System.out.print(num);
        return;
    }

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
