package algorithm.graph;

import dataStructures.Graph.GraphNode;

import java.util.*;

/**
 * Created by qun.chen on 18/5/17.
 */
public class BiPartiteDislike {

    public static void main(String[] argv) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n1);
        n4.children.add(n5);
        n5.children.add(n2);
        n6.children.add(n3);

        Set<GraphNode> nodes = new HashSet<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);

        BiPartiteDislike biPartiteDislike = new BiPartiteDislike(nodes);
        int result = biPartiteDislike.findMax();

        System.out.print(result);
    }
    private Set<GraphNode> all;
    public BiPartiteDislike(Set<GraphNode> all) {
        this.all = all;
    }


    /**
     * 1. start form each node and using a full set of node to get the group
     * 2. compare the number of node in each group
     * O(n^3)
     * @return
     */
    public int findMax(){
        Iterator<GraphNode> iterator = all.iterator();
        int max=0;
        Set<GraphNode> tempSet=new HashSet<>(all);
        while(iterator.hasNext()){
            int temp=findLikeFriends(iterator.next(),tempSet);//start from each node to find the max set
            if(temp>max){
               max=temp;
            }
        }
        return max;
    }

    /**
     * find number of nodes
     * 1. not its child
     * 2. not linked to this node
     * 3. add left ones to the queue
     * 4. finally when the queue is empty we find the biggest group
     * O(n^2)
     * @param first
     * @param all
     * @return
     */
    public int findLikeFriends(GraphNode first,Set<GraphNode> all) {
        Iterator<GraphNode> iterator = all.iterator();//current available nodes
        Queue<GraphNode> queue = new LinkedList<>();//queue for BFS
        queue.add(first);
        int result = 0; //result set

        while (!queue.isEmpty()) {//O(n)
            GraphNode node = queue.poll();
            if (all.contains(node)) {//not removed by previous
                result++;
                all.remove(node);
                for (GraphNode child : node.children) { //O(n) - find all children and remove
                    if (all.contains(child)) {
                        all.remove(child);
                    }
                }
                iterator = all.iterator();
                while (iterator.hasNext()) {  //O(n) - check left ones don't have a link to this node
                    GraphNode temp = iterator.next();
                    if (temp.children.contains(node)) {
                        iterator.remove();
                    }
                }
                iterator = all.iterator();
                while (iterator.hasNext()) { //O(n) - add nodes are not link to or from this node
                    GraphNode next = iterator.next();
                    if (!queue.contains(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return result;
    }
}
