package algorithm;

import dataStructures.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qun.chen on 23/5/17.
 */
public class PathWithSumKPartial {

    Set<List<Integer>> sumPaths;

    public static void main(String[] argv) {
        TreeNode<Integer> root = new TreeNode<>(2);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(8);
        root.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(-2);
        root.right.right.right = new TreeNode<>(2);

        PathWithSumKPartial pathWithSumKPartial = new PathWithSumKPartial();
        pathWithSumKPartial.getAllSumPaths(root, 7);
    }


    public PathWithSumKPartial() {
        sumPaths=new HashSet<>();
    }

    public void getAllSumPaths(TreeNode<Integer> root, int K) {
        getAllPaths(root, new ArrayList<>(),K);
        System.out.print(sumPaths);
    }

    private void getAllPaths(TreeNode<Integer> node, List<TreeNode<Integer>> path, int K) {

        if (node == null) {
            return;
        }

        path.add(node);
        getAllPaths(node.left, path,K);
        getAllPaths(node.right, path,K);
        if(node.left==null&&node.right==null){
            getSumPath(path,K);
        }
        path.remove(path.size()-1);
    }

    private void getSumPath(List<TreeNode<Integer>> path, int K) {

        for (int i = 0; i < path.size() - 1; i++) {
            for (int j = i + 1; j < path.size(); j++) {
                List<Integer> sumList=getSum(path, i, j,K);
                if (!sumList.isEmpty()) {
                    sumPaths.add(sumList);
                }
            }
        }
    }

    private List<Integer> getSum(List<TreeNode<Integer>> path, int start, int end, int K) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += path.get(i).val;
        }
        List<Integer> sumList=new ArrayList<>();
        if(sum==K){
            for (int i = start; i <= end; i++) {
               sumList.add(path.get(i).val);
           }
        }
        return sumList;
    }
}
