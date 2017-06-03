package algorithm.dp;

/**
 * Created by qun.chen on 25/5/17.
 */
public class DicesSum {

    public static void main(String[] argv){
        System.out.print(sum(3,6,9));
    }

    /**
     * DP
     * 1. create a 2d array,to store possible ways, the row is number of dices, the column is the target value
     * 2. initial first column equals 1 for all n possible result, because 1 dice only have
     * ont way to get the value
     * 3. then add one more dice and the for this dice to get a particular value, there are several combinations
     * first choose all possible values under target, can then find the value in the previous column that can
     * make the total equals to target, sum all possible combinations, then it will be the value of ways for current
     * target(t) using current number(n).
     * 4. after finished, just return the value in the cell storing
     * the required number of dices at the target value
     * O(mnt)
     * @param m
     * @param n
     * @param t
     * @return
     */
    public static int sum(int m, int n, int t){
        if(t<=0||m<=0||n<=0){
            return 0;
        }

        if(m*n<t){
            return 0;
        }

        if(n>t){
            return 0;
        }

        if(m*n==t){
            return 1;
        }

        int[][] martix=new int[m+1][t+1];

        if(n<t){
            for(int i=1;i<=n;i++){
                martix[1][i]=1;
            }
        }else{
            for(int i=1;i<=t;i++){
                martix[1][i]=1;
            }
        }
        //matrix[i][j]= matrix[i-1][j-1]+matrix[i-1][j-2]+...matrix[i-1][j-n+1]+matrix[i-1][j-n]
        for(int i=2;i<=m;i++){
            for(int j=i;j<=t;j++){
                for(int k=j-n;k<j;k++){
                    martix[i][j]+=getValue(martix,i-1,k);
                }
            }
        }
        //matrix[i][j]= matrix[i-1][j-1]+matrix[i-1][j-2]+...matrix[i-1][j-n+1]+matrix[i-1][j-n]
        return martix[m][t];
    }

    private static int getValue(int[][]matrix,int row,int col){
        if(row<0||col<0){
            return 0;
        }
        return matrix[row][col];
    }
}
