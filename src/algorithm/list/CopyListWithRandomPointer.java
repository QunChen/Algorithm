package algorithm.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qun.chen on 21/5/17.
 */



public class CopyListWithRandomPointer {

     // Definition for singly-linked list with a random pointer.
    class RandomListNode {
     int label;
      RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
  };

    public RandomListNode copyRandomList(RandomListNode head) {

        Set<Integer> set=new HashSet<Integer>();
        set.iterator();

        if(head==null){
            return null;
        }

        RandomListNode start=head;

        Map<RandomListNode,RandomListNode> map=new HashMap<>();

        while(start!=null){
            map.put(start,new RandomListNode(start.label));
            start=start.next;
        }

        start=head;

        while(start!=null){
            map.get(start).next=map.get(start.next);
            map.get(start).random=map.get(start.random);
            start=start.next;
        }

        return map.get(head);
    }
}
