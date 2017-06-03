package algorithm.tree;

import dataStructures.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 1/6/17.
 */
public class NextLesserGreaterNode {
    private TreeNode<Integer> next;
    private TreeNode<Integer> prev;
    private boolean isFind;

    public static void main(String[] argv){
        TreeNode<Integer> root=new TreeNode<>(5);
        root.left=new TreeNode<>(3);
        root.right=new TreeNode<>(7);
        root.left.left=new TreeNode<>(2);
        root.left.right=new TreeNode<>(6);
        root.right.left=new TreeNode<>(4);
        root.right.right=new TreeNode<>(8);

        NextLesserGreaterNode nextLesserGreaterNode=new NextLesserGreaterNode();
        System.out.print(nextLesserGreaterNode.find(root,8));
    }

    public List<TreeNode<Integer>> find(TreeNode<Integer> root, int val){
 //       findRec(root,val);
        findRec(root,val);
        List<TreeNode<Integer>> result=new ArrayList<>();
        result.add(prev);
        result.add(next);
        return result;
    }

    public void findGreater(TreeNode<Integer> root,int val){
        if(root==null||next!=null){
            return;
        }
        if(root.val>val){
            next=root;
            return;
        }
        findGreater(root.left,val);
        findGreater(root.right,val);

    }

    /**
     * pre order
     * if smaller than target val, keep updating lesser
     * if bigger than target val, get the greater and set flag find true.
     * O(n)
     * @param root
     * @param val
     */
    public void findRec(TreeNode<Integer> root,int val){
        if(root==null||isFind){
            return;
        }

        findRec(root.left,val);

        if(root.val<val&&!isFind){
            prev=root;
        }
        if(root.val>val&&!isFind){
            isFind=true;
            next=root;
        }
        findRec(root.right,val);
    }
}
