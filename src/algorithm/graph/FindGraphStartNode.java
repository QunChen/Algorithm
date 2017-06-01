package algorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qun.chen on 9/5/17.
 */
public class FindGraphStartNode {

    public static class Node{
        String name;
        public boolean isVisited;
        public List<Node> children;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Node(){
            children=new ArrayList<>();
        }
    }

    public static void main(String[] argv){
        Node node1=new Node();
        node1.name="a";


        Node node2=new Node();
        node2.name="b";

        Node node3=new Node();
        node3.name="c";

        Node node4=new Node();
        node4.name="d";

        Node node5=new Node();
        node5.name="e";

        node1.children.add(node2);
        node1.children.add(node5);

        node2.children.add(node3);
        node2.children.add(node4);

        node3.children.add(node5);
        node4.children.add(node5);

        List<Node> nodes=new ArrayList<>();
        nodes.add(node5);
        nodes.add(node4);
        nodes.add(node3);
        nodes.add(node2);
        nodes.add(node1);

        System.out.println(findStart(nodes));
    }


    public static Node findStart(List<Node> nodes){

        Set<Node> affected=new HashSet<>();

        for(Node node:nodes){
            checkParent(node,affected,false);
        }

        for(Node node:nodes){
            if(!affected.contains(node)){
                return node;
            }
        }

        return null;
    }

    public static void checkParent(Node node,Set<Node> affected,boolean from){

        if(from){
            affected.add(node);
        }

        if(node.isVisited){
            return;
        }

        node.isVisited=true;

        for(Node child:node.children){
            checkParent(child,affected,true);
        }

        return;
    }
}
