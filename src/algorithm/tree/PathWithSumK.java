package algorithm.tree;

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

    /**
     * use the current sum and current path
     */
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

    /**
     * in order
     * backtracking
     * 1. calculate the current sum, add to current path
     * 2. if equal to target, deep copy to result list, revoke step 1 for backtracking
     * 3. if larger than sum, revoke step 1 for backtracking
     * 4. recursively find it in the left subtree and right subtress
     * 5. for a node, if both subtrees' sum are finished, revoke step 1 for backtracking, then return the recursion stack
     * O(n)
     * @param node
     * @param sum
     * @param paths
     */
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
