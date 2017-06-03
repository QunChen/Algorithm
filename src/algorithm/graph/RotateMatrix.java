package algorithm.graph;

/**
 * Created by qun.chen on 9/5/17.
 */
//Rotate matrix by 90 degree
    /*
    1 2 3 4
5 6 7 8
9 0 1 2
3 4 5 6


3 9 5 1
4 0 6 2
5 1 7 3
6 2 8 4


s_r:0
e_r:3
s_c:0
e_c:3

1. top
1,2,3,4 -> to right
0,0 -> 0,3
0,1 -> 1,3
0,2 -> 2,3
0,3 -> 3,3
s_r,i -> i,e_r
s_r++//1

2. right
8,2,6 -> to bottom
1,3 -> 3,2
2,3 -> 3,1
3,3 -> 3,0
i,end_c -> end_c,e_r-i



3.bottom
5,4,3 -> to left
3,0 -> 0,0
3,1 -> 1,0
3.2 -> 2,0
e_r,i->i,s_r


4.left
5,9 -> to top
1,0 -> 0,2
2,0 -> 0,1
i,s_c -> s_c,e_r-i

     */

/**
 * another easy way is following
 * construct the result using value in [m][n] to [n][m]
 * rotate to right, swap left half with right half
 * rotate to left, swap top half with bottom half
 * O(mn)
 */
public class RotateMatrix {

    public static void main(String[] argv){
        int[][] matrix={{1,2,3,4,5},{5,6,7,8,9},{9,0,1,2,3},{3,4,5,6,7}};
        print(matrix);
        int[][] rotate=rotate(matrix);
        System.out.println("Rotated");
        print(rotate);
    }

    public static void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }


    /**
     * 1. move 4 corners
     * 2. move top to right
     * 3. move right to bottom
     * 4. move bottom to left
     * 5. move left to top
     * move to inner matrix by updating start/end row/column
     * 6 when no more, finish
     * O(mn)
     * @param matrix
     * @return
     */
    public static int[][] rotate(int[][]matrix){
        int startRow=0;
        int endRow=matrix.length-1;
        int startCol=0;
        int endCol=matrix[0].length-1;
        int[][] rotated=new int[endCol+1][endRow+1];

        while(startRow<=endRow&&startCol<=endCol){
            moveCorners(matrix,rotated,startRow,endRow,startCol,endCol);
            topToRight(matrix,rotated,startRow,endRow,startCol,endCol);
            rightToBottom(matrix,rotated,startRow,endRow,startCol,endCol);
            bottomToLeft(matrix,rotated,startRow,endRow,startCol,endCol);
            leftToTop(matrix,rotated,startRow,endRow,startCol,endCol);
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return  rotated;
    }

    public static void moveCorners(int[][]matrix,int[][]rotated,int startRow,
                                   int endRow,int startCol,int endCol){
        rotated[startCol][endRow]=matrix[startRow][startCol];
        rotated[endCol][endRow]=matrix[startRow][endCol];
        rotated[endCol][startRow]=matrix[endRow][endCol];
        rotated[startCol][startRow]=matrix[endRow][startCol];
    }

    public static void topToRight(int[][]matrix,int[][]rotated,int startRow,
                                  int endRow,int startCol,int endCol){
        for(int i=startCol+1;i<endCol;i++){
            rotated[i][endRow]=matrix[startRow][i];
        }
    }

    public static void rightToBottom(int[][]matrix,int[][]rotated,int startRow,
                                  int endRow,int startCol,int endCol){
        for(int i=startRow+1;i<endRow;i++){
            rotated[endCol][endRow-i]=matrix[i][endCol];
        }
    }

    public static void bottomToLeft(int[][]matrix,int[][]rotated,int startRow,
                                  int endRow,int startCol,int endCol){
        for(int i=startCol+1;i<endCol;i++){
            rotated[i][startRow]=matrix[endRow][i];
        }
    }

    public static void leftToTop(int[][]matrix,int[][]rotated,int startRow,
                                     int endRow,int startCol,int endCol){
        for(int i=startRow+1;i<endRow;i++){
            rotated[startCol][endRow-i]=matrix[i][startCol];
        }
    }
}
