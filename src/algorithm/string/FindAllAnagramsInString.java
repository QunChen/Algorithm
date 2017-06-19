package algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qun.chen on 9/6/17.
 */
public class FindAllAnagramsInString {

    public static void main(String[] argv){
        String s1="cbaebabacd";
        String p1= "abc";
        String s2= "abab";
        String p2= "ab";
        FindAllAnagramsInString findAllAnagramsInString=new FindAllAnagramsInString();
        System.out.println(findAllAnagramsInString.findAnagrams(s1,p1));
        System.out.println(findAllAnagramsInString.findAnagrams(s2,p2));
    }

    /**
     * create an array as a map for number of each character
     * create a window of same size of target
     * check anagram and reset target map
     * O(s.length*p.length)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] map=new int[26];
        for(char c:p.toCharArray()){
            map[c-'a']++;
        }
        char[] chars=s.toCharArray();

        int step=p.length();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length()-step+1;i++){

            char[] temp=new char[step];
            System.arraycopy(chars,i,temp,0,step);

            if(isAnagram(temp,map)){
                result.add(i);
            }
            map=new int[26];
            for(char c:p.toCharArray()){
                map[c-'a']++;
            }
        }
        return result;
    }

    /**
     * if number of each character is equal
     * O(n)
     * @param query
     * @param map
     * @return
     */
    private boolean isAnagram(char[] query, int[] map){
        for(int i:query){
            if(map[i-'a']==0){
                return false;
            }else{
                map[i-'a']--;
            }
        }
        return true;
    }
}
