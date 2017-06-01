package algorithm.Tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 13/5/17.
 */
public class BinaryTreeToDoublyLinkedList {

    public static void main(String[] argv){
        TreeNode treeNode1 =new TreeNode(10);
        TreeNode treeNode2 =new TreeNode(12);
        TreeNode treeNode3 =new TreeNode(15);
        TreeNode treeNode4 =new TreeNode(25);
        TreeNode treeNode5 =new TreeNode(30);
        TreeNode treeNode6 =new TreeNode(36);

        treeNode1.left= treeNode2;
        treeNode1.right= treeNode3;

        treeNode2.left= treeNode4;
        treeNode2.right= treeNode5;

        treeNode3.left= treeNode6;

        TreeNode treeNode =treeToList(treeNode1);
        System.out.print(treeNode);
    }

    public static TreeNode treeToList(TreeNode treeNode){
        if(treeNode ==null){
            return treeNode;
        }

        treeNode =convert(treeNode);

        while(treeNode.left!=null){
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    public static TreeNode convert(TreeNode treeNode){
        if(treeNode ==null){
            return treeNode;
        }
        if(treeNode.left!=null){
            TreeNode left=convert(treeNode.left);
            while(left.right!=null){
                left=left.right;
            }
            left.right= treeNode;
            treeNode.left=left;
        }
        if(treeNode.right!=null){
            TreeNode right=convert(treeNode.right);
            while(right.left!=null){
                right=right.left;
            }
            right.left= treeNode;
            treeNode.right=right;
        }
        return treeNode;
    }
}
