package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 2/5/17.
 */
public class ClosestNodeInBST {

    public static void main(String[] args){
        BST bst=initBST();
        Node node1=findClosest(bst.root,15,bst.root);
        Node node2=findClosest2(bst.root,15);
        System.out.println(node1);
        System.out.println(node2);
    }

    public static Node findClosest2(Node root,int value){
        List<Node> nodes=new ArrayList<>();
        inOrder(root,nodes);

        Node small=null;
        Node large=null;
        for(Node node:nodes){
            if(node.value<value){
                small=node;
            }else{
                large=node;
                break;
            }
        }
        return Math.abs(small.value-value)>Math.abs(large.value-value)?large:small;
    }

    public static void inOrder(Node node,List<Node> nodes){
        if(node==null){
            return;
        }

        inOrder(node.left,nodes);
        nodes.add(node);
        inOrder(node.right,nodes);
    }

    public static Node findClosest(Node root, int value,Node closestNode){

        if(Math.abs(closestNode.value-value)>Math.abs(root.value-value)){
            closestNode=root;
        }

        if(root.left==null&&root.right==null){
            return closestNode;
        }
        if(root.value==value){
            return root;
        }

        if(value>root.value){
            return findClosest(root.right,value,closestNode);
        }else{
            return findClosest(root.left,value,closestNode);
        }
    }

    public static BST initBST(){
        Node node1=new Node();
        node1.value=1;

        Node node2=new Node();
        node2.value=9;


        Node node3=new Node();
        node3.value=4;
        node3.left=node1;
        node3.right=node2;

        Node node4=new Node();
        node4.value=13;

        Node node5=new Node();
        node5.value=20;

        Node node6=new Node();
        node6.value=15;
        node6.left=node4;
        node6.right=node5;

        Node node7=new Node();
        node7.value=10;
        node7.left=node3;
        node7.right=node6;

        BST bst=new BST();
        bst.root=node7;

        return bst;

    }


    public static  class BST{
        public Node root;
    }

    public static  class Node{
        public int value;
        public Node left;
        public Node right;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + value +
                    '}';
        }
    }

}
