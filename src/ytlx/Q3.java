package ytlx;

/**
 * Created by qun.chen on 25/4/17.
 */

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Q3 {
    static String getChar(int i){
        String c="";
        switch(i){
            case 0: c="0";
                break;
            case 1: c="a";
                break;
            case 2: c="t";
                break;
            case 3: c="l";
                break;
            case 4: c="s";
                break;
            case 5: c="i";
                break;
            case 6: c="n";
                break;

        }
        return c;
    }

    static String convert(long input) {
        String result="";
        long total=input;
        while(total>0){
            int reminder=(int)total%7;
            result=getChar(reminder)+result;
            total=total/7;
        }
        return result;

    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);

        String res;
        long _in;
        _in = Long.parseLong(in.nextLine());

        res = convert(_in);
        System.out.print(res);
    }
}