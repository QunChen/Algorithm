package ytlx;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Q2 {
    static String process(String start){
        char[] chars=start.toCharArray();
        int num=0;
        int temp=Character.getNumericValue(chars[0]);
        String result="";
        for(int i=0;i<chars.length;i++){
            int value =Character.getNumericValue(chars[i]);
            if(value==temp){
                num++;
            }else{
                result+=num+""+Character.getNumericValue(chars[i-1]);
                num=1;
                temp=value;
            }
        }
        result+=num+""+Character.getNumericValue(chars[chars.length-1]);
        return result;
    }

    static String LookAndSay(String start, int n) {
        if(n==1){
            return process(start);
        }else{
            return LookAndSay(process(start),n-1);
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = LookAndSay(_start, _n);
        System.out.print(res);
    }
}