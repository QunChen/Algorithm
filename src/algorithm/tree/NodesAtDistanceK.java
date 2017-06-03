package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 24/5/17.
 */
public class NodesAtDistanceK {

    public static void main(String[] argv){
        TreeNode<Integer> root = new TreeNode<>(20);
        root.left = new TreeNode<>(8);
        root.right = new TreeNode<>(22);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(12);
        root.left.right.left = new TreeNode<>(10);
        root.left.right.right = new TreeNode<>(14);
        TreeNode<Integer> target = root.left.right;

        NodesAtDistanceK nodesAtDistanceK=new NodesAtDistanceK();

        nodesAtDistanceK.findKDistanceNode(root, target, 3);
    }

    /**
     * the node is the parent, find the node at distance
     * in order
     * @param root
     * @param k
     */
    public void findDownNode(TreeNode<Integer> root, int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.println(root.val);
        }
        findDownNode(root.left,k-1);
        findDownNode(root.right,k-1);
    }

    /**
     * recursively find the target node in the left and right children
     * if is null return -1, if find return 0 and use it as root to find any children have the distance
     * after look in the whole left and right children, if return 0, means it is in that subtree
     * find it's parent, if distance is equal to k, return that
     * otherwise, it should be in the top parent's other side, the start from the other side and using left distance
     *
     * index is very tricky
     * O(n)
     *
     * @param root
     * @param node
     * @param k
     * @return
     */
    public int findKDistanceNode(TreeNode<Integer> root,TreeNode<Integer> node, int k){
        if(root==null){
            return -1;
        }

        if(root==node){
            findDownNode(node,k);
            return 0;
        }

        int dl=findKDistanceNode(root.left,node,k);
        int dr=findKDistanceNode(root.right,node,k);

        if(dl!=-1){
            if((dl+1)==k){
                System.out.println(root.val);
            }else{
                findDownNode(root.right,k-dl-2);
            }
            return dl+1;
        }

        if(dr!=-1){
            if((dr+1)==k){
                System.out.println(root.val);
            }else{
                findDownNode(root.left,k-dr-2);
            }

            return dr+1;
        }

        return -1;
    }

}
