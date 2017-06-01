package algorithm.sort;

import dataStructures.MinHeap;

/**
 * Created by qun.chen on 19/5/17.
 */
public class HeapSort {

    public static void main(String[] argv){
        Integer[] list={4,5,7,3,2,9,1};
        HeapSort heapSort=new HeapSort();
        Integer[] result=heapSort.sort(list);
        System.out.print(result);
    }

    private MinHeap<Integer> heap;

    public HeapSort(){
        heap=new MinHeap<>();
    }

    private void initialHeap(Integer[] list){
        for(Integer integer:list){
            heap.push(integer);
        }
    }

    public Integer[] sort(Integer[] list){
        Integer[] sortedList=new Integer[list.length];

        initialHeap(list);

        for(int i=0;i<sortedList.length;i++){
            sortedList[i]=heap.poll();
        }

        return sortedList;
    }
}
