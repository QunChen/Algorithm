package algorithm.data_structure;

import java.util.*;

/**
 * Created by qun.chen on 20/5/17.
 */
public class RandomizedCollection {

    public static void main(String[] argv){

        RandomizedCollection randomizedCollection=new RandomizedCollection();
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));

        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.remove(2));

        System.out.println(randomizedCollection.insert(1));

        System.out.println(randomizedCollection.remove(2));

        System.out.println(randomizedCollection.getRandom());
    }


    private Map<Integer,Set<Integer>> map;//val->index in list
    private List<Integer> list;



    /** Initialize your data structure here.
     * use the map to find the random item
     * use linkedlist for normal access
     * */
    public RandomizedCollection() {
        map=new HashMap<>();
        list=new LinkedList<>();


    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     *  1. add the val to list
     *  2. add the index to set as the value for that map on the key of this value
     *  O(1)
     *
     * */
    public boolean insert(int val) {
        boolean notFind=!contains(val);
        list.add(val);
        Set<Integer> indexQ=null;
        if(notFind){
            indexQ=new HashSet<>();
        }else{
            indexQ=map.get(val);
        }
        indexQ.add(list.size()-1);
        map.put(val,indexQ);
        return notFind;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.
     * 1. get the last element list
     * 2. get the first index for the selected list
     * 3. use the index from step 2 to populate list contains last element in the list
     * 4. swap the value in the step 1 with step 2
     * 5. remove the index found in step 2
     * 6. remove key if index value is empty
     * O(1)
     * */
    public boolean remove(int val) {
        boolean isFind=contains(val);
        if(isFind){
            int lastIndex=list.size()-1;
            Iterator<Integer> it = map.get(val).iterator();
            int index=it.next();
            if(val!=list.get(lastIndex)){
                map.get(list.get(lastIndex)).remove(lastIndex);
                map.get(list.get(lastIndex)).add(index);
                swap(list,index,list.size()-1);
            }
            list.remove(list.size()-1);
            if(map.get(val).isEmpty()){
                map.remove(val);
            }else{
                it.remove();
            }
        }
        return isFind;
    }

    /** Get a random element from the collection.
     * O(1)
     * */
    public int getRandom() {
        Random random=new Random();
        return list.get(random.nextInt(list.size()));
    }

    private void swap(List<Integer> list,int index1,int index2){
        Integer temp=list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
    }


    private boolean contains(int val){
        if(map.containsKey(val)){
            return true;
        }else{
            return false;
        }
    }
}
