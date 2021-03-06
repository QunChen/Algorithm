package algorithm.graph;

import java.util.Queue;

/**
 * Created by qun.chen on 10/5/17.
 */
public class FindIsland {

    /**
     * for each valid one, which is the separated with other valid cell
     * find the max size
     * O(mn)
     * @param argv
     */
    public static void main(String[] argv){
        int[][] matrix={{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        int count=0;
        int maxSize=Integer.MIN_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    count++;
                    int size=find(matrix,i,j);
                    if(size>maxSize){
                        maxSize=size;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    /**
     * recursively go to 8 directions when there is a way
     * recursive function   8func(directions)+1 (this one is eligible)
     * if traversed, flip it to unavailable
     * O(mn)
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    public static int find(int[][]matrix,int row,int col){
        if(row<0||row>matrix.length-1||col<0||col>matrix[0].length-1||matrix[row][col]==0){
            return 0;
        }else{
            matrix[row][col]=0;
           return 1+find(matrix,row-1,col-1)+
            find(matrix,row-1,col)+
            find(matrix,row-1,col+1)+
            find(matrix,row,col-1)+
            find(matrix,row,col+1)+
            find(matrix,row+1,col-1)+
            find(matrix,row+1,col)+
            find(matrix,row+1,col+1);

        }
    }
}
