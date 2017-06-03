package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 28/5/17.
 */
public class LowestCommonAncestor {

    // Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] argv){
         TreeNode n1=new TreeNode(3);
         n1.left=new TreeNode(5);
         n1.right=new TreeNode(1);
         n1.left.left=new TreeNode(6);
         n1.left.right=new TreeNode(2);
         n1.left.right.left=new TreeNode(7);
        n1.left.right.right=new TreeNode(4);
        n1.right.left=new TreeNode(0);
        n1.right.right=new TreeNode(8);

         LowestCommonAncestor lowestCommonAncestor=new LowestCommonAncestor();
         System.out.print(lowestCommonAncestor.lowestCommonAncestor(n1,n1.left.right.right,n1.right).val);
        System.out.print(lowestCommonAncestor.lowestCommonAncestor2(n1,n1.left.right.right,n1.right).val);
    }

    private boolean isFindP;
    private boolean isFindQ;
    private List<TreeNode> pathToP;
    private List<TreeNode> pathToQ;

    public LowestCommonAncestor(){
        isFindP=false;
        isFindQ=false;
        pathToP=new ArrayList<>();
        pathToQ=new ArrayList<>();
    }

    /**
     * recursively to find in left and right subtrees, if find one and could not find another in
     * the other side of subtree, this must be the parent of another node, so
     * return right if another not found in left, return right if another one is not found in left,
     * or find left and right means the you find their parents
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor2(root.left,p,q);
        TreeNode right=lowestCommonAncestor2(root.right,p,q);
        return left == null ? right : right == null ? left : root;
    }


    /**
     * find first different element in the two lists
     * the lowest common ancestor is the last same one
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        lowestCommonAncestorRecurssion(root, p, q);

        int index=0;
        while(index<pathToP.size()&&index<pathToQ.size()){
            if(pathToP.get(index).val!=pathToQ.get(index).val){
                if(index==0){

                }
                break;
            }
            index++;
        }
        if(index-1>=0){
            return pathToP.get(index-1);
        }else{
            return null;
        }

    }

    /**
     * use 2 lists to record and backtrack the path to each node
     * recursively find from left and right children
     * if both find, return
     * @param node
     * @param p
     * @param q
     */
    public void lowestCommonAncestorRecurssion(TreeNode node, TreeNode p,
                                     TreeNode q) {
        if(node==null){
            return;
        }

        if(!isFindP){
            pathToP.add(node);
        }
        if(!isFindQ){
            pathToQ.add(node);
        }

        if(node.val==p.val){
            isFindP=true;
        }
        if(node.val==q.val){
            isFindQ=true;
        }
        lowestCommonAncestorRecurssion(node.left, p, q);
        lowestCommonAncestorRecurssion(node.right, p, q);
        if(isFindP&&isFindQ){
            return;
        }
        if(!isFindP){
            pathToP.remove(node);
        }
        if(!isFindQ){
            pathToQ.remove(node);
        }

    }
}
