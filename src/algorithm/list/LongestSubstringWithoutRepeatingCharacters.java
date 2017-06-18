package algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 28/5/17.
 * add each character to a map, if find it in the map and within this substring,
 * get the size and compare with max, next substring will start from next element
 * O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }

        Map<Character,Integer> map=new HashMap<>();
        int maxSize=Integer.MIN_VALUE;
        int start=0;

        char[] chars=s.toCharArray();

        for(int i=0;i<chars.length;i++){
            if(!map.containsKey(chars[i])||map.get(chars[i])<start){
                if(i-start+1>maxSize){
                    maxSize=i-start+1;
                }
            }else{
                start=map.get(chars[i])+1;
            }
            map.put(chars[i],i);
        }
        return maxSize;
    }
}
