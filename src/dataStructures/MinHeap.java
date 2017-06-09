package dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 19/5/17.
 */
public class MinHeap<T extends Comparable<T> > {
    private List<T> data;
    public MinHeap(){
        data=new ArrayList<>();
    }
    public void push(T val){
        data.add(val);
        heaplifyUp(data.size()-1);
    }

    /**
     * remove the first element
     * swap the last to first
     * heaplify down
     * O(logn)
     * @return
     */
    public T poll(){
        if(isValid()){
            T top = data.get(0);
            swap(0,data.size()-1);
            data.remove(data.size()-1);
            heaplifyDown(0);
            return top;
        }else{
            return null;
        }}
    public T peek(){
        if(isValid()){
            return data.get(0);
        }else{
            return null;
        }}

    /**
     * 1. find the left and right index, check with in list
     * 2. find the smallest among itself and 2 children
     * 3. make sure the smallest is the parent, if not the current parent
     * 4. recursively call it self using the same value in lower level
     * O(logn)
     * @param index
     */
    private void heaplifyDown(int index){
        int smallest=index;
        int left=2*index+1;
        int right=2*index+2;
        if(left<data.size()&&data.get(left).compareTo(data.get(smallest))<0){
            smallest=left;
        }
        if(right<data.size()&&data.get(right).compareTo(data.get(smallest))<0){
            smallest=right;
        }
        if(smallest!=index){
            swap(index,smallest);
            heaplifyDown(smallest);
        }}

    /**
     * 1. find the parent index
     * 2. if the parent is larger, move up
     * 3. finish when no more parent is larger
     * O(logn)
     * @param index
     */
    private void heaplifyUp(int index){
        int curr=index;
        int parent=(index-1)/2;

        while(parent>=0&&data.get(parent).compareTo(data.get(curr))>0){
            swap(parent,curr);
            curr=parent;
            parent=(curr-1)/2;
        }}
    private boolean isValid(){
        if(data==null||data.isEmpty()){
            System.err.println("heap data is not valid");
            return false;
        }
        return true;
    }
    private void swap(int left,int right){
        if(data.get(left)!=null&&data.get(right)!=null){
            T temp=data.get(left);
            data.set(left,data.get(right));
            data.set(right,temp);
        }else{
            System.err.println("invalid left or/and right index");
        }
    }
}
