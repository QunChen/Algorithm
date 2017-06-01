package ytlx;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Q1 {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int a_i=0; a_i < n; a_i++){
            list.add(in.nextInt());
        }
        int m = in.nextInt();
        List<Integer> sublist = new ArrayList<>();
        for(int a_i=0; a_i < m; a_i++){
            sublist.add(in.nextInt());
        }
        if(list.isEmpty()||sublist.isEmpty()){
            System.out.print(-1);
        }
       System.out.print(Collections.indexOfSubList(list,sublist));
    }
}