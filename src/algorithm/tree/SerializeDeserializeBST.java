package algorithm.tree;

import dataStructures.BinaryTree.leetcode.TreeNode;

/**
 * Created by qun.chen on 10/6/17.
 */
public class SerializeDeserializeBST {

    public static void main(String[] argv){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(1);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(10);
        root.right.right.left=new TreeNode(9);

        SerializeDeserializeBST serializeDeserializeBST=new SerializeDeserializeBST();
        String text=serializeDeserializeBST.serialize(root);
        System.out.println(text);
        System.out.println(serializeDeserializeBST.deserialize(text));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "*,";
        }
        return ""+root.val+","+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.substring(0,data.length()-1).split(",");
        return deserializeNote(nodes,0,nodes.length);
    }

    public TreeNode deserializeNote(String[] nodes, int start, int end){
        if(start>=end||nodes[start].equals("*")){
            return null;
        }
        int val=Integer.parseInt(nodes[start]);
        TreeNode node=new TreeNode(val);
        int i=1;
        for(;i<nodes.length;i++){
            if(!nodes[i].equals("*")&&Integer.parseInt(nodes[i])>val){
                break;
            }
        }
        node.left=deserializeNote(nodes,start+1,i-1);
        node.right=deserializeNote(nodes,start+i,end);
        return node;
    }
}
