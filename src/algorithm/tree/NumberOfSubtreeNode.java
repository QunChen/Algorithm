package algorithm.tree;

import java.util.*;

/**
 * Created by qun.chen on 18/5/17.
 */
public class NumberOfSubtreeNode {

    public static void main(String[] argv){
        String[][] strings={{"x","y"},{"y","z"},{"z","a"},{"y","b"}};
        Map<String,Integer> result=initial(strings);
        System.out.print(result);
    }


    public static class Node{
        public String name;
        public List<Node> children;
        public Node parent;

        public Node(String name){
            this.name=name;
            parent=null;
            children=new ArrayList<>();
        }
    }

    /**
     * loop through all pairs, use a map to store number of children
     */
    public static Map<String,Integer> initial(String[][] pairs){
        Map<String,Integer> result=new HashMap<>();

        if(pairs==null){
            return null;
        }
        Node root=new Node(pairs[0][0]);

        Node second=new Node(pairs[0][1]);

        root.children.add(second);
        second.parent=root;
        result.put(root.name,1);
        result.put(second.name,0);

        for(int i=1;i<pairs.length;i++){
            addNote(pairs[i],root,result);
        }

        return result;
    }

    /**
     * BFS from root
     * add a new pair first find the occurrence of first part, and then add the second part to its child and
     * construct child - parent and parent - child relationship
     * then from the child, add 1 for all its parents up to the top
     * O(n)
     * @param pair
     * @param root
     * @param result
     */
    public static void addNote(String[] pair,Node root,Map<String,Integer> result){
        String boss=pair[0];
        String employee=pair[1];

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node=queue.poll();
            for(Node child:node.children){
                if(child.name.equals(boss)){
                    Node newNode=new Node(employee);
                    result.put(employee,0);
                    newNode.parent=child;
                    child.children.add(newNode);
                    Node parent=child;
                    while(parent!=null){
                        result.put(parent.name,result.get(parent.name)+1);
                        parent=parent.parent;
                    }
                    return;
                }
                queue.add(child);
            }
        }
    }
}
