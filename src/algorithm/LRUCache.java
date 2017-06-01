package algorithm;

import dataStructures.LinkedList.DoublyListNode;

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

    private int capacity;
    private int count;
    private CacheNode head;
    private CacheNode tail;
    private Map<Integer,CacheNode> map;

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

    public void remove(CacheNode node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }
        if(node.next!=null){
            node.next.prev=node.prev;
        }
    }

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

    public int get(int key){
        if(map.containsKey(key)){
            CacheNode node=map.get(key);
            moveToHead(node);

            return node.val;
        }else{
            return -1;
        }
    }

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
