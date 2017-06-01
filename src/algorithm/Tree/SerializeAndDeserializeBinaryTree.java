package algorithm.Tree;

import dataStructures.BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by qun.chen on 16/5/17.
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] argv) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.left = n7;

        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        String result = serializeAndDeserializeBinaryTree.serialize(n1);
        System.out.println(result);
        TreeNode root = serializeAndDeserializeBinaryTree.deserialize(result);
        System.out.println(root);
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer result = new StringBuffer();
        preorderSerialize(root, result);

        return result.toString();
    }

    public void preorderSerialize(TreeNode node, StringBuffer txt) {
        if (node == null) {
            txt.append(",*");
            return;
        }
        if (txt.toString().equals("")) {
            txt.append(node.val);
        } else {
            txt.append("," + node.val);
        }

        preorderSerialize(node.left, txt);
        preorderSerialize(node.right, txt);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        Deque<String> list=new LinkedList<>();
        list.addAll(Arrays.asList(nodeValues));
        return preorderDeserialize(list);
    }

    public TreeNode preorderDeserialize(Deque<String> list) {
        String value=list.remove();

        if(value.equals("*")){
            return null;
        }
        TreeNode treeNode=new TreeNode(Integer.parseInt(value));
        treeNode.left=preorderDeserialize(list);
        treeNode.right=preorderDeserialize(list);
        return treeNode;
    }

}
