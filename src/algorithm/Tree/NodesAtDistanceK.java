package algorithm.Tree;

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
