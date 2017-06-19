package algorithm.math;

import java.util.Stack;

/**
 * Created by qun.chen on 28/5/17.
 */
public class LargestRectangleArea {

    public static void main(String[] argv){
        LargestRectangleArea largestRectangleArea=new LargestRectangleArea();
        int[] heights={3,5,2};
        System.out.print(largestRectangleArea.largestRectangleArea(heights));
    }

    /**
     * 1. use a stack to store latest max height
     * 2. for a new height, if the stack is null or the next height is higher, just add
     * 3. otherwise, calculate the size using the stored min index to calculate
     * a. if no more index , use the min * index to array start
     * b. other wise, use the min * index to previous smaller index
     * 4. then compare with the next one in stack and repeat step 3
     * 5. if more index left, using from end to its previous min index as the lengt
     * 6. if no more index, this is the minimal height, use the the full length
     * 7. in step 3456, update the maxsize
     * O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }

        Stack<Integer> stack=new Stack<>();

        int i=0;
        int maxSize=Integer.MIN_VALUE;
        while(i<heights.length){
            if(stack.isEmpty()||heights[i]>=heights[stack.peek()]){
                stack.add(i);
                i++;
            }else{
                int index=stack.pop();
                if(stack.isEmpty()){
                    maxSize=Math.max(heights[index]*i,maxSize);
                }else{
                    if(stack.isEmpty()){
                        maxSize=Math.max(heights[index]*(i-index),maxSize);
                    }else{
                        maxSize=Math.max(heights[index]*(i-stack.peek()-1),maxSize);
                    }

                }
            }
        }

        while(!stack.isEmpty()){
            int index=stack.pop();
            if(!stack.isEmpty()){
                maxSize=Math.max(heights[index]*(heights.length-stack.peek()-1),maxSize);
            }else{
                maxSize=Math.max(heights[index]*(heights.length),maxSize);
            }

        }

        return maxSize;
    }
}
