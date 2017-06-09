package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 5/5/17.
 */
public class SumNodeToLeaf {

    public static void main(String[] argv) {
        TreeNode<Integer> treeNode1 = new TreeNode<>(1);
        TreeNode<Integer> treeNode2 = new TreeNode<>(4);
        TreeNode<Integer> treeNode3 = new TreeNode<>(3);
        TreeNode<Integer> treeNode4 = new TreeNode<>(9);
        TreeNode<Integer> treeNode5 = new TreeNode<>(5);
        TreeNode<Integer> treeNode6 = new TreeNode<>(6);
        TreeNode<Integer> treeNode7 = new TreeNode<>(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(isFind(treeNode1,14));
        System.out.println(isFind(treeNode1,12));
    }


    /**
     * pre order
     * recursively find whether the value is same
     * recursive function 2 func(subtree,value-subtree node value), Or the
     * result from left and right, means if one side is find, that is satisfied
     * base condition: value is same with current node value
     * O(n)
     * @param treeNode
     * @param value
     * @return
     */
    public static boolean isFind(TreeNode<Integer> treeNode, int value){
        if(treeNode.left==null&& treeNode.right==null){
            return treeNode.val ==value;
        }

        return(
        isFind(treeNode.left,value- (int)treeNode.left.val)||
        isFind(treeNode.right,value- (int)treeNode.right.val));
    }
}
