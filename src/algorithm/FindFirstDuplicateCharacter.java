package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 20/5/17.
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
