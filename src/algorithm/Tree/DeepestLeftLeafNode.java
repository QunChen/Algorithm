package algorithm.Tree;

import dataStructures.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qun.chen on 28/5/17.
 */
public class DeepestLeftLeafNode {

    public static void main(String[] argv){
        TreeNode<Integer> root=new TreeNode<>(1);
        root.left=new TreeNode<>(2);
        root.right=new TreeNode<>(3);
        root.left.right=new TreeNode<>(4);
        root.right.right=new TreeNode<>(5);
        System.out.print(findNode(root));
    }

    public static TreeNode<Integer> findNode(TreeNode<Integer> root){
        if(root==null){
            return null;
        }


        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);

        TreeNode<Integer> left=root;
        boolean isNewLevel=false;
        while(!queue.isEmpty()){
            TreeNode<Integer> current=queue.poll();
            if(current==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    isNewLevel=true;
                }
            }else{
                if(isNewLevel){
                    left=current;
                    isNewLevel=false;
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
        }

        return left;
    }
}
