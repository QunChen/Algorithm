package dataStructures;

/**
 * Created by qun.chen on 24/4/17.
 */
import javafx.collections.transformation.SortedList;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class HeapsFindtheRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        Heap heap = new Heap();
        for (int a_i = 0; a_i < n; a_i++) {
            heap.add(in.nextInt());
            System.out.println(heap.getMedian());
        }
    }

     public static  class Heap{
            private List<Integer> lists;

            Heap() {
                lists = new ArrayList<>();
            }

            public void add(Integer i){
                lists.add(i);

            }

            public double getMedian(){
                Collections.sort(lists);
                if(lists.size()%2!=0){
                    return lists.get(lists.size()/2);
                }else{
                    return (double)(lists.get(lists.size()/2)+lists.get(lists.size()/2-1))/2;
                }
            }
        }
    }

