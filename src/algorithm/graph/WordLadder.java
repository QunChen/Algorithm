package algorithm.graph;

import java.util.*;

/**
 * Created by qun.chen on 12/5/17.
 * https://leetcode.com/problems/word-ladder
 * accepted
 */
public class WordLadder {

    public static void main(String[] argv) {
        String start = "abc";
        String end = "cbe";
        String[] wordList = {"abc", "adc", "ade", "cde", "cbe"};

        System.out.println(find(start, end, Arrays.asList(wordList)));
    }


    public static int find(String word, String end, List<String> dic) {
        Set<String> dictionary = new HashSet<>(dic);

        //check edge cases
        if (word == null || end == null || word.length() != end.length()) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        visited.add(word);

        Queue<String> queue = new LinkedList<>();
        queue.add(word);//queue:["ABC"]
        queue.add(null);
        int length = 1;//length:0
        while (!queue.isEmpty()) {
            //length:3
            String current = queue.poll();
            if (current == null) {
                length++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                //current:"BCC",queue:[]
                for (int i = 0; i < current.length(); i++) {
                    char[] chars = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {

                        if (chars[i] != c) {
                            chars[i] = c;
                            String s = new String(chars);
                            if (dictionary.contains(s)) {
                                if (s.equals(end)) {  //true
                                    return length + 1; //4
                                }
                                if (!visited.contains(s)) { //true
                                    queue.add(s);
                                    visited.add(s);//queue:["BCC"]
                                }
                            }


                        }
                    }
                }
            }
        }

        return 0;
    }
}
