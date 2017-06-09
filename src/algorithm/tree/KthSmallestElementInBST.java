package algorithm.tree;

/**
 * Created by qun.chen on 8/6/17.
 */
public class KthSmallestElementInBST {
     public static class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public static void main(String[] argv){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(8);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(23);

        KthSmallestElementInBST kthSmallestElementInBST=new KthSmallestElementInBST();

        System.out.print(kthSmallestElementInBST.kthSmallest(root,6));
    }

    public int kthSmallest(TreeNode root, int k) {
         if(root==null){
             return -1;
         }

        kthSmallestRec(root,k);
        return result;
    }

    private int i;
    private int result;



    public void kthSmallestRec(TreeNode root, int k){
         if(root==null){
             return;
         }
        kthSmallestRec(root.left,k);
         i++;
         if(i==k){
             result=root.val;
             return;
         }
        kthSmallestRec(root.right,k);
    }
}
