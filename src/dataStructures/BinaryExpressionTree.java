package dataStructures;

import dataStructures.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Created by qun.chen on 19/5/17.
 */
public class BinaryExpressionTree {

    public static void main(String[] argv){
        TreeNode<String> n1=new TreeNode<>("+");
        TreeNode<String> n2=new TreeNode<>("*");
        TreeNode<String> n3=new TreeNode<>("5");
        TreeNode<String> n4=new TreeNode<>("4");
        TreeNode<String> n5=new TreeNode<>("-");
        TreeNode<String> n6=new TreeNode<>("100");
        TreeNode<String> n7=new TreeNode<>("20");

        n1.left=n2;
        n1.right=n5;
        n2.left=n3;
        n2.right=n4;
        n5.left=n6;
        n5.right=n7;

        System.out.println(postfix2(n1));
    }

    public static int postfix2(TreeNode<String> node){
        if(node==null){
            return -1;
        }
        if(node.left!=null&&node.right!=null){
            int left=postfix2(node.left);
            int right=postfix2(node.right);
            if(node.val.equals("+")){
                return left+right;
            }
            if(node.val.equals("*")){
                return left*right;
            }

            if(node.val.equals("-")){
                return left-right;
            }

            if(node.val.equals("/")){
                return left/right;
            }
            return -1;

        }else{
            return Integer.parseInt(node.val);
        }
    }

}
