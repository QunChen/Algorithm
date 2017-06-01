package algorithm.Tree;

import dataStructures.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qun.chen on 24/5/17.
 */
public class ValidateCompleteBinaryTree {

    public static void main(String[] argv) {
        TreeNode<Integer> n1 = new TreeNode<>(20);
        n1.left = new TreeNode<>(8);
        n1.right = new TreeNode<>(22);
        n1.left.left = new TreeNode<>(4);
        n1.left.right = new TreeNode<>(12);
        n1.right.left = new TreeNode<>(10);
        n1.right.right = new TreeNode<>(14);
//        n1.left.right.left=new TreeNode<>(10);
//        n1.left.right.right=new TreeNode<>(14);

        System.out.print(isValid(n1));
    }


    public static boolean isValid(TreeNode<Integer> root) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        TreeNode<Integer> nullNode = new TreeNode<>(-1);

        while (!queue.isEmpty()) {
            TreeNode<Integer> current = queue.poll();

            if (current == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {


                if (current == nullNode) {
                    if (!(queue.peek() == null || queue.peek() == nullNode)) {
                        return false;
                    }

                    if (current.left != null) {
                        queue.add(current.left);
                    } else {
                        queue.add(nullNode);
                    }

                    if (current.right != null) {
                        queue.add(current.right);
                    } else {
                        queue.add(nullNode);
                    }
                }
            }

        }

        return true;
    }
}
