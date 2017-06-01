package dataStructures.BinaryTree;

/**
 * Created by qun.chen on 2/5/17.
 */
public class TreeNode<T> {
    public T val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
