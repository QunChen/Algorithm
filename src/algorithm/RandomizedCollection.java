package algorithm;

import java.util.*;

/**
 * Created by qun.chen on 20/5/17.
 */
public class RandomizedCollection {

    public static void main(String[] argv){

        RandomizedCollection randomizedCollection=new RandomizedCollection();
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(2));
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



    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map=new HashMap<>();
        list=new LinkedList<>();


    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
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

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
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
            }
        }
        return isFind;
    }

    /** Get a random element from the collection. */
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
