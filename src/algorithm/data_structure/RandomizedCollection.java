package algorithm.data_structure;

import java.util.*;

/**
 * Created by qun.chen on 20/5/17.
 */
public class RandomizedCollection {

    public static void main(String[] argv){

        /*
["RandomizedSet","insert","insert","remove","insert","insert","insert","remove","remove","insert",
"remove","insert","insert","insert","insert","insert","getRandom","insert","remove","insert","insert"]
[[],[3],[-2],[2],[1],[-3],[-2],[-2],[3],[-1],[-3],[1],[-2],[-2],[-2],[1],[],[-2],[0],[-3],[1]]
         */
        RandomizedCollection randomizedCollection=new RandomizedCollection();
        System.out.println(randomizedCollection.insert(3));
        System.out.println(randomizedCollection.insert(-2));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(-3));
        System.out.println(randomizedCollection.insert(-2));
        System.out.println(randomizedCollection.remove(-2));
        System.out.println(randomizedCollection.remove(3));
        System.out.println(randomizedCollection.insert(-1));
        System.out.println(randomizedCollection.remove(-3));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(-2));
        System.out.println(randomizedCollection.insert(-2));
        System.out.println(randomizedCollection.insert(-2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.insert(-2));
        System.out.println(randomizedCollection.remove(0));
        System.out.println(randomizedCollection.insert(-3));
        System.out.println(randomizedCollection.insert(1));
    }


    private Map<Integer,Integer> map;//val->index in list
    private List<Integer> list;



    /** Initialize your data structure here.
     * use the map to find the random item
     * use linkedlist for normal access
     * */
    public RandomizedCollection() {
        map=new HashMap<>();
        list=new ArrayList<>();


    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     *  1. add the val to list
     *  2. add the val and index to map
     *  O(1)
     *
     * */
    public boolean insert(int val) {
        boolean notFind=!contains(val);
        if(notFind){
            list.add(val);
            map.put(val,list.size()-1);
        }
        return notFind;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.
     * 1. get the last element list
     * 2. get the index for the selected val from map
     * 3. update the index of last in the list using remove index
     * 4. swap the value in the step 1 with step 2
     * 5. remove the the last index in list
     * 6. remove key in the map
     * O(1)
     * */
    public boolean remove(int val) {
        boolean isFind=contains(val);
        if(isFind){
            int lastIndex=list.size()-1;
            int index = map.get(val);
            if(val!=list.get(lastIndex)){
                map.put(list.get(lastIndex),index);
                swap(list,index,lastIndex);
            }
            list.remove(list.size()-1);
            map.remove(val);

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
