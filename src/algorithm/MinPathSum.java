package algorithm;

/**
 * Created by qun.chen on 27/5/17.
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }

        if((0==grid.length-1)&&(0==grid[0].length-1)){
            return grid[grid.length-1][grid[0].length-1];
        }
        int[][] memory=new int[grid.length][grid[0].length];
        return findPath(grid,memory);
    }

    private int findPath(int[][] grid, int[][] memory){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(j-1<0&&i-1<0){
                    memory[i][j]=grid[i][j];
                }else if(j-1<0){
                    memory[i][j]=memory[i-1][j]+grid[i][j];
                }else if(i-1<0){
                    memory[i][j]=memory[i][j-1]+grid[i][j];
                }else{
                    memory[i][j]=Math.min(memory[i-1][j],memory[i][j-1])+grid[i][j];
                }
            }
        }

        return memory[grid.length-1][grid[0].length-1];
    }
}
