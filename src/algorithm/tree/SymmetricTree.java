package algorithm.tree;

/**
 * Created by qun.chen on 8/6/17.
 */
public class SymmetricTree {

    public static void main(String[] argv){
        SymmetricTree symmetricTree=new SymmetricTree();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);
        System.out.print(symmetricTree.isSymmetric(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isSymmetric;

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        isSymmetric=true;
        isSymmetric(left, right);
        return isSymmetric;
    }

    private void isSymmetric(TreeNode left, TreeNode right) {

        if ((left==null&&right!=null)||(left!=null&&right==null)
                ||(left!=null&&right!=null&&left.val != right.val)) {
            isSymmetric=false;
            return;
        }
        if(left==null||right==null){
            return;
        }


        isSymmetric(left.left, right.right);
        isSymmetric(left.right, right.left);
    }
}
