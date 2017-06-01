package algorithm;

import dataStructures.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qun.chen on 22/5/17.
 */
public class PathWithSumK {
    private int currentSum;
    private Stack<TreeNode<Integer>> currentPath;

    public static void main(String[] argv) {
        TreeNode<Integer> n1 = new TreeNode<>(1);
        n1.left = new TreeNode<>(2);
        n1.left.left = new TreeNode<>(3);
        n1.left.left.left=new TreeNode<>(2);
        n1.left.right = new TreeNode<>(3);
        n1.right = new TreeNode<>(4);
        n1.right.left=new TreeNode<>(1);
        n1.right.left.right = new TreeNode<>(2);
        n1.right.right=new TreeNode<>(1);

        PathWithSumK pathWithSumK = new PathWithSumK();
        System.out.println(pathWithSumK.findPath(n1, 8));
    }

    public PathWithSumK() {
        currentPath = new Stack<>();
        currentSum = 0;
    }

    public List<Stack<TreeNode<Integer>>> findPath(TreeNode<Integer> root, int sum) {

        if(root==null){
            return null;
        }

        List<Stack<TreeNode<Integer>>> paths = new LinkedList<>();

        findPathRecurssion(root, sum, paths);

        return paths;
    }

    public void findPathRecurssion(TreeNode<Integer> node, int sum,
                                   List<Stack<TreeNode<Integer>>> paths) {
        if (node == null) {
            return;
        }

        currentSum += node.val;
        currentPath.add(node);
        if (sum == currentSum) {
            Stack<TreeNode<Integer>> newPath = (Stack<TreeNode<Integer>>) currentPath.clone();
            paths.add(newPath);
            currentSum -= node.val;
            currentPath.pop();
            return;
        }
        if (sum < currentSum) {
            currentSum -= node.val;
            currentPath.pop();
            return;
        }

        findPathRecurssion(node.left, sum, paths);
        findPathRecurssion(node.right, sum, paths);
        currentSum -= node.val;
        currentPath.pop();
        return;


    }
}
