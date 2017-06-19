package algorithm.list;

/**
 * Created by qun.chen on 4/6/17.
 */
public class SetMatrixZeroes {

    /**
     * use the first row and col to remember which row and col should be 0.
     * also check whether the first the row and col has any 0
     * look all cells, if found 0, make the first element of its row and col to 0
     * look first row and col, if is 0, make the whole row and col 0.
     * if the first row and col has zero initially, make them all 0.
     * Time:O(mn)
     * Space:O(1)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if(matrix==null){
            return;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        boolean firstRow=false;
        boolean firstCol=false;


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    if(i==0){
                        firstRow=true;
                    }
                    if(j==0){
                        firstCol=true;
                    }
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRow){
            for(int i=0;i<col;i++){
                matrix[0][i]=0;
            }
        }

        if(firstCol){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }
}
