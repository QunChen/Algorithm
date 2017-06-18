package algorithm.data_structure;

import java.util.ArrayList;

/**
 * Created by qun.chen on 170615.
 * get(int index), addToFirst(int num), addToLast(int num) - O(1)
 */
public class DequeConstantGet {

    public static void main(String[] argv){
        DequeConstantGet dequeConstantGet=new DequeConstantGet();

        dequeConstantGet.addToFirst(1);
        dequeConstantGet.addToFirst(2);
        dequeConstantGet.addToFirst(3);
        dequeConstantGet.addToLast(4);
        dequeConstantGet.addToLast(5);
        dequeConstantGet.addToLast(6);

        System.out.println(dequeConstantGet.get(0));
        System.out.println(dequeConstantGet.get(1));
        System.out.println(dequeConstantGet.get(2));
        System.out.println(dequeConstantGet.get(3));
        System.out.println(dequeConstantGet.get(4));
        System.out.println(dequeConstantGet.get(5));
        System.out.println(dequeConstantGet.get(6));
    }


    private ArrayList<Integer> first;
    private ArrayList<Integer> last;
    private int size;

    /**
     * one for first, one for last
     */
    public DequeConstantGet() {
        first=new ArrayList<>();
        last=new ArrayList<>();
    }

    /**
     * if smaller than first array, get from tail, the first is at the tail
     * if larger than first array, get from last in the normal sequence
     * O(1)
     * @param index
     * @return
     */
    public int get(int index){
        if(index>=size){
            return -1;
        }
        else if(index<first.size()){
            return first.get(first.size()-1-index);
        }
        else {
            return last.get(index-first.size());
        }
    }

    /**
     * add to first, first in tail
     * O(1)
     * @param num
     */
    public void addToFirst(int num){
        first.add(num);
        size++;
    }

    /**
     * add to last, last in tail
     * O(1)
     * @param num
     */
    public void addToLast(int num){
        last.add(num);
        size++;
    }
}
