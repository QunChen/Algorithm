package algorithm.graph;

import java.util.Arrays;

/**
 * Created by qun.chen on 9/5/17.
 */
public class MatrixPathFinder {


    public static void main(String[] argv){
        int[][] matrix={{0,1,1,0,0},{1,1,0,1,0},{0,1,1,0,0},{1,0,1,0,0}};
        boolean[][] visited={{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false}};

        System.out.print(findPath(matrix,visited,0,1,3,4));
    }


    public static boolean findPath(int[][] matrix,boolean[][] visited,int startRow,int startCol,int targetRow,int targetCol){
        if(startRow<0||startRow>matrix.length-1||startCol<0||startCol>matrix[0].length-1){
            return false;
        }

        if(visited[startRow][startCol]){
            return false;
        }

        if(startRow==targetRow&&startCol==targetCol){
            return true;
        }

        if(matrix[startRow][startCol]==1){
            visited[startRow][startCol]=true;

            return findPath(matrix,visited,startRow-1,startCol,targetRow,targetCol)||
                    findPath(matrix,visited,startRow+1,startCol,targetRow,targetCol)||
                    findPath(matrix,visited,startRow,startCol+1,targetRow,targetCol)||
                    findPath(matrix,visited,startRow,startCol-1,targetRow,targetCol)||
                    findPath(matrix,visited,startRow-1,startCol-1,targetRow,targetCol)||
                    findPath(matrix,visited,startRow-1,startCol+1,targetRow,targetCol)||
                    findPath(matrix,visited,startRow+1,startCol-1,targetRow,targetCol)||
                    findPath(matrix,visited,startRow+1,startCol+1,targetRow,targetCol);
        }else{
            return  false;
        }
    }
}
