package algorithm.tree;


import dataStructures.BinaryTree.TreeNode;

/**
 * Created by qun.chen on 14/5/17.
 */
public class SiblingPointerTree {

    public static void main(String[] argv) {
        TreeNode2 n1 = new TreeNode2(1);
        TreeNode2 n2 = new TreeNode2(2);
        TreeNode2 n3 = new TreeNode2(3);
        TreeNode2 n4 = new TreeNode2(4);
        TreeNode2 n5 = new TreeNode2(5);
        TreeNode2 n6 = new TreeNode2(6);
        TreeNode2 n7 = new TreeNode2(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        link(n1);

        System.out.print(n1);

    }

    public static class TreeNode2 extends TreeNode {
        public TreeNode2 left;
        public TreeNode2 right;
        public TreeNode2 next;

        public TreeNode2(int val){
            super(val);
        }
    }

    /**
     * from root make left point to right, make right to parent's next, should be populated in the previous level run
     * because it is complete, so if the left one has no left, will be no more level and nodes
     * O(n)
     * @param head
     */
    public static void link(TreeNode2 head) {
        if (head==null){
            return;
        }
        TreeNode2 levelStart = head;


        while (true) {
            while (head != null) {
                if (head.left != null) {
                    head.left.next = head.right;
                }
                if (head.right != null) {
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    } else {
                        head.right.next = null;
                    }
                }
                head = head.next;
            }
            if (levelStart.left != null) {
                head = levelStart.left;
                levelStart = head;

            } else {
                break;
            }

        }

        return;

    }
}
