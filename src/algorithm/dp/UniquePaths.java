package algorithm.dp;

/**
 * Created by qun.chen on 25/5/17.
 */
public class UniquePaths {

    public static void main(String[] argv){
        uniquePaths(4,3);
    }

    /**
     * check whether the first is the destination
     * create a m*n 2d array for remembering value from top and left
     * then find path
     * O(mn)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] memory=new int[m][n];

        if(m==0||n==0){
            return 0;
        }

        if(m==1||n==1){
            return 1;
        }

        return findPath(1,1,m,n,memory);
    }

    /**
     * recursion
     * base case: out of boundary, return 0
     * 1. if the result is cached, return cached value
     * 2. if get to destination, return 1
     * 3. recursively find path from bottom and right and sum
     * 4. set the memory for each cell from recursion call stack, nearest to far.
     * 4. return the bottom right value
     * O(mn)
     * @param row
     * @param col
     * @param m
     * @param n
     * @param memory
     * @return
     */
    private static int findPath(int row, int col,int m, int n,int[][] memory){
        if(row>m||col>n){
            return 0;
        }
        if(memory[row-1][col-1]>0){
            return memory[row-1][col-1];
        }
        if(row==m&&col==n){
            return 1;
        }

        int pathNumber=findPath(row+1,col,m,n,memory)+findPath(row,col+1,m,n,memory);
        memory[row-1][col-1]=pathNumber;
        return pathNumber;
    }

}
