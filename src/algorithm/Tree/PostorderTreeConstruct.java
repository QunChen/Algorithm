package algorithm.Tree;

import dataStructures.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created by qun.chen on 17/5/17.
 */
public class PostorderTreeConstruct {

    public static void main(String[] argv) {
        Integer[] ints = {1, 3, 2, 5, 10,9, 8, 4};
        List<Integer> nodes = Arrays.asList(ints);

        PostorderTreeConstruct postorderTreeConstruct = new PostorderTreeConstruct();
        TreeNode<Integer> root=postorderTreeConstruct.construct(nodes);

        System.out.print(root);
    }

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


    //find the smallest node that is large than the current val, which is its parent
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
