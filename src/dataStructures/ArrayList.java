package dataStructures;

import java.util.Arrays;

/**
 * Created by qun.chen on 11/6/17.
 */
public class ArrayList {

    public static void main(String[] argv){
        ArrayList arrayList=new ArrayList(2);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0,4);
        arrayList.remove(1);
        arrayList.clear();
    }

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int[] elementData;

    public ArrayList() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayList(int initialCapacity) {
        elementData = new int[initialCapacity];
        size = 0;
    }

    public boolean add(int e) {
        if (size == elementData.length-1) {
            grow((size+1)*2);
        }
        elementData[size] = e;
        size++;
        return true;
    }

    public void add(int index, int element) {
        if(index<elementData.length){
            if(size==elementData.length-1){
                grow((size+1)*2);
            }
            System.arraycopy(elementData,index,elementData,index+1,size-index);
            elementData[index]=element;
            size++;
        }
    }

    public int remove(int index) {
        if(index<elementData.length){
            int old=elementData[index];
            System.arraycopy(elementData,index+1,elementData,index,size-index-1);
            elementData[size-1]=0;
            size--;
            return old;
        }else{
            return -1;
        }
    }

    public void clear() {
        elementData=new int[DEFAULT_CAPACITY];
        size=0;
    }

    private void grow(int minCapacity) {
        elementData=Arrays.copyOf(elementData,minCapacity);
    }
}
