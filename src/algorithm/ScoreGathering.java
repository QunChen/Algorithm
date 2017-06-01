package algorithm;

import dataStructures.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by qun.chen on 24/5/17.
 */
public class ScoreGathering {


    public static void main(String[] argv){
        int[] data={4, 2, 5, 5, 6, 1, 4};
        System.out.print(gather(data));
    }

    public static String gather(int[] input){
        Map<Integer,Integer> map=new HashMap<>();
        TreeNode<Integer> root=null;
        for(int i:input){
            if(root==null){
                TreeNode<Integer> node=new TreeNode<>(i);
                root=node;
                map.put(i,1);
            }else{
                if(map.containsKey(i)){
                    int val=map.get(i);
                    map.put(i,val+1);
                }else{
                    addNote(root,i);
                    map.put(i,1);
                }
            }
        }

        return print(root,map);
    }

    private static String print(TreeNode<Integer> root,Map<Integer,Integer> map){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        StringBuilder sb=new StringBuilder();
        TreeNode<Integer> nullNode=new TreeNode<>(Integer.MIN_VALUE);
        while(!queue.isEmpty()){
            TreeNode<Integer> current=queue.poll();
            if(current==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            } else if(current==nullNode){
                    sb.append(",");
            }else{
                sb.append(current.val+":"+map.get(current.val)+",");

                if(current.left==null){
                    queue.add(nullNode);
                }else{
                    queue.add(current.left);
                }
                if(current.right==null){
                    queue.add(nullNode);
                }else {
                    queue.add(current.right);
                }

            }
        }

        String result=sb.toString();
        int index=0;
        char[] chars=result.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i]==','){
                index=i;
            }else{
                break;
            }
        }

        return sb.substring(0,index);
    }

    private static boolean isAllNull(Queue<TreeNode<Integer>> queue){
        Queue<TreeNode<Integer>> now= new LinkedList<>(queue);
        while(!now.isEmpty()){
            TreeNode<Integer> current=now.poll();
            if(current!=null){
                return false;
            }
        }
        return true;
    }

    private static void addNote(TreeNode<Integer> root, int val){
        TreeNode<Integer> current=root;

        TreeNode<Integer> newNode=new TreeNode<>(val);

        while(true){
            if(val>current.val){
                if(current.right==null){
                    current.right=newNode;
                    break;
                }else{
                    current=current.right;
                }
            }else{
                if(current.left==null){
                    current.left=newNode;
                    break;
                }else{
                    current=current.left;
                }
            }
        }
    }
}
