package dataStructures;

/**
 * Created by qun.chen on 24/4/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StacksBalancedBrackets {

    public static boolean isBalanced(String expression) {
        Stack<Character> stacks=new Stack<>();
        char[] characters=expression.toCharArray();
        for(Character c:characters){
            if(c=='('||c=='['||c=='{'){
                stacks.push(c);
            }else if(c==')'){
                if(stacks.isEmpty()||stacks.pop()!='('){
                    return false;
                }
            }else if(c==']'){
                if(stacks.isEmpty()||stacks.pop()!='['){
                    return false;
                }
            }
            else if(c=='}'){
                if(stacks.isEmpty()||stacks.pop()!='{'){
                    return false;
                }
            }
        }
        if(!stacks.isEmpty()){
            return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}