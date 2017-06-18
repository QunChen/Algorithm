package algorithm.graph;

import java.util.*;

/**
 * Created by qun.chen on 170614.
 */
public class WordSearch2 {

    public static void main(String[] argv){
//        char[][] board={{'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}};
//
//        String[] words={"oath","pea","eat","rain"};

        char[][] board={{'a','b'},
                {'a','a'}};

        String[] words={"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        WordSearch2 wordSearch2=new WordSearch2();
        System.out.print(wordSearch2.findWords(board,words));
    }


    /**
     * create a result set, removing duplicate
     * create a visited map
     * create a trie and add all words
     * then find the word recursively
     * O(m^2n^2)
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        if(board==null||words==null){
            return new ArrayList<>();
        }

        Set<String> result=new HashSet<>();
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        TrieNode trie=new TrieNode(' ');

        for(String word:words){
            trie.add(word);
        }

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                findWords(board,trie,row,col,m,n,result,new StringBuilder(""),visited);
            }
        }

        List<String> results=new ArrayList<>();
        results.addAll(result);
        return results;
    }

    /**
     * status of the search result from trie
     */
    private  enum Status{
        INVALID,VALID,WORD
    }

    private  class TrieNode{
         private TrieNode[] children;
         private char val;
         private boolean isTerminated;

        /**
         * use a array to store 26 characters
         * @param val
         */
         public TrieNode(char val){
             children=new TrieNode[26];
             isTerminated=false;
             this.val=val;
         }

        /**
         * add new char as the child,old char will be used as parent to search next
         * make the node terminated when the word finished
         * O(length of word)
         * @param word
         */
         public void add(String word){
             char[] chars=word.toCharArray();
             TrieNode parent=this;
             for(int i=0;i<chars.length;i++){
                 if(parent.children[chars[i]-'a']==null){
                     TrieNode newNode= new TrieNode(chars[i]);

                     parent.children[chars[i]-'a']=newNode;
                 }
                 if(i==chars.length-1){
                     parent.children[chars[i]-'a'].isTerminated=true;
                 }
                 parent=parent.children[chars[i]-'a'];
             }
         }


         public Status search(String word){
             char[] chars=word.toCharArray();
             TrieNode node=this;
             for(int i=0;i<chars.length;i++){
                 node=node.children[chars[i]-'a'];
                 if(node==null){
                     return Status.INVALID;
                 }
             }
             if(node.isTerminated){
                 return Status.WORD;
             }else{
                 return Status.VALID;
             }
         }
    }

    /**
     * append the character and set the visited to true
     * if the query is invalid, backtracking and return
     * if the query is a word, add to result
     * find the word in 4 directions
     * backtracking when 4 directions are searched
     * O(mn)
     * @param board
     * @param trie
     * @param row
     * @param col
     * @param m
     * @param n
     * @param result
     * @param current
     * @param visited
     */
    private void findWords(char[][] board, TrieNode trie, int row, int col, int m, int n, Set<String> result, StringBuilder current, boolean[][] visited){
        if(row<0||row>=m||col<0||col>=n||visited[row][col]){
            return;
        }

        current.append(board[row][col]);
        visited[row][col]=true;
        Status status=trie.search(current.toString());
        if(status==Status.INVALID){
            current.setLength(current.length()-1);
            visited[row][col]=false;
            return;
        }else if(status==Status.WORD){
            result.add(current.toString());
        }

        findWords(board,trie,row+1,col,m,n,result,current,visited);
        findWords(board,trie,row,col+1,m,n,result,current,visited);
        findWords(board,trie,row-1,col,m,n,result,current,visited);
        findWords(board,trie,row,col-1,m,n,result,current,visited);

        current.setLength(current.length()-1);
        visited[row][col]=false;
    }
}
