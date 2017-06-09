package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qun.chen on 8/6/17.
 */
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] argv){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal=new BinaryTreeLevelOrderTraversal();
        System.out.print(binaryTreeLevelOrderTraversal.levelOrderTop(root));
        System.out.print(binaryTreeLevelOrderTraversal.levelOrderBottom(root));
    }


    public List<List<Integer>> levelOrderTop(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        while (!queue.isEmpty()) {

            if (size == 0) {
                size = queue.size();
                result.add(new ArrayList<>(current));
                current.clear();
            } else {
                TreeNode item = queue.poll();
                current.add(item.val);
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
                size--;
            }

        }
        result.add(new ArrayList<>(current));
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        while (!queue.isEmpty()) {

            if (size == 0) {
                size = queue.size();
                result.add(0,new ArrayList<>(current));
                current.clear();
            } else {
                TreeNode item = queue.poll();
                current.add(item.val);
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
                size--;
            }

        }
        result.add(0,new ArrayList<>(current));
        return result;
    }
}
