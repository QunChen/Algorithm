package algorithm;

/**
 * Created by qun.chen on 25/5/17.
 */
public class UniquePaths {

    public static void main(String[] argv){
        uniquePaths(4,3);
    }

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
