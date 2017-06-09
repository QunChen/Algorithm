package algorithm.data_structure;

/**
 * Created by qun.chen on 24/4/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TriesContacts {

    public static void main(String[] args) {

        TrieNode root = new TrieNode();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            if (op.equals("add")) {
                root.addWord(contact);
            } else if (op.equals("find")) {
                int number = root.findWord(contact);
                System.out.println(number);
            }
        }
    }


    /**
     * use a map to store all children
     * use a boolean to mark it terminated
     */
    public static class TrieNode {
        private Map<Character,TrieNode> children;
        private boolean isWord;
        private char character;

        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }

        public TrieNode(char character) {
            this();
            this.character = character;
        }

        /**
         * 1. find out the first character is not in the children
         * 2. then add a new children
         * 3. set the word true
         * O(logn)
         */
        protected void addWord(String word) {
            int length = word.length();
            TrieNode next = this;
            for (int i = 0; i < length; i++) {
                char charPos = word.charAt(i);

                if(!next.children.containsKey(charPos)){
                    next.children.put(charPos,new TrieNode(word.charAt(i)));
                }

                next=next.children.get(charPos);
            }
            next.isWord = true;
        }

        /**
         * look through all character
         * if not all characters are found, return 0
         * O(logn)
         * @param word
         * @return
         */
        protected int findWord(String word) {
            int length = word.length();
            TrieNode next = this;
            for (int i = 0; i < length; i++) {
                char charPos = word.charAt(i);

                if(next.children.isEmpty()){
                    return 0;
                }

                if(next.children.containsKey(charPos)){
                    next = next.children.get(charPos);
                }else{
                    if(word.length()>1){
                        return 0;
                    }
                    break;
                }
            }

            return occurrencesOfChar(next);
        }

        /**
         * use the current node to find number of children
         * add the current node to stack
         * if it is a word, add occurrence
         * when  not more children, finish
         * @param node
         * @return
         */
        public int occurrencesOfChar(TrieNode node) {

            Stack<TrieNode> stacks = new Stack<>();
            stacks.push(node);
            int occ = 0;

            while (!stacks.isEmpty()) {
                TrieNode next = stacks.pop();

                if (next.isWord) {
                    occ++;
                }
                for (TrieNode child : next.children.values()) {
                    stacks.push(child);
                }
            }

            return occ;
        }

    }
}
