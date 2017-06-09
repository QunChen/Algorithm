package algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qun.chen on 9/6/17.
 */
public class RepeatedSubstringPattern {

    public static void main(String[] argv){
        RepeatedSubstringPattern repeatedSubstringPattern=new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abc"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        boolean result=true;
        boolean isdivided=false;
        int n=s.length();
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                isdivided=true;
                if(!isRepeated(s,i)){
                     result=false;
                }else{
                    result=true;
                    break;
                }
            }
        }
        return result&&isdivided;
    }

    private boolean isRepeated(String s, int size){
        Set<String> set=new HashSet();
        set.add(s.substring(0,size));
        for(int i=1;i<s.length()/size;i++){
            if(!set.contains(s.substring(i*size,(i+1)*size))){
                return false;
            }
        }
        return true;
    }
}
