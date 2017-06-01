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

    public static void quickSort(List<Integer> origin,int left,int right){
        if(left<right){
            int pivotalIndex = getPivotalIndex(origin,left,right);
            quickSort(origin,left,pivotalIndex);
            quickSort(origin,pivotalIndex+1,right);
        }
    }

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
