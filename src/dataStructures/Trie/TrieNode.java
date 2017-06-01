package dataStructures.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 19/5/17.
 */
public class TrieNode<T> {

    public Map<T,TrieNode> children;
    public boolean isTerminate;
    public T val;


    public TrieNode(T val){
        children=new HashMap<>();
        isTerminate=false;
        this.val=val;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                ", isTerminate=" + isTerminate +
                ", val=" + val +
                '}';
    }
}
