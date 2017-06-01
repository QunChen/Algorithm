package dataStructures;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 2/5/17.
 */
public class DistanceOfNodesInBST {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(9);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(7);
        binarySearchTree.insert(13);
        binarySearchTree.insert(17);
        binarySearchTree.insert(11);
        binarySearchTree.insert(14);
        binarySearchTree.insert(19);

        TreeNode common=binarySearchTree.findCommonParent(5,8);
        int distance1 = binarySearchTree.getDistance(common,5);
        int distance2 = binarySearchTree.getDistance(common,8);
        int distance=distance1+distance2;
        System.out.print(distance);
    }
}
