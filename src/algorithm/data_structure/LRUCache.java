package algorithm.data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 14/5/17.
 */
public class LRUCache {

    public static void main(String[] argv){
        LRUCache cache=new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        cache.get(3);
        cache.get(2);
        cache.put(4, 3);
        cache.get(2);
        cache.get(3);
        cache.get(4);
    }

    public class CacheNode {

        public CacheNode next;
        public CacheNode prev;
        public int key;
        public int val;
        public CacheNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    /**
     * store the capacity, head and tail for add and remove, and a map from key to node
     *
     */
    private int capacity;
    private int count;
    private CacheNode head;
    private CacheNode tail;
    private Map<Integer,CacheNode> map;

    /**
     * initial head and tail
     * @param capacity
     */
    public LRUCache(int capacity){
        this.capacity=capacity;
        count=0;
        map=new HashMap<>();
        head=new CacheNode(Integer.MIN_VALUE,Integer.MIN_VALUE);
        tail=new CacheNode(Integer.MAX_VALUE,Integer.MAX_VALUE);
        head.prev=null;
        head.next=tail;
        tail.prev=head;
        tail.next=null;
    }

    /**
     * Doubly linked list remove
     * O(1)
     * @param node
     */
    public void remove(CacheNode node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }
        if(node.next!=null){
            node.next.prev=node.prev;
        }
    }

    /**
     * add a node the the head
     * O(1)
     * @param node
     */
    public void addToHead(CacheNode node){
            CacheNode first=head.next;
            first.prev=node;
            node.next=first;
            head.next=node;
            node.prev=head;
    }

    public void moveToHead(CacheNode node){
        remove(node);
        addToHead(node);
    }

    /**
     * after get, more to head
     * O(1)
     * @param key
     * @return
     */
    public int get(int key){
        if(map.containsKey(key)){
            CacheNode node=map.get(key);
            moveToHead(node);

            return node.val;
        }else{
            return -1;
        }
    }

    /**
     * if the key exist, update the value,move to head,
     * otherwise if it is not full, add to map and add to head
     * if it is going to be full, remove the tail because it is least accessed
     * O(1)
     * @param key
     * @param value
     */
    public void put(int key,int value){
        if(map.containsKey(key)){
            map.get(key).val=value;
            moveToHead(map.get(key));
        }else{
            CacheNode node=new CacheNode(key,value);
            if(count<capacity){
                count++;
            }else{
                map.remove(tail.prev.key);
                CacheNode last=tail.prev;
                remove(last);
                tail.prev=last.prev;
            }
            map.put(key,node);
            addToHead(node);
        }
    }
}
