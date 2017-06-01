package ymx;

/**
 * Created by qun.chen on 7/5/17.
 */
public class Q2 {
    public static void main(String[] argv){
//        BST bst=new BST();
//
//        bst.insert(5);
//        bst.insert(6);
//        bst.insert(3);
//        bst.insert(1);
//        bst.insert(2);
//        bst.insert(4);
//
//        TreeNode node=bst.findCommonParent(bst.root,2,4);
//
//        int length=bst.findLength(bst.root,100);

        int[] ints={5,6,3,1,2,4};

        int d=bstDistance(ints,6,2,4);
    }

    public static int bstDistance(int[] values, int n, int node1, int node2)
    {
        BST bst=new BST();
        // WRITE YOUR CODE HERE
        for(int i=0;i<n;i++){
            bst.insert(values[i]);
        }

        Node parent=bst.findCommonParent(bst.root,node1,node2);
        if(parent==null){
            return -1;
        }else{
            int distanceLeft=bst.findLength(parent,Math.min(node1,node2));
            int distanceRight=bst.findLength(parent,Math.max(node1,node2));
            if(distanceLeft==-1||distanceRight==-1){
                return -1;

            }else{
                return distanceLeft+distanceRight;
            }
        }


    }

    public static class Node{
        int value;
        Node left;
        Node right;
    }

    public static class BST{
        public Node root;

        public void insert(int value){
            Node node=new Node();
            node.value=value;
            if(root==null){
                root=node;
            }else{
                Node parent=root;
                Node current=root;
                while(true){

                    if(value<current.value){
                        current=current.left;
                        if(current==null){
                            parent.left = node;
                            break;
                        }
                    }else if(value>current.value){
                        current=current.right;
                        if(current==null){
                            parent.right = node;
                            break;
                        }
                    }
                    parent=current;
                }

            }
        }

        public Node findCommonParent(Node root,int node1, int node2){

            if(root==null){
                return null;
            }

            if(node1<root.value&&node2<root.value){
                return findCommonParent(root.left,node1,node2);
            }else if(node1>root.value&&node2>root.value){
                return findCommonParent(root.right,node1,node2);
            }else{
                return root;
            }
        }

        public int findLength(Node node,int value){
            int length=-1;
            boolean isFind=false;
            while(node!=null){
                if(value==node.value){
                    length+=1;
                    isFind=true;
                    break;
                }else if(value<node.value){
                    node=node.left;
                    length+=1;
                }else if(value>node.value){
                    node=node.right;
                    length+=1;
                }
            }
            if(!isFind){
                length=-1;
            }
            return length;
        }
    }


}
