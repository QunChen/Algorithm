package algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qun.chen on 4/5/17.
 */
public class QuickSort {
    public static void main(String[] argv) {
        Integer[] array = {4,5,6,7,1,2,3};
        List<Integer> list = Arrays.asList(array);
        quickSort(list);
        System.out.print(list);
    }

    public static void quickSort(List<Integer> origin){
        quickSort(origin,0,origin.size()-1);
    }

    /**
     * 1.find pivotal in each split list
     * 2. sort smaller part and larger part recursively
     * 3. after all finished, all swap finished.
     * O(nlgn)
     * @param origin
     * @param left
     * @param right
     */
    public static void quickSort(List<Integer> origin,int left,int right){
        if(left<right){
            int pivotalIndex = getPivotalIndex(origin,left,right);
            quickSort(origin,left,pivotalIndex);
            quickSort(origin,pivotalIndex+1,right);
        }
    }

    /**
     * 1. use the first as pivotal
     * 2. make head = first -1 and tail = last + 1
     * 3. do while and stop when head is larger than pivotal and tail is less than
     * pivotal
     * 4. swap 2 elements
     * 5. when head equal or over tail, return tail at the last element less than pivotal
     * @param origin
     * @param left
     * @param right
     * @return
     */
    public static int getPivotalIndex(List<Integer> origin, int left, int right){
        int pivotalValue=origin.get(left);

        int i=left-1;
        int j=right+1;

        while(true){
            do{
                i++;
            }
            while(origin.get(i)<pivotalValue);

            do{
                j--;
            }
            while(origin.get(j)>pivotalValue);

            if(i>=j){
                return j;
            }
            swap(origin,i,j);
        }
    }


    public static void swap(List<Integer> list,int index1, int index2){
        int temp=list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
    }
}
