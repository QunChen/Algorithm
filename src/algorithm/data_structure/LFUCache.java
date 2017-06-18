package algorithm.data_structure;

import java.util.*;

/**
 * Created by qun.chen on 4/6/17.
 */
public class LFUCache {

    /**
     ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
     [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
     * @param argv
     */
    public static void main(String[] argv){
        LFUCache lfuCache=new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    private TreeSet<Node> set;
    private int capacity;
    private Map<Integer,Node> nodeMap;
    private int time;

    /**
     * key, value, update time, total count
     */
    public static class Node{
        private int key;
        private int value;
        private int time;
        private int count;

        public Node(int key,int value,int time,int count){
            this.key=key;
            this.value=value;
            this.time=time;
            this.count=count;
        }
    }

    /**
     * initial capacity, create a tree set by first count, then time in reverse order
     * @param capacity
     */
    public LFUCache(int capacity) {
        time++;
        set=new TreeSet<>((i1, i2)->{
            if(i1.count==i2.count){
                return i1.time-i2.time;
            }
            return i1.count-i2.count;
        });
        this.capacity=capacity;
        nodeMap=new HashMap<>();
    }

    /**
     * get a key,
     * increase the timeline
     * if the map contains the key, increase count, update the time, re-add it into set for sorting
     * O(1)
     * @param key
     * @return
     */
    public int get(int key) {
        time++;
        if(nodeMap.containsKey(key)){
            Node node=nodeMap.get(key);
            node.count++;
            node.time=time;
            set.remove(node);
            set.add(node);
            return node.value;
        }else{
            return -1;
        }

    }

    /**
     * increase the time
     * if exist, update time and value then re-add into set
     * if not exist, if reach capacity, get the first in set, which is most rare and old,
     *              remove it from node map,
     *  then add the new node into put and set
     *  O(1)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        time++;
        if(capacity<=0){
            return;
        }
        if(!nodeMap.containsKey(key)){
            if(nodeMap.size()+1>capacity){
                int removeKey=set.first().key;
                set.remove(nodeMap.get(removeKey));
                nodeMap.remove(removeKey);
            }
            Node node=new Node(key,value,time,1);
            set.add(node);
            nodeMap.put(key,node);
        }else{
            Node node=nodeMap.get(key);
            set.remove(node);
            node.value=value;
            node.time=time;
            set.add(node);
            nodeMap.put(key,node);
        }
    }
}
