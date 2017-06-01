package algorithm;

import java.util.Stack;

/**
 * Created by qun.chen on 28/5/17.
 */
public class LargestRectangleArea {

    public static void main(String[] argv){
        LargestRectangleArea largestRectangleArea=new LargestRectangleArea();
        int[] heights={2,1,2};
        System.out.print(largestRectangleArea.largestRectangleArea(heights));
    }

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
