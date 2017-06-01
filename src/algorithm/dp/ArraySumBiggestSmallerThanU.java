package algorithm.dp;

import java.util.Arrays;

/**
 * Created by qun.chen on 21/5/17.
 * 1. find the min in each row
 * 2. transform the matrix that stores the difference of each cell to the min in that row
 * 3. calculate the minimal sum by summing min in each row
 * 4. recursively find the combination of each rows, find the closest to the U
 *      recursive function: subtract the current value and then use the remaining for the next row
 * Time: O(n^m)
 * Space: O(mn)
 * Idea:  may use dp or memorization to improve
 */
public class ArraySumBiggestSmallerThanU {

    private static int mintop;

    public static void main(String[] argv){
    int[][] matrix={{1,2,3},{2,5,6},{3,8,9}};
    mintop=Integer.MAX_VALUE;
    findMax(15,matrix);
    System.out.print(15-mintop);
    }

    /**
     * O(n^m)
     * @param top
     * @param matrix
     * @return
     */
    public static int findMax(int top, int[][]matrix){
        int[] mins=findMins(matrix);
        int[][] transformedMatrix=transform(matrix,mins);

        int sum=findSumMins(mins);

        findMaxInArray(top-sum,transformedMatrix,0);
        return mintop;
    }

    /**
     * O(n)
     * @param mins
     * @return
     */
    private static int findSumMins(int[] mins){
        int sum=0;
        for(int i:mins){
            sum+=i;
        }
        return sum;
    }

    /**
     * O(n^m)
     * @param top
     * @param matrix
     * @param row
     * @return
     */
    private static int findMaxInArray(int top,int[][] matrix,int row){
        if(row>=matrix.length){
            if(top<mintop)
            {
                mintop=top;
            }
//            System.out.println(top);
            return top;
        }


        int[] array=matrix[row];
        for(int i=0;i<array.length;i++){
//            System.out.print(Arrays.toString(array)+":"+array[i]);
            if(array[i]<top){
                findMaxInArray(top-array[i],matrix,row+1);
            }
        }

        return top;
    }

    /**
     * O(n^2)
     */
    private static int[] findMins(int[][] matrix){
        int[] mins=new int[matrix.length];
        Arrays.fill(mins,Integer.MAX_VALUE);
        for(int i=0;i<matrix.length;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
            mins[i]=min;
        }
        return mins;
    }

    /**
     *  O(n^2)
     */
    private static int[][] transform(int[][] matrix, int[] mins){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]-=mins[i];
            }
        }
        return matrix;
    }

}
