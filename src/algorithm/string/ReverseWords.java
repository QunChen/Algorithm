package algorithm.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by qun.chen on 10/6/17.
 */
public class ReverseWords {

    public static void main(String[] argv){
        ReverseWords reverseWords=new ReverseWords();
        System.out.println(reverseWords.reverseWords("   a   b "));
    }

    public String reverseWords(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        String[] words=s.trim().split(" ");
        Stack<String> stack = new Stack<>();
        for(String w:words){
            if(!w.equals("")){
                stack.push(w);
            }
        }

        if(stack.isEmpty()){
            return "";
        }

        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        String result=sb.toString();
        return result.substring(0,result.length()-1);
    }
}
