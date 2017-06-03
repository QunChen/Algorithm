package algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qun.chen on 4/5/17.
 */
public class BubbleSort {

    public static void main(String[] argv){
        Integer[] array = {10,1,3,5,7,9,8,6,4,2,0};
        List<Integer> list= Arrays.asList(array);
        bubbleSort(list);
        System.out.print(list);
    }

    /**
     * from start to end, if larger than the next, swap, the the largest one will
     * be put at the tail
     * O(n^2)
     * @param origin
     */
    public static void bubbleSort(List<Integer> origin){
        boolean isSwapped=true;
        int n=origin.size()-1;
        while(isSwapped){
            isSwapped=false;
            for(int j=0;j<n;j++){
                if(origin.get(j)>origin.get(j+1)){
                    swap(origin,j,j+1);
                    isSwapped=true;

                }
            }
            n--;
        }
    }

    public static void swap(List<Integer> list,int index1, int index2){
        int temp=list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
    }
}
