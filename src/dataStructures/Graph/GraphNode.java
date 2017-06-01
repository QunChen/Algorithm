package dataStructures.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qun.chen on 18/5/17.
 */
public class GraphNode {
    private int val;
    public List<GraphNode> children;

    public GraphNode(int val){
        this.val=val;
        children=new LinkedList<>();
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "val=" + val +
                '}';
    }
}
