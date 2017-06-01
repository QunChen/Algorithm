package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qun.chen on 24/5/17.
 */
public class VirusMatrix {

    public static void main(String[] argv){
        int[][]matrix ={{2,1,1,1},{0,0,0,1},{1,1,1,0},{0,0,0,1}};

        VirusMatrix virusMatrix=new VirusMatrix();
        virusMatrix.effection(matrix,0,0);
    }

    public void effection(int[][] matrix, int startRow,int startCol){
        Queue<Integer[]> queue=new LinkedList<>();

        queue.add(new Integer[]{startRow,startCol});


        while(!queue.isEmpty()){
            Integer[] current = queue.poll();
            add(matrix,queue,current);
        }
    }

    private void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("--------");
    }

    private void add(int[][] matrix, Queue<Integer[]> queue, Integer[] current){
        int row=current[0];
        int col=current[1];
        for(int i=Math.max(row-1,0);i<=Math.min(row+1,matrix.length-1);i++){
            for(int j=Math.max(col-1,0);j<=Math.min(col+1,matrix[0].length-1);j++){
                if(matrix[i][j]==1){
                    queue.add(new Integer[]{i,j});
                    matrix[i][j]=2;
                    printMatrix(matrix);
                }
            }
        }
    }
}
