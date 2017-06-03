package algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by qun.chen on 13/5/17.
 */
public class LimitedKeyObjectSort {

    public static void main(String[] argv){
        Item item1=new Item(3);
        Item item2=new Item(3);
        Item item3=new Item(3);
        Item item4=new Item(1);
        Item item5=new Item(2);
        Item item6=new Item(2);
        Item item7=new Item(3);
        Item[] a={item1,item2,item3,item4,item5,item6,item7};
        //Item[] sorted=prioritySort(a);
        //Item[] sorted=bucketSort(a);
        swapSort(a);
        System.out.print(Arrays.toString(a));
    }

    public static class Item implements Comparable<Item>{
        public Item(int i){
            key=i;
        }

        private int key;


        @Override
        public int compareTo(Item o) {
            return o.key-this.key;
        }
    }

    /**
     * use a priority queue, which is a heap to sort
     * pull all in and poll base on the comparator algorithm
     * O(nlgn)
     * @param a
     * @return
     */
    public static Item[] prioritySort(Item[] a){
        Queue<Item> queue=new PriorityQueue<>();
        queue.addAll(Arrays.asList(a));

        Item[] result=new Item[a.length];
        int i=a.length-1;
        while(!queue.isEmpty()){
            result[i]=queue.poll();
            i--;
        }
        return result;
    }

    /**
     * put items into bucket base on the value, need to know all values or value range
     * If the data is too dense, too many items fall into the same bucket, only slightly better than other sorting
     * O(n)
     * @param a
     * @return
     */
    public static Item[] bucketSort(Item[] a){
        Item[][] items=new Item[3][a.length];
        int x=0,y=0,z=0;
        for(Item i:a){
            if(i.key==1){
                items[0][x]=i;
                x++;
            }
            if(i.key==2){
                items[1][y]=i;
                y++;
            }
            if(i.key==3){
                items[2][z]=i;
                z++;
            }
        }

        Item[] result=new Item[a.length];
        System.arraycopy(items[0],0,result,0,x);
        System.arraycopy(items[1],0,result,x,y);
        System.arraycopy(items[2],0,result,x+y,z);
        return result;
    }

    /**
     * set 2 pointers, one from head, one from tail, swap if head is larger than tail
     * stop when head over tail
     * NOT WORKING FOR ALL CASES
     * @param a
     */
    public static void swapSort(Item[] a){
        int i=0;
        int j=a.length-1;
        while(i<j){
            while(a[i].key==1){
                i++;
            }
            while(a[j].key!=1){
                j--;
            }
            swap(a,i,j);
            i++;j--;
        }
        int k=i;
        int l=a.length-1;
        while(k<l){
            while(a[k].key==2){
                k++;
            }
            while(a[l].key!=2){
                l--;
            }
            swap(a,k,l);
            k++;l--;
        }
    }

    public static void swap(Item[]a, int i, int j){
        Item temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
