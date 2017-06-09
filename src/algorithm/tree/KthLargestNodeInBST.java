package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 21/5/17.
 */
public class KthLargestNodeInBST {

    public static void main(String[] argv){
        TreeNode<Integer> n1=new TreeNode<>(20);
        n1.left=new TreeNode<>(8);
        n1.right=new TreeNode<>(22);
        n1.left.left=new TreeNode<>(4);
        n1.left.right=new TreeNode<>(12);
        n1.left.right.left=new TreeNode<>(10);
        n1.left.right.right=new TreeNode<>(14);

        System.out.print(findKthLargest(n1,3));
    }

    private static int c;
    private static TreeNode<Integer> find;

    public static TreeNode<Integer> findKthLargest(TreeNode<Integer> root, int k){
        if(root==null){
            return null;
        }
        findKthLargestRecursion(root,k);
        return find;
    }

    /**
     * in-order traverse and find the kth one because it is BST
     * use a count to find out the sequence
     * O(lgn)
     * @param node
     * @param k
     */
    private static void findKthLargestRecursion(TreeNode<Integer> node,int k){
        if(node==null){
            return;
        }

        findKthLargestRecursion(node.right,k);
            c++;
            if(k==c){
                find = new TreeNode<>(node.val);
                find.left=node.left;
                find.right=node.right;
                return;
            }
        findKthLargestRecursion(node.left,k);
    }
}
