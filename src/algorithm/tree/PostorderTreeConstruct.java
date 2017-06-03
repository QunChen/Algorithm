package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created by qun.chen on 17/5/17.
 */
public class PostorderTreeConstruct {

    public static void main(String[] argv) {
        Integer[] ints = {1, 3, 2, 8,10,9,5,4};
        List<Integer> nodes = Arrays.asList(ints);

        PostorderTreeConstruct postorderTreeConstruct = new PostorderTreeConstruct();
        TreeNode<Integer> root=postorderTreeConstruct.construct(nodes);

        System.out.print(root);
    }

    public TreeNode<Integer> construct2(List<Integer> nodes){
        return constructRec(nodes,0,nodes.size()-1);
    }

    /**
     * post order
     * 1. the last element is the parent because it is post order,
     * 2. use the last element to divide the list to left subtree and right subtree
     * 3. if can not find the value in sublist, return null
     * 4. is only one element return it.
     * 5. after all recursion finished, return root;
     * recursion function: func(left list), func(right list)
     * O(n)
     * @param nodes
     * @param start
     * @param end
     * @return
     */
    public TreeNode<Integer> constructRec(List<Integer> nodes,int start,int end){
        if(start==end){
            return new TreeNode<>(nodes.get(start));
        }

        if(start>end){
            return  null;
        }

        int parent=nodes.get(end);
        int i=start;
        for(;i<=end;i++){
            if(nodes.get(i)>parent){
                break;
            }
        }

        TreeNode<Integer> left=constructRec(nodes,start,i-1);
        TreeNode<Integer> right=constructRec(nodes,i,end-1);
        TreeNode<Integer> root=new TreeNode<>(parent);
        root.left=left;
        root.right=right;
        return root;
    }

    /**
     * 1. first find the root at the last element of the List
     * 2. loop the array from end, add to right child if it is larger than current parent
     * 3. if less, need to find the right parent
     * O(n*nlogn)
     * @param nodes
     * @return
     */
    public TreeNode<Integer> construct(List<Integer> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return null;
        } else {

            List<TreeNode<Integer>> treeNodes = new ArrayList<>();
            TreeNode<Integer> parent = null;
            TreeNode<Integer> root = null;

            for (int i = nodes.size() - 1; i >= 0; i--) {
                TreeNode<Integer> node = new TreeNode<>(nodes.get(i));
                if (i == nodes.size() - 1) {
                    root = node;
                }
                treeNodes.add(node);

                if (parent != null) {

                    if (node.val > parent.val) {
                        parent.right = node;
                    } else {
                        findParent(treeNodes, node.val).left = node;
                    }
                }
                parent = node;
            }

            return root;
        }
    }


    /**
     * find the smallest node that is large than the current val, which is its parent
     * O(nlogn)
     */
    public TreeNode findParent(List<TreeNode<Integer>> nodes, int val) {
        Collections.sort(nodes, new Comparator<TreeNode<Integer>>() {
            @Override
            public int compare(TreeNode<Integer> o1, TreeNode<Integer> o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).val > val) {
                return nodes.get(i);
            }
        }

        return null;
    }
}
