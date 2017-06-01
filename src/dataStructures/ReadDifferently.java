package dataStructures;

import dataStructures.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created by qun.chen on 5/5/17.
 */
public class ReadDifferently {

    public static void main(String[] argv) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        List<TreeNode> results = read(treeNode1);
        System.out.print(results);
    }


    public static List<TreeNode> read(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        if (root == null) {
            return treeNodes;
        } else {
            treeNodes.add(root);
            treeNodeQueue.add(root);
        }

        boolean isLeft = true;
        while (!(treeNodeQueue.isEmpty() && treeNodeStack.isEmpty())) {
            if (isLeft) {

                while (!treeNodeQueue.isEmpty()) {
                    TreeNode treeNode = treeNodeQueue.poll();
                    if (treeNode.left != null) {
                        treeNodeStack.add(treeNode.left);
                        treeNodes.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodeStack.add(treeNode.right);
                        treeNodes.add(treeNode.right);
                    }
                }

                isLeft = false;
            } else {
                while (!treeNodeStack.isEmpty()) {
                    TreeNode treeNode = treeNodeStack.pop();
                    if (treeNode.right != null) {
                        treeNodeQueue.add(treeNode.right);
                        treeNodes.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        treeNodeQueue.add(treeNode.left);
                        treeNodes.add(treeNode.left);
                    }
                }
                isLeft = true;
            }
        }
        return treeNodes;
    }
}
