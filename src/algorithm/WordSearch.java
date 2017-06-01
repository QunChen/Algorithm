package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qun.chen on 21/5/17.
 */
public class WordSearch {

    public static void main(String[] argv){
        char[][] board={{'A','B','C','E'},{'S','F','E','S'}
        ,{'A','D','E','E'}};
        String word="ABCESEEEFS";
        WordSearch search=new WordSearch();
        System.out.print(search.exist(board,word));
    }


    public boolean exist(char[][] board, String word) {
        if(word==null||word.length()==0||board==null){
            return false;
        }
        char[] chars=word.toCharArray();
        Set<List<Integer>> visited= new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(existRecurssion(board,i,j,chars,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existRecurssion(char[][] board,int row,int col,char[] chars,int index,Set<List<Integer>> visited){
        if(row<0||col<0||row>=board.length||col>=board[0].length){
            return false;
        }

        if(visited.contains(toList(row,col))){
            return false;
        }

        if(index==chars.length){
            return true;
        }

        if(chars[index]==board[row][col]){//0,1 a
            visited.add(toList(row,col));//

            System.out.println(row+":"+col+"->"+board[row][col]);


            boolean result= existRecurssion(board,row-1,col,chars,index+1,visited)||//-1,1 C false / -1,2 false /0,2 f    /1,2 false
                    existRecurssion(board,row+1,col,chars,index+1,visited)||//1,1 C false  / 1,2 C true /2,2 e t  /3,2 d f
                    existRecurssion(board,row,col-1,chars,index+1,visited)||//0,0 C false  / 0,1 false  /1,1 e f  /2,1 d t
                    existRecurssion(board,row,col+1,chars,index+1,visited);//0,2 C true   / 0,3 C false /1,3 e f /2,3 d f
            visited.remove(toList(row,col));
            return result;

        }else{
            return false;
        }


    }

    private List<Integer> toList(int row, int col){
        List<Integer> list = Arrays.asList(new Integer[]{row,col});
        return list;
    }
}
