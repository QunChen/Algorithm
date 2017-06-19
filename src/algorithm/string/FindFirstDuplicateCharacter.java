package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 20/5/17.
 * 1. create a map from character to index
 * 2. traverse the character, if not in then add, otherwise find the index
 * 3. return the index which is the last occurrence of the same character
 * O(n)
 */
public class FindFirstDuplicateCharacter {

    public static void main(String[] argv){
        System.out.print(findFirstDuplicateIndex("abcdefc"));
    }

    public static int findFirstDuplicateIndex(String s){
        if(s==null||s.length()==0){
            return -1;
        }
        Map<Character,Integer> map=new HashMap<>();//char -> index
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                return map.get(chars[i]);
            }else{
                map.put(chars[i],i);
            }
        }
        return -1;
    }
}
