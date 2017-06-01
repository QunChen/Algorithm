package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qun.chen on 4/5/17.
 */
public class MergeSort {
    public static void main(String[] argv) {
        Integer[] array = {10, 1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
        List<Integer> list = Arrays.asList(array);
        mergeSort(list);
        System.out.print(list);
    }

    public static void mergeSort(List<Integer> origin) {

        mergeSort(origin, 0, origin.size()-1);
    }

    public static void mergeSort(List<Integer> origin, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(origin, low, mid);
            mergeSort(origin, mid + 1, high);
            merge(origin, low, mid, high);
        }
    }

    public static void merge(List<Integer> origin, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int leftStart=low;
        int leftEnd=mid;
        int rightStart = leftEnd + 1;
        int rightEnd=high;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (origin.get(leftStart) < origin.get(rightStart)) {
                temp.add(origin.get(leftStart));
                leftStart++;
            } else {
                temp.add(origin.get(rightStart));
                rightStart++;
            }
        }

        while (leftStart <= leftEnd) {
            temp.add(origin.get(leftStart));
            leftStart++;
        }


        while (rightStart <= rightEnd) {
            temp.add(origin.get(rightStart));
            rightStart++;
        }


        for (int i = 0; i < temp.size(); i++) {
            origin.set(low + i, temp.get(i));
        }
    }
}
